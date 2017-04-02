package pacman;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.BorderLayout;
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
		
		Image obraz0 = new ImageIcon("C:/img/pusto.png").getImage();
		BufferedImage obraz = Plansza.toBufferedImage(obraz0);
		Image obraz02 = new ImageIcon("C:/img/pion.png").getImage();
		BufferedImage obraz2 = Plansza.toBufferedImage(obraz02);
		Image obraz03 = new ImageIcon("C:/img/poziom.png").getImage();
		BufferedImage obraz3 = Plansza.toBufferedImage(obraz03);
		Image obraz04 = new ImageIcon("C:/img/pacman.png").getImage();
		BufferedImage obraz4 = Plansza.toBufferedImage(obraz04);
		Image obraz05 = new ImageIcon("C:/img/duszek.png").getImage();
		BufferedImage obraz5 = Plansza.toBufferedImage(obraz05);
		obraz05=obraz5.getScaledInstance(32,32, Image.SCALE_DEFAULT);
	
		JPanel p = new JPanel(new GridLayout(wysokosc,szerokosc,0,0));
		JPanel mainpanel = new JPanel(new BorderLayout());
		
		JTextField wynik = new JTextField("Wynik");
		wynik.setEditable(false);
		JTextField zycia = new JTextField("Życia");
		zycia.setEditable(false);
		zycia.setHorizontalAlignment(JTextField.CENTER);
		
		mainpanel.add(wynik,BorderLayout.WEST);
		mainpanel.add(zycia,BorderLayout.CENTER);
		mainpanel.add(new JButton("Pauza"),BorderLayout.EAST);
		mainpanel.add(p,BorderLayout.SOUTH);
		add(mainpanel);
		boolean check = false;
		//add(p);

		
		int temp=10;
		
		while(true)
		{
			Rectangle re = this.getBounds();
	if(re.height+re.width!=temp)
	{
		if(check==true)
		{
		Rectangle r = this.getBounds();
		temp =r.width+r.height;
		obraz0=obraz.getScaledInstance((r.width-18)/szerokosc, (r.height-73)/wysokosc, Image.SCALE_DEFAULT);
		obraz02=obraz2.getScaledInstance((r.width-18)/szerokosc, (r.height-73)/wysokosc, Image.SCALE_DEFAULT);
		obraz03=obraz3.getScaledInstance((r.width-18)/szerokosc, (r.height-73)/wysokosc, Image.SCALE_DEFAULT);
		obraz04=obraz4.getScaledInstance((r.width-18)/szerokosc, (r.height-73)/wysokosc, Image.SCALE_DEFAULT);
		obraz05=obraz5.getScaledInstance((r.width-18)/szerokosc, (r.height-73)/wysokosc, Image.SCALE_DEFAULT);

		}
		int i=0;
		int j=0;
		p.removeAll();
		
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
