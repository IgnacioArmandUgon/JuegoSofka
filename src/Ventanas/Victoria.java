package Ventanas;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Victoria extends JFrame {

    private JPanel contentPane;

    public Victoria(String resultado, int puntos, int partidas) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(200,200,500,300);
        contentPane = new JPanel();
        contentPane.setBackground(SystemColor.textHighlight);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel VictoriaTxt = new JLabel(resultado);
        VictoriaTxt.setForeground(new Color(51, 255, 255));
        VictoriaTxt.setFont(new Font("MV Boli", Font.BOLD, 46));
        VictoriaTxt.setBounds(100, 22, 323, 90);
        contentPane.add(VictoriaTxt);

        JButton xBtn = new JButton("Cerrar juego");
        xBtn.setFont(new Font("Tahoma", Font.BOLD, 10));
        xBtn.setBounds(100, 237, 140, 23);
        contentPane.add(xBtn);

        JLabel ProgresoTxt = new JLabel("Tu progreso se ha guardado!");
        ProgresoTxt.setFont(new Font("Tahoma", Font.BOLD, 14));
        ProgresoTxt.setBounds(100, 123, 227, 28);
        contentPane.add(ProgresoTxt);

        JLabel PartidasTxt = new JLabel("Partidas jugadas hasta ahora: "+partidas);
        PartidasTxt.setBounds(100, 162, 200, 14);
        contentPane.add(PartidasTxt);

        JLabel PuntosTxt = new JLabel("Total de puntos: "+puntos);
        PuntosTxt.setBounds(100, 187, 200, 14);
        contentPane.add(PuntosTxt);
        this.setResizable(false);
        this.setUndecorated(true);

        xBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}
