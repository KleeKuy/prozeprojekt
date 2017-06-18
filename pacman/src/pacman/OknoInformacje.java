package pacman;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * Okno wyswietlajace informacje o grze i autorach
 */
public class OknoInformacje extends JFrame {
	
	     /**
	      * Konstruktor tworzacy okno
	      */
	    public OknoInformacje() {

	        super("Informacje");

	        JPanel PanelInfo = new JPanel();
	        JTextArea textArea = new JTextArea();
	        textArea.setPreferredSize(new Dimension(800,300));
	        String info = Config.getData("Info");
			textArea.append(info);
			textArea.setFont(textArea.getFont().deriveFont(17f)); 
	        
			PanelInfo.add(textArea);
	        add(PanelInfo);

	        
	        pack();
	        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);	    



	}
	    }

