package pacman;

import java.io.IOException;
import java.util.Properties;

import pacman.Okno1;
import pacman.OknoZakoncz;
import pacman.Plansza;
import pacman.Config;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Okno1m extends JFrame{
    private JPanel PacManPanel;
    private JTextArea pacManGameTextArea;
    private JButton Button1;
    private JButton Button2;
    private JButton Button3;
    private JButton Button4;



    public Okno1m() {
        super("PacMan");
        setContentPane(PacManPanel);

        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        setVisible(true);


        Button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                OknoZakoncz nextWindowEnd = new OknoZakoncz();
                nextWindowEnd.setVisible(true);
            }
        });
        Button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) throws IOException,InterruptedException {

                Plansza nextWindowGame = new Plansza();
                nextWindowGame.setVisible(true);

                Odczytplanszy con = new Odczytplanszy();
                char[][] pkty = con.odczytplanszy();
                int[] param = con.odczytparametrow();


                nextWindowGame.launchFrame(param[1],param[0],pkty);



            }
        });
        Button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
