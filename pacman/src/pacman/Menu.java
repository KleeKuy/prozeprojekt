package pacman;

import javax.swing.*;

import static pacman.Config.getData;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * Okno główne gry
 */
public class Menu extends JFrame{
    private JPanel PacManPanel;
    private JTextArea pacManGameTextArea;
    private JButton Button1;
    private JButton Button2;
    private JButton Button3;
    private JButton Button4;
    private Menu menu;


    /**
     * Konstruktor głównego menu
     */
    public Menu() {

        /**
         * Nadpisywanie parametru klasy nadrzędnej JFrame
         */
        super("PacMan");
       // setContentPane(PacManPanel);
        menu =this;
        PacManPanel = new JPanel();
        JPanel Panel2 = new JPanel();
        PacManPanel.setLayout(new BorderLayout());
        Panel2.setLayout(new BorderLayout());
        Button1 = new JButton();
        Button1.setPreferredSize(new Dimension(400,100));
        Button2 = new JButton();
        Button2.setPreferredSize(new Dimension(400,100));
        Button3 = new JButton();
        Button3.setPreferredSize(new Dimension(400,100));
        Button4 = new JButton();
        Button4.setPreferredSize(new Dimension(400,100));
        Button1.setText("Graj");
        Button2.setText("Wyniki");
        Button3.setText("Informacje");
        Button4.setText("Wyjscie z gry");
        Panel2.add(Button1,BorderLayout.NORTH);
        Panel2.add(Button2,BorderLayout.CENTER);
        Panel2.add(Button3,BorderLayout.SOUTH);
        PacManPanel.add(Panel2,BorderLayout.NORTH);
        PacManPanel.add(Button4,BorderLayout.SOUTH);
        
        add(PacManPanel);
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
            public void actionPerformed(ActionEvent e2) {
                OknoNick nextWindowGame1;
				try {
					nextWindowGame1 = new OknoNick(menu);
	                nextWindowGame1.setVisible(true);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                setVisible(false);
             
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