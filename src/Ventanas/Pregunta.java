package Ventanas;

import static ManejoDatos.ManejoDatos.*;

import ManejoJugador.ManejoJugador;
import domain.Partida;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Pregunta extends JFrame {
    private JPanel contentPane;
    private JRadioButton radioBtn1;
    private JRadioButton radioBtn2;
    private JRadioButton radioBtn3;
    private JRadioButton radioBtn4;
    Partida partida = new Partida();
    ManejoJugador mj = new ManejoJugador();

    /*En la ventana pregunta es donde se despliegan estas con sus correspondientes respuestas.
     * Pregunta recibe un parametro que le indica en que ronda nos ubicamos, empezando en 1 e incremendanto
     * a medida que se avanza*/

    public Pregunta(int ronda) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 300);
        contentPane = new JPanel();
        setLocationRelativeTo(null);
        contentPane.setBackground(new Color(0, 120, 215));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        this.setResizable(false);

        JTextArea PreguntaTxt = new JTextArea();
        PreguntaTxt.setForeground(Color.white);
        PreguntaTxt.setText("Texto largo que ocupa mas de una linea segurisimo");
        PreguntaTxt.setBackground(new Color(0, 120, 215));
        PreguntaTxt.setFont(new Font("Verdana", Font.BOLD, 16));
        PreguntaTxt.setBounds(56, 66, 351, 59);
        contentPane.add(PreguntaTxt);
        PreguntaTxt.setWrapStyleWord(true);
        PreguntaTxt.setLineWrap(true);
        PreguntaTxt.setEditable(false);

        radioBtn1 = new JRadioButton("");
        radioBtn1.setSelected(true);
        radioBtn1.setForeground(Color.white);
        radioBtn1.setFont(new Font("Tahoma", Font.PLAIN, 12));
        radioBtn1.setBackground(new Color(0, 120, 215));
        radioBtn1.setBounds(21, 141, 161, 36);
        contentPane.add(radioBtn1);

        radioBtn2 = new JRadioButton("");
        radioBtn2.setForeground(Color.white);
        radioBtn2.setFont(new Font("Tahoma", Font.PLAIN, 12));
        radioBtn2.setBackground(new Color(0, 120, 215));
        radioBtn2.setBounds(194, 141, 148, 36);
        contentPane.add(radioBtn2);

        radioBtn3 = new JRadioButton("");
        radioBtn3.setForeground(Color.white);
        radioBtn3.setFont(new Font("Tahoma", Font.PLAIN, 12));
        radioBtn3.setBackground(new Color(0, 120, 215));
        radioBtn3.setBounds(21, 200, 161, 36);
        contentPane.add(radioBtn3);

        radioBtn4 = new JRadioButton("");
        radioBtn4.setForeground(Color.white);
        radioBtn4.setFont(new Font("Tahoma", Font.PLAIN, 12));
        radioBtn4.setBackground(new Color(0, 120, 215));
        radioBtn4.setBounds(194, 200, 148, 36);
        contentPane.add(radioBtn4);

        ButtonGroup grupo = new ButtonGroup();
        grupo.add(radioBtn1);
        grupo.add(radioBtn2);
        grupo.add(radioBtn3);
        grupo.add(radioBtn4);

        JLabel PuntuacionTxt = new JLabel("");
        PuntuacionTxt.setFont(new Font("Tahoma", Font.BOLD, 11));
        PuntuacionTxt.setBounds(368, 167, 103, 36);
        contentPane.add(PuntuacionTxt);

        JButton DaleBtn = new JButton("Dale!");
        DaleBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
        DaleBtn.setBounds(368, 200, 89, 36);
        contentPane.add(DaleBtn);

        JButton RetirarseBtn = new JButton("Abandonar");
        RetirarseBtn.setFont(new Font("Tahoma", Font.BOLD, 12));
        RetirarseBtn.setBounds(368, 160, 89, 36);
        contentPane.add(RetirarseBtn);

        /*Para seleccionar la pregunta al azar se usa este método que devuelve un número
         * aleatorio en el rango asignado*/
        int randomNum = ThreadLocalRandom.current().nextInt(1, 5 + 1);
        String pregunta = leerLinea("Preguntas" + ronda + ".txt", randomNum);

        /*Para mezclar las respuestas, se crea una lista de números y se la llena con los números
         * del 2 al 5, porque esas son las posiciones de las respuestas en el archivo.*/
        List<Integer> numeros = new ArrayList<>();
        for (int i = 2; i < 6; i++) numeros.add(i);
        Collections.shuffle(numeros);

        String respuesta = leerParte(pregunta, 2);
        PreguntaTxt.setText(leerParte(pregunta, 1));
        radioBtn1.setText(leerParte(pregunta, numeros.get(0)));
        radioBtn2.setText(leerParte(pregunta, numeros.get(1)));
        radioBtn3.setText(leerParte(pregunta, numeros.get(2)));
        radioBtn4.setText(leerParte(pregunta, numeros.get(3)));

        /*Al pulsar este botón, se define según el resultado del usuario si ganó o perdió, y como va
         * a continuar el programa*/
        DaleBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (botonPulsado().getText().equalsIgnoreCase(respuesta)) {
                    if (ronda < 5) {
                        String nombre = leerLinea("JugadorActual.txt", 1);
                        partida.setRonda("Ronda Nro " + ronda);
                        partida.setPuntos(ronda * 100);

                        Pregunta pregunta = new Pregunta(ronda + 1);
                        pregunta.setVisible(true);
                        Pregunta.this.dispose();
                    } else {
                        /*Si el jugador gana o pierde, se escribe una linea en el archivo de su historial
                         * con todos los detalles de la partida*/
                        String nombre = leerLinea("JugadorActual.txt", 1);
                        partida.setRonda("Ronda Nro " + ronda);
                        partida.setNombreJugador(nombre);
                        partida.setResultado("Ganada");
                        partida.setPuntos(ronda * 100);

                        escribir(partida.toString(), "Historial" + nombre + ".txt", true);

                        Victoria v = new Victoria("!Has ganado!", +mj.contarPuntos(nombre), mj.contarGanadas(nombre));
                        v.setVisible(true);
                        Pregunta.this.dispose();
                    }

                } else {
                    String nombre = leerLinea("JugadorActual.txt", 1);
                    partida.setRonda("Ronda Nro " + ronda);
                    partida.setNombreJugador(nombre);
                    partida.setResultado("Perdida");
                    partida.setPuntos((ronda * 100) - 100);

                    escribir(partida.toString(), "Historial" + nombre + ".txt", true);

                    Victoria v = new Victoria("Has perdido...", mj.contarPuntos(nombre), mj.contarGanadas(nombre));
                    v.setVisible(true);
                    Pregunta.this.dispose();
                }
            }
        });

        /*Botón con un comportamiento similar al anterior, salvo que este cierra el programa y guarda
        * el proceso como una partida de tipo "abandonada"*/
        RetirarseBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (botonPulsado().getText().equalsIgnoreCase(respuesta)) {

                    String nombre = leerLinea("JugadorActual.txt", 1);
                    partida.setRonda("Ronda Nro " + ronda);
                    partida.setNombreJugador(nombre);
                    partida.setResultado("Abandonada");
                    partida.setPuntos(ronda * 100);

                    escribir(partida.toString(), "Historial" + nombre + ".txt", true);

                    Pregunta.this.dispose();

                } else {
                    String nombre = leerLinea("JugadorActual.txt", 1);
                    partida.setRonda("Ronda Nro " + ronda);
                    partida.setNombreJugador(nombre);
                    partida.setResultado("Abandonada");
                    partida.setPuntos((ronda * 100) - 100);

                    escribir(partida.toString(), "Historial" + nombre + ".txt", true);

                    Pregunta.this.dispose();
                }

            }
        });
    }

    public JRadioButton botonPulsado() {
        JRadioButton boton = null;
        if (radioBtn1.isSelected()) boton = radioBtn1;
        if (radioBtn2.isSelected()) boton = radioBtn2;
        if (radioBtn3.isSelected()) boton = radioBtn3;
        if (radioBtn4.isSelected()) boton = radioBtn4;
        return boton;
    }
}
