package pacman;

import javax.swing.*;


public class OknoWyniki extends JFrame {


    private JList list1;
    private JPanel panelWyniki;

    public OknoWyniki() {

        super("Najlepsze wyniki");
        setContentPane(panelWyniki);


        pack();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setVisible(true);
}}