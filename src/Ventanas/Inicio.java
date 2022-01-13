package Ventanas;

import ManejoJugador.SobrescrituraExcepcion;
import ManejoJugador.CuentaNulaExcepcion;
import ManejoJugador.ManejoJugador;
import domain.Jugador;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Inicio extends JFrame {
    private JPanel contentPane;
    private JTextField RegistroTxt;
    private JTextField IngresoTxt;

    public Inicio(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(200,200,500,300);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(0,120,215));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        this.setResizable(false);

        JLabel Campo = new JLabel("Bienvenido al juego");
        Campo.setForeground(SystemColor.text);
        Campo.setFont(new Font("Verdana", Font.BOLD, 24));
        Campo.setBounds(76, 33, 295, 32);
        contentPane.add(Campo);

        RegistroTxt = new JTextField();
        RegistroTxt.setBounds(52, 122, 154, 32);
        contentPane.add(RegistroTxt);
        RegistroTxt.setColumns(10);

        IngresoTxt = new JTextField();
        IngresoTxt.setBounds(52, 168, 154, 32);
        contentPane.add(IngresoTxt);
        IngresoTxt.setColumns(10);

        JLabel WarningTxt = new JLabel("Registrate para que tu progreso quede guardado!");
        WarningTxt.setFont(new Font("Yu Gothic", Font.BOLD, 14));
        WarningTxt.setBounds(52, 232, 335, 23);
        contentPane.add(WarningTxt);

        JButton RegistrarBtn = new JButton("Registrarse");
        RegistrarBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
        RegistrarBtn.setBounds(222, 122, 126, 32);
        contentPane.add(RegistrarBtn);

        JButton IngresarBtn = new JButton("Ingresar");
        IngresarBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
        IngresarBtn.setBounds(222, 168, 126, 32);
        contentPane.add(IngresarBtn);

        ManejoJugador mj = new ManejoJugador();
        RegistrarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    mj.Registrar(new Jugador(RegistroTxt.getText()));
                } catch (SobrescrituraExcepcion ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
                RegistroTxt.setText("");
            }
        });

        IngresarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String nombre = IngresoTxt.getText();
                    mj.Ingresar(nombre);
                    Inicio.this.dispose();
                    JFrame wlcm = new Bienvenida("Bienvenido al juego " + nombre+"!");
                    wlcm.setVisible(true);
                } catch (CuentaNulaExcepcion ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
                IngresoTxt.setText("");
            }
        });

    }
}
