package pacman;


import static pacman.Config.getData;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.concurrent.TimeUnit;

import javax.swing.ImageIcon;


public class Obrazgra extends Canvas implements Runnable{
	
	   private Image pion = null;
	   private Image pusto = null;
	   private Image poziom = null;
	   private Image pacman = null;
	//   private Image pacman1 = null;
	//   private Image pacman2 = null;
	 //  private Image pacman3 = null;
	//   private Image pacman4 = null;
	   private Image duszek = null;
	   private Image nduszek = null;
	   private Image offscreen = null;
	   private Graphics offscreeng = null;
	   private int szerokosc=0;
	   private int wysokosc=0;
	   private char[][] punkty;

	   Obrazgra(int wysokosc,int szerokosc,char[][] punkty) {
	        
	    	//odczyt obrazkow z plikow
	    	Image obraz0 = new ImageIcon(getData("Pusto")).getImage();
			this.pusto = obraz0;
			Image obraz02 = new ImageIcon(getData("Pion")).getImage();
			this.pion = obraz02;
			Image obraz03 = new ImageIcon(getData("Poziom")).getImage();
			this.poziom = obraz03;
			Image obraz04 = new ImageIcon(getData("Pacman")).getImage();
			this.pacman = obraz04;
			//Image obraz041 = new ImageIcon(getData("Pacman1")).getImage();
			//this.pacman1 = obraz041;
			//Image obraz042 = new ImageIcon(getData("Pacman2")).getImage();
			//this.pacman2 = obraz042;
			//Image obraz043 = new ImageIcon(getData("Pacman3")).getImage();
			//this.pacman3 = obraz043;
			//Image obraz044 = new ImageIcon(getData("Pacman4")).getImage();
			//this.pacman4 = obraz044;
			Image obraz05 = new ImageIcon(getData("Duszek")).getImage();
			this.duszek = obraz05;
			Image obraz06 = new ImageIcon(getData("niebieskiDuszek")).getImage();
			this.nduszek = obraz06;
			
		   
			this.szerokosc=szerokosc;
			this.wysokosc=wysokosc;
			this.punkty=punkty;
			
	    }

	    public Dimension getPreferredSize() {
	        return new Dimension(szerokosc*32, wysokosc*32);
	    }

	    public void addNotify() {
	        super.addNotify();
	        offscreen = createImage(getPreferredSize().width, getPreferredSize().height);
	        offscreeng = offscreen.getGraphics();
	    }
	    
	    public void update(Graphics g) {
	    	paint(g);
	    }
	    
	    public void paint(Graphics g) {
	    	g.drawImage(offscreen, 0, 0, this);
	    	
	}
	    
	    void updateOffscreen() {
	    	
	        
	    	//SKALOWANIE
	    	
	    		Rectangle r = this.getBounds();
	    		int temp = r.width+r.height;
	    		Image pacman10=pacman.getScaledInstance((r.width)/szerokosc, (r.height)/wysokosc, Image.SCALE_DEFAULT);;
	    		Image pusto1=pusto.getScaledInstance((r.width)/szerokosc, (r.height)/wysokosc, Image.SCALE_DEFAULT);
	    		Image pion1=pion.getScaledInstance((r.width)/szerokosc, (r.height)/wysokosc, Image.SCALE_DEFAULT);
	    		Image poziom1=poziom.getScaledInstance((r.width)/szerokosc, (r.height)/wysokosc, Image.SCALE_DEFAULT);    
	    		Image duszek1=duszek.getScaledInstance((r.width)/szerokosc, (r.height)/wysokosc, Image.SCALE_DEFAULT);
	    		Image nduszek1=nduszek.getScaledInstance((r.width)/szerokosc, (r.height)/wysokosc, Image.SCALE_DEFAULT);
	    		
				//Rectangle r = this.getBounds();
	    		
	    		while(pusto1.getHeight(null)==-1 || pion1.getHeight(null)==-1 || poziom1.getHeight(null)==-1 || pacman10.getHeight(null)==-1 || duszek1.getHeight(null)==-1 || nduszek1.getHeight(null)==-1)
	    		{
	    			
	    		}
	    		int h=(r.height)/wysokosc;
	    		int w=(r.width)/szerokosc;

	    		
	        int i=0;
			int j=0;
			//rysowanie planszy z tablicy odczytanej z pliku tekstowego
			  for(int k =0; k<szerokosc*wysokosc; ++k) {
			    	if(punkty[i][j]==' ')
					{
			    		offscreeng.drawImage(pusto1, w*i, h*j, null);
					}
					else if(punkty[i][j]=='|')
					{
						offscreeng.drawImage(pion1, w*i, h*j, null);

					}
					else if(punkty[i][j]=='-')
					{
						offscreeng.drawImage(poziom1, w*i, h*j, null);

					}
					else if(punkty[i][j]=='p')
					{
						offscreeng.drawImage(pacman10, w*i, h*j, null);

					}	
					else if(punkty[i][j]=='d')
					{
						offscreeng.drawImage(duszek1, w*i, h*j, null);

					}
					else if(punkty[i][j]=='n')
					{
						offscreeng.drawImage(nduszek1, w*i, h*j, null);

					}	
			    	i++;
			    	if(i==szerokosc)
					  {
						  i=0;
						  j++;
					  }
			    }	
	    }
	    
	    
	    void updateOffscreenSize(final int w, final int h) {
	    	if (kicker != null) {
	    		Thread k = kicker;
	    		kicker = null;
	    		k.interrupt();
	    	}
	    	offscreen = createImage(w, h);
	        offscreeng = offscreen.getGraphics();
	        (kicker = new Thread(this)).start();
	    }
	    
	    public Thread kicker = null;
	    
	    void sleeep() {
	        try {
	            Thread.sleep(15);
	        } catch (InterruptedException ie) {
	        }
	    }

	    public void run() {
	    	while (kicker == Thread.currentThread()) {
	    		updateOffscreen();
	        	repaint();
	    		sleeep();
	        }
	    }
	    
	    }

	
	

