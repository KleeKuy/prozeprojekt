package pacman;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics2D;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
		//odczyt obrazkow z plikow
		Image obraz0 = new ImageIcon(getData("Pusto")).getImage();
		BufferedImage pusto = Plansza.toBufferedImage(obraz0);
		Image obraz02 = new ImageIcon(getData("Pion")).getImage();
		BufferedImage pion = Plansza.toBufferedImage(obraz02);
		Image obraz03 = new ImageIcon(getData("Poziom")).getImage();
		BufferedImage poziom = Plansza.toBufferedImage(obraz03);;
		Image obraz04 = new ImageIcon(getData("Pacman")).getImage();
		BufferedImage pacman = Plansza.toBufferedImage(obraz04);
		Image obraz05 = new ImageIcon(getData("Duszek")).getImage();
		BufferedImage duszek = Plansza.toBufferedImage(obraz05);
		obraz05=duszek.getScaledInstance(32,32, Image.SCALE_DEFAULT);
		Image obraz06 = new ImageIcon(getData("niebieskiDuszek")).getImage();
		BufferedImage nduszek = Plansza.toBufferedImage(obraz06);
		obraz06=nduszek.getScaledInstance(32,32, Image.SCALE_DEFAULT);
		
		//tworzenie paneli
		JPanel p = new JPanel(new GridLayout(wysokosc,szerokosc,0,0));
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
		
		//dodawanie komponentow do paneli
		mainpanel.add(wynik,BorderLayout.WEST);
		mainpanel.add(zycia,BorderLayout.CENTER);
		mainpanel.add(button,BorderLayout.EAST);
		mainpanel.add(p,BorderLayout.SOUTH);
		add(mainpanel);
		
		boolean check = false;
		int temp=10;
		
		while(true)
		{
			Rectangle re = this.getBounds();
	if(re.height+re.width!=temp)
	{
		
		//skalowanie
		if(check==true)
		{
		Rectangle r = this.getBounds();
		temp =r.width+r.height;
		obraz0=pusto.getScaledInstance((r.width-18)/szerokosc, (r.height-83)/wysokosc, Image.SCALE_DEFAULT);
		obraz02=pion.getScaledInstance((r.width-18)/szerokosc, (r.height-83)/wysokosc, Image.SCALE_DEFAULT);
		obraz03=poziom.getScaledInstance((r.width-18)/szerokosc, (r.height-83)/wysokosc, Image.SCALE_DEFAULT);
		obraz04=pacman.getScaledInstance((r.width-18)/szerokosc, (r.height-83)/wysokosc, Image.SCALE_DEFAULT);
		obraz05=duszek.getScaledInstance((r.width-18)/szerokosc, (r.height-83)/wysokosc, Image.SCALE_DEFAULT);
		obraz06=nduszek.getScaledInstance((r.width-18)/szerokosc, (r.height-83)/wysokosc, Image.SCALE_DEFAULT);
		}
		int i=0;
		int j=0;
		p.removeAll();
		//rysowanie planszy z tablicy odczytanej z pliku tekstowego
		  for(int k =0; k<szerokosc*wysokosc; ++k) {
		    	if(punkty[i][j]==' ')
				{
					p.add(new JLabel(new ImageIcon(obraz0)));
				}
				else if(punkty[i][j]=='|')
				{
					p.add(new JLabel(new ImageIcon(obraz02)));

				}
				else if(punkty[i][j]=='-')
				{
					p.add(new JLabel(new ImageIcon(obraz03)));

				}
				else if(punkty[i][j]=='p')
				{
					p.add(new JLabel(new ImageIcon(obraz04)));

				}	
				else if(punkty[i][j]=='d')
				{
					p.add(new JLabel(new ImageIcon(obraz05)));

				}
				else if(punkty[i][j]=='n')
				{
					p.add(new JLabel(new ImageIcon(obraz06)));

				}	
		    	i++;
		    	if(i==szerokosc)
				  {
					  i=0;
					  j++;
				  }
		    }

		pack();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				setVisible(true);
			}
		});

		
		check =true;


				
	}

	TimeUnit.MILLISECONDS.sleep(100);
		}
		
	
	


	
}}
