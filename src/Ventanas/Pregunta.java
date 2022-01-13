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

    public Pregunta(int ronda){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(200,200,500,300);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(0,120,215));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        this.setResizable(false);

        JTextArea PreguntaTxt = new JTextArea();
        PreguntaTxt.setForeground(SystemColor.text);
        PreguntaTxt.setText("Texto largo que ocupa mas de una linea segurisimo");
        PreguntaTxt.setBackground(SystemColor.textHighlight);
        PreguntaTxt.setFont(new Font("Verdana", Font.BOLD, 16));
        PreguntaTxt.setBounds(56, 66, 351, 59);
        contentPane.add(PreguntaTxt);
        PreguntaTxt.setWrapStyleWord(true);
        PreguntaTxt.setLineWrap(true);
        PreguntaTxt.setEditable(false);

        radioBtn1 = new JRadioButton("");
        radioBtn1.setSelected(true);
        radioBtn1.setForeground(SystemColor.text);
        radioBtn1.setFont(new Font("Tahoma", Font.PLAIN, 12));
        radioBtn1.setBackground(SystemColor.textHighlight);
        radioBtn1.setBounds(21, 141, 161, 36);
        contentPane.add(radioBtn1);

        radioBtn2 = new JRadioButton("");
        radioBtn2.setForeground(SystemColor.text);
        radioBtn2.setFont(new Font("Tahoma", Font.PLAIN, 12));
        radioBtn2.setBackground(SystemColor.textHighlight);
        radioBtn2.setBounds(194, 141, 148, 36);
        contentPane.add(radioBtn2);

        radioBtn3 = new JRadioButton("");
        radioBtn3.setForeground(SystemColor.text);
        radioBtn3.setFont(new Font("Tahoma", Font.PLAIN, 12));
        radioBtn3.setBackground(SystemColor.textHighlight);
        radioBtn3.setBounds(21, 200, 161, 36);
        contentPane.add(radioBtn3);

        radioBtn4 = new JRadioButton("");
        radioBtn4.setForeground(SystemColor.text);
        radioBtn4.setFont(new Font("Tahoma", Font.PLAIN, 12));
        radioBtn4.setBackground(SystemColor.textHighlight);
        radioBtn4.setBounds(194, 200, 148, 36);
        contentPane.add(radioBtn4);

        ButtonGroup grupo = new ButtonGroup();
        grupo.add(radioBtn1);
        grupo.add(radioBtn2);
        grupo.add(radioBtn3);
        grupo.add(radioBtn4);

        JLabel PuntuacionTxt = new JLabel("");
        PuntuacionTxt.setFont(new Font("Tahoma", Font.BOLD, 12));
        PuntuacionTxt.setBounds(368, 167, 103, 36);
        contentPane.add(PuntuacionTxt);

        JButton DaleBtn = new JButton("Dale!");
        DaleBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
        DaleBtn.setBounds(368, 200, 89, 36);
        contentPane.add(DaleBtn);

        List<Integer> numeros = new ArrayList<>();
        for(int i = 2; i<6; i++) numeros.add(i);
        Collections.shuffle(numeros);
        int randomNum = ThreadLocalRandom.current().nextInt(1, 5 + 1);
        String pregunta = leerLinea("Preguntas"+ronda+".txt", randomNum);

        String respuesta = leerParte(pregunta, 2);
        PreguntaTxt.setText(leerParte(pregunta, 1));
        radioBtn1.setText(leerParte(pregunta, numeros.get(0)));
        radioBtn2.setText(leerParte(pregunta, numeros.get(1)));
        radioBtn3.setText(leerParte(pregunta, numeros.get(2)));
        radioBtn4.setText(leerParte(pregunta, numeros.get(3)));

        
        DaleBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(botonPulsado().getText().equalsIgnoreCase(respuesta)) {
                    if(ronda<5) {
                        String nombre = leerLinea("JugadorActual.txt", 1);
                        partida.setRonda("Ronda Nro "+ronda);
                        partida.setPuntos(ronda*100);

                        Pregunta.this.dispose();
                        Pregunta pregunta = new Pregunta(ronda + 1);
                        pregunta.setVisible(true);
                    }else{
                        String nombre = leerLinea("JugadorActual.txt", 1);
                        partida.setRonda("Ronda Nro "+ronda);
                        partida.setNombreJugador(nombre);
                        partida.setResultado("Ganada");
                        partida.setPuntos(ronda*100 );

                        escribir(partida.toString(),"Historial"+nombre+".txt",  true);

                        Pregunta.this.dispose();
                        Victoria v = new Victoria("!Has ganado!", + mj.contarPuntos(nombre), mj.contarGanadas(nombre));
                        v.setVisible(true);
                    }

                }else{
                    String nombre = leerLinea("JugadorActual.txt", 1);
                    partida.setRonda("Ronda Nro "+ronda);
                    partida.setNombreJugador(nombre);
                    partida.setResultado("Perdida");
                    partida.setPuntos((ronda*100)-100);

                    escribir(partida.toString(),"Historial"+nombre+".txt",true);

                    Pregunta.this.dispose();
                    Victoria v = new Victoria("Has perdido...",mj.contarPuntos(nombre), mj.contarGanadas(nombre));
                    v.setVisible(true);


                }
            }
        });
    }

    public JRadioButton botonPulsado(){
        JRadioButton boton = null;
        if(radioBtn1.isSelected()) boton = radioBtn1;
        if(radioBtn2.isSelected()) boton = radioBtn2;
        if(radioBtn3.isSelected()) boton = radioBtn3;
        if(radioBtn4.isSelected()) boton = radioBtn4;
        return boton;
    }
}
