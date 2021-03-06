package pacman;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Okno z zapytaniem czy zakonczyc gre
 */
public class OknoZakoncz extends JFrame {
    /**
     * Panel OknaZakoncz
     */
    private JPanel PanelZakoncz;
    /**
     * Przycisk potwierdzający chęć zakończenia programu
     */
    private JButton ButtonTak;
    /**
     * Przycisk odmawiający chęci zakończenia programu
     */
    private JButton ButtonNie;

    /**
     * Knstruktor okna służącego do zakończnia gry
     */
    public OknoZakoncz() {

        super("Czy zakończyć?");

        //Tworzenie przyciskow wyswietlanych w oknie
        PanelZakoncz = new JPanel();
        PanelZakoncz.setLayout(new FlowLayout());
        ButtonTak = new JButton();
        ButtonTak.setPreferredSize(new Dimension(150,150));
        ButtonNie = new JButton();
        ButtonNie.setPreferredSize(new Dimension(150,150));
        ButtonTak.setText("TAK");
        ButtonNie.setText("NIE");

        PanelZakoncz.add(ButtonTak);
        PanelZakoncz.add(ButtonNie);

        
        add(PanelZakoncz);

        pack();
        /**
         * Za naciśnięciem 'x' w górnym rogu okienka zostanie ono zamknięte z całym programem
         */
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /**
         * Okienko jest widoczne
         */
        setVisible(true);
        /**
         * Dodanie funkcji przyciskowi "NIE"
         */
        ButtonTak.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);

            }
        });
        /**
         * Nadanie funkcji przyciskowi "TAK"
         */
        ButtonNie.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
    }



}