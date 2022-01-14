package Ventanas;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Bienvenida extends JFrame {
    private JPanel contentPane;

    /*Ventana para dar la bienvenida al usuario con un mensaje personalizado*/

    public Bienvenida(String s) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 300);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(0, 120, 215));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        setLocationRelativeTo(null);
        contentPane.setLayout(null);
        this.setResizable(false);

        JLabel Campo = new JLabel(s);
        Campo.setForeground(Color.white);
        Campo.setFont(new Font("Verdana", Font.BOLD, 24));
        Campo.setBounds(38, 39, 422, 99);
        contentPane.add(Campo);

        JButton JugarBtn = new JButton("Jugar");
        JugarBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
        JugarBtn.setBounds(194, 184, 89, 37);
        contentPane.add(JugarBtn);

        JugarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame pregunta = new Pregunta(1);
                pregunta.setVisible(true);
                Bienvenida.this.dispose();
            }
        });
    }
}
