package Ventanas;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Victoria extends JFrame {

    private JPanel contentPane;

    /*Esta es la ventana final del programa, y recibe como parámetros
     * la información a desplegar en ella*/

    public Victoria(String resultado, int puntos, int partidas) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 300);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(0, 120, 215));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setLocationRelativeTo(null);
        setContentPane(contentPane);
        contentPane.setLayout(null);
        this.setResizable(false);

        JLabel VictoriaTxt = new JLabel(resultado);
        VictoriaTxt.setForeground(new Color(51, 255, 255));
        VictoriaTxt.setFont(new Font("MV Boli", Font.BOLD, 46));
        VictoriaTxt.setBounds(100, 22, 323, 90);
        contentPane.add(VictoriaTxt);

        JButton ReiniciarBtn = new JButton("Reiniciar juego");
        ReiniciarBtn.setFont(new Font("Tahoma", Font.BOLD, 10));
        ReiniciarBtn.setBounds(100, 227, 140, 23);
        contentPane.add(ReiniciarBtn);

        JLabel ProgresoTxt = new JLabel("Tu progreso se ha guardado!");
        ProgresoTxt.setFont(new Font("Tahoma", Font.BOLD, 14));
        ProgresoTxt.setBounds(100, 123, 227, 28);
        contentPane.add(ProgresoTxt);

        JLabel PartidasTxt = new JLabel("Partidas ganadas hasta ahora: " + partidas);
        PartidasTxt.setBounds(100, 162, 200, 14);
        contentPane.add(PartidasTxt);

        JLabel PuntosTxt = new JLabel("Total de puntos: " + puntos);
        PuntosTxt.setBounds(100, 187, 200, 14);
        contentPane.add(PuntosTxt);

        ReiniciarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Inicio inicio = new Inicio();
                inicio.setVisible(true);
                Victoria.this.dispose();
            }
        });
    }
}
