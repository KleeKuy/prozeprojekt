package pacman;

import java.awt.Image;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.Graphics2D;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import static pacman.Config.getData;

import java.util.concurrent.TimeUnit;

@SuppressWarnings("serial")
public class Plansza extends JFrame {

	
	public static BufferedImage toBufferedImage(Image img)
	{
	    if (img instanceof BufferedImage)
	    {
	        return (BufferedImage) img;
	    }

	    // Create a buffered image with transparency
	    BufferedImage bimage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);

	    // Draw the image on to the buffered image
	    Graphics2D bGr = bimage.createGraphics();
	    bGr.drawImage(img, 0, 0, null);
	    bGr.dispose();

	    // Return the buffered image
	    return bimage;
	}
	
	
	public void launchFrame(int wysokosc, int szerokosc,char[][] punkty) throws InterruptedException{
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(1);
			}
		});
	
		//tworzenie panelu
		JPanel mainpanel = new JPanel(new BorderLayout());

		
		
		//tworzenie komponentow interfejsu
		JTextField wynik = new JTextField("Wynik");
		wynik.setPreferredSize(new Dimension(100,35));
		wynik.setEditable(false);
		JTextField zycia = new JTextField("Życia " + getData("zycia"));
		zycia.setEditable(false);
		zycia.setHorizontalAlignment(JTextField.CENTER);
		JButton button = new JButton(getData("pauza"));
		button.setPreferredSize(new Dimension(100,40));
		
		//Obrazgra gra = new Obrazgra(wysokosc,szerokosc,punkty);
		   final Obrazgra gra = new Obrazgra(wysokosc,szerokosc,punkty);
		   
			//dodawanie komponentow do panelu
			mainpanel.add(wynik,BorderLayout.WEST);
			mainpanel.add(zycia,BorderLayout.CENTER);
			mainpanel.add(button,BorderLayout.EAST);
			mainpanel.add(gra,BorderLayout.SOUTH);
			add(mainpanel);
			//gra.zaladujplansze();
			
	        this.addComponentListener(new ComponentAdapter() {
	        	public void componentResized(ComponentEvent ce) {
	        		//gra.updateOffscreenSize(ce.getComponent().getWidth(), ce.getComponent().getHeight());
	        	}
	        });
		
	
		
		pack();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				setVisible(true);
			}
		});		
		(gra.kicker = new Thread(gra)).start();

	
}}
