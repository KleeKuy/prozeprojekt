package pacman;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Alison on 2017-04-02.
 */
public class OknoZakoncz extends JFrame {
    private JPanel PanelZakoncz;
    private JButton ButtonTak;
    private JButton ButtonNie;


    public OknoZakoncz() {

        super("Zakończ");
        setContentPane(PanelZakoncz);


        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setVisible(true);
        ButtonTak.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);

            }
        });
        ButtonNie.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
    }



}