package pacman;

import java.io.IOException;
import java.util.Properties;

import pacman.Okno1;
import pacman.OknoZakoncz;
import pacman.OknoWyniki;
import pacman.Plansza;
import pacman.Config;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Okno główne gry
 */
public class Okno1m extends JFrame{
    private JPanel PacManPanel;
    private JTextArea pacManGameTextArea;
    private JButton Button1;
    private JButton Button2;
    private JButton Button3;
    private JButton Button4;


    /**
     * Konstruktor głównego menu
     */
    public Okno1m() {

        /**
         * Nadpisywanie parametru klasy nadrzędnej JFrame
         */
        super("PacMan");

        setContentPane(PacManPanel);

        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        setVisible(true);


        /**
         * Funkcja pierwszego przycisku
         */
        Button1.addActionListener(new ActionListener() {
            @Override
            /**
             * Metoda opisująca dzisałanie drugiego przycisku w menu
             * @param e2 Obiekt interakcji z użytkownikiem
             */
            public void actionPerformed(ActionEvent e2)  {
                Plansza nextWindowGame = new Plansza();
                nextWindowGame.setVisible(true);

            }



        });

        /**
         * Funkcja drugiego przycisku
         */
        Button2.addActionListener(new ActionListener() {
            @Override
            /**
             * Metoda opisująca dzisałanie drugiego przycisku w menu
             * @param e Obiekt interakcji z użytkownikiem
             */
            public void actionPerformed(ActionEvent e) {
            OknoWyniki nextWindowScores = new OknoWyniki();
            nextWindowScores.setVisible(true);
            }
        });

        /**
         * Funkcja trzeciego przycisku
         */
        Button3.addActionListener(new ActionListener() {
            @Override
            /** Metoda opisująca dzisałanie trzeciego przycisku w menu
             * @param e Obiekt interakcji z użytkownikiem
             */
            public void actionPerformed(ActionEvent e) {

            }
        });


        /**
         * Funkcja czwartego przycisku
         */
        Button4.addActionListener(new ActionListener() {
            @Override
            /**
             * Metoda opisująca dzisałanie czwartego przycisku w menu
             * @param e Obiekt interakcji z użytkownikiem
             */
            public void actionPerformed(ActionEvent e) {

                OknoZakoncz nextWindowEnd = new OknoZakoncz();
                nextWindowEnd.setVisible(true);
            }
        });

    }
}