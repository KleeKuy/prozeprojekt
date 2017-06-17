package pacman;

import java.awt.Dimension;
import java.io.IOException;

import javax.swing.*;


public class OknoWyniki extends JFrame {


    private JPanel panelWyniki;
    private JTextArea textArea1;

    public OknoWyniki() {

        super("Najlepsze wyniki");

        panelWyniki = new JPanel();
        textArea1 = new JTextArea();
        textArea1.setPreferredSize(new Dimension(800,300));

        String wyniki = null;
		try {
			wyniki = LoadObjects.pobierzWyniki();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        //for(int i=0; i<wyniki.length; i++)
        textArea1.append("Wyniki:\n");
        textArea1.append(wyniki);
        textArea1.setFont(textArea1.getFont().deriveFont(17f)); 
        textArea1.setEditable(false);
        
        panelWyniki.add(textArea1);
        add(panelWyniki);

        
        pack();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setVisible(true);

        //LoadObjects loadObjects = new LoadObjects();
    



}}