package pacman;

import java.awt.Dimension;
import java.io.IOException;

import javax.swing.*;

/**
 * Okno wyswietlajace wyniki
 */
public class OknoWyniki extends JFrame {

	/**
	 * Glowny panel obiektu
	 */
    private JPanel panelWyniki;
    /**
     * Pole gdzie wyswietlane sa wyniki
     */
    private JTextArea textArea1;

    /**
     * Konstruktor obiektu
     */
    public OknoWyniki() {

        super("Najlepsze wyniki");

        panelWyniki = new JPanel();
        textArea1 = new JTextArea();
        textArea1.setPreferredSize(new Dimension(800,300));

        String wyniki = null;
        //Odczytywanie wynikow z pliku tekstowego
		try {
			wyniki = LoadObjects.pobierzWyniki();
		} catch (IOException e) {
			e.printStackTrace();
		}
        textArea1.append("Wyniki:\n");
        textArea1.append(wyniki);
        textArea1.setFont(textArea1.getFont().deriveFont(17f)); 
        textArea1.setEditable(false);
        
        panelWyniki.add(textArea1);
        add(panelWyniki);

        
        pack();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setVisible(true);
    



}}