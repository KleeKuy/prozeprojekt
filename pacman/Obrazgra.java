package pacman;


import static pacman.Config.getData;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;

import javax.swing.ImageIcon;

//Klasa odpowiadająca za wyswietlanie  gry
public class Obrazgra extends Canvas implements Runnable, KeyListener{
	
		//Obraz pionowej ściany
	   private Image pion = null;
		//Obraz pustego pola
	   private Image pusto = null;
	   //Obraz dwie sciany
	   private Image skrzyzowanie = null;
		//Obraz poziomej ściany
	   private Image poziom = null;
		//Obraz pacmana skierowanego w prawo
	   private Image pacmanE = null;
	   //Obraz pacmana skierowanego w lewo
	   private Image pacmanW = null;
	   //Obraz pacmana skierowanego do dołu
	   private Image pacmanS = null;
	   //Obraz pacmana skierowanego w dół
	   private Image pacmanN = null;
	   //Obraz duszka
	   private Image duszek = null;
	   //Obraz niebieskiego duszka
	   private Image nduszek = null;
	   //Obraz Obraz do podwójnego buforowania
	   private Image offscreen = null;
	   //Obraz pionowej ściany
	   private Graphics offscreeng = null;
	   //szerokosc planszy
	   private int szerokosc=0;
	   //wysokosc planszy
	   private int wysokosc=0;
	   //Wspolrzedne scian
	   private int[][] sciany;
	   //zobrazowanie planszy wejsciowej w tablicy charow
	   private char[][] punkty;
	   //Współrzędna X pacmana
	   private int pacX=-1;
	   //Współrzędna Y pacmana
	   private int pacY=-1;
	   //Szybkosc ruchu pacmana
	   private int szybkosc=2;
	   //Kierunek ruch pacmana	   
	   private char kierunek='a';
	   //Poprzedni kierunek ruch pacmana
	   private char popKierunek='a';
	   //Nastepny kierunek ruch pacmana
	   private char nasKierunek='a';
	   
	   
	   //Konstruktor podczas którego między innymi ładowane są obrazki
	   Obrazgra(int wysokosc,int szerokosc,char[][] punkty,int[][] sciany) {
	        
   
	    	//odczyt obrazkow z plikow
	    	Image obraz0 = new ImageIcon(getData("Pusto")).getImage();
			pusto = obraz0;
			Image obraz02 = new ImageIcon(getData("Pion")).getImage();
			pion = obraz02;
			Image obraz03 = new ImageIcon(getData("Poziom")).getImage();
			poziom = obraz03;
			Image obraz04 = new ImageIcon(getData("Pacman")).getImage();
			pacmanE = obraz04;
			Image obraz041 = new ImageIcon(getData("PacmanW")).getImage();
			pacmanW = obraz041;
			Image obraz042 = new ImageIcon(getData("PacmanS")).getImage();
			pacmanS = obraz042;
			Image obraz043 = new ImageIcon(getData("PacmanN")).getImage();
			pacmanN = obraz043;
			Image obraz05 = new ImageIcon(getData("Duszek")).getImage();
			duszek = obraz05;
			Image obraz06 = new ImageIcon(getData("niebieskiDuszek")).getImage();
			nduszek = obraz06;
			Image obraz07 = new ImageIcon(getData("skrzyzowanie")).getImage();
			skrzyzowanie = obraz07;
		   
			this.szerokosc=szerokosc;
			this.wysokosc=wysokosc;
			this.punkty=punkty;
			this.sciany=sciany;
			
			addKeyListener(this);

	    }

	   //Preferowana szerokość planszy
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
	    
	    //Tworzenie obrazu bedacego plansza odczytana z pliku tekstowego
	    void zaladujplansze() {

	    	Image pacman10=pacmanE;
    		Image pusto1=pusto;
    		Image pion1=pion;
    		Image poziom1=poziom;    
    		Image duszek1=duszek;
    		Image nduszek1=nduszek;
    		Image x=skrzyzowanie;
    		
    		
    		while(pusto.getHeight(null)==-1 || pion.getHeight(null)==-1 || poziom.getHeight(null)==-1 || pacmanE.getHeight(null)==-1 || duszek.getHeight(null)==-1 || nduszek.getHeight(null)==-1)
        		{
        			
        		}
	    	int w=32;
	    	int h =32;
	        int i=0;
			int j=0;
			int q=0;
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
					else if(punkty[i][j]=='x')
					{
						offscreeng.drawImage(x, w*i, h*j, null);

					}
					else if(punkty[i][j]=='p')
					{
						offscreeng.drawImage(pacman10, w*i, h*j, null);
						pacX=i*32;
						pacY=j*32;

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
	    
	    
	    //Uaktualnienie obrazu wyświetlaniego na ekranie
	    void updateOffscreen() {
    		if(pacX%32!=0 || pacY%32!=0)
    		{
    			if(popKierunek!=kierunek)
    		nasKierunek=kierunek;
    		kierunek=popKierunek;
    		}
    		else
    		{
    			if(nasKierunek!='a')
    			{
    			kierunek=nasKierunek;
    			nasKierunek='a';
    			}
    		}
	    	
	    	boolean przeszkoda =false;
	    	switch( kierunek ) { 
	        case 'N':

	        	for(int i=0; i<sciany.length; i++)
	        	if(sciany[i][0]==pacX && sciany[i][1]==pacY-32)
	        	{
			    	przeszkoda = true;
	        	}
	        	if(przeszkoda==false)	
	        		pacY=pacY-szybkosc;
	        	offscreeng.drawImage(pacmanN, pacX, pacY,null);    	
	        	break;
	        case 'S':
	        	for(int i=0; i<sciany.length; i++)
		        	if(sciany[i][0]==pacX && sciany[i][1]==pacY+32)
		        	{
				    	przeszkoda = true;
		        	}
		        	if(przeszkoda==false)
		        		pacY=pacY+szybkosc;
		    	offscreeng.drawImage(pacmanS, pacX, pacY,null);
	            break;
	        case 'W':
	        	for(int i=0; i<sciany.length; i++)
		        	if(sciany[i][0]==pacX-32 && sciany[i][1]==pacY)
		        	{
				    	przeszkoda = true;
		        	}
		        	if(przeszkoda==false)	
		        		pacX=pacX-szybkosc;
		    	offscreeng.drawImage(pacmanW, pacX, pacY,null);
	            break;
	        case 'E':
	        	for(int i=0; i<sciany.length; i++)
		        	if(sciany[i][0]==pacX+32 && sciany[i][1]==pacY)
		        	{
				    	przeszkoda = true;
		        	}
		        	if(przeszkoda==false)	
		        		pacX=pacX+szybkosc;
		    	offscreeng.drawImage(pacmanE, pacX, pacY,null);
	            break;
	     }
 
	    		popKierunek=kierunek;

	    }
	    

	    
	    public Thread kicker = null;
	    
	    //Czekanie
	    void sleeep() {
	        try {
	            Thread.sleep(15);
	        } catch (InterruptedException ie) {
	        }
	    }

	    
	    public void run() {
	    	while (kicker == Thread.currentThread()) {
	    		if(pacX==-1 && pacY==-1)
		    	{
		    		zaladujplansze();
		    	}
		    	else
		    	{
		    		updateOffscreen();
		    	}
	        	repaint();
	    		sleeep();
	        }
	    }

	    //Nacisniecie przycisku na klawiaturze
		@Override
		public void keyPressed(KeyEvent arg0) {
			displayInfo(arg0);
		}

		@Override
		public void keyReleased(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}


	    
	    
//Odczyt zdarzenia, przypisanie jego symbolicznej wartosci do zmiennej
private void displayInfo(KeyEvent e){
    
	   int keyCode = e.getKeyCode();

       switch( keyCode ) {
           case KeyEvent.VK_UP:
               kierunek='N';
               break;
           case KeyEvent.VK_DOWN:
               kierunek='S';
               break;
           case KeyEvent.VK_LEFT:
               kierunek='W';
               break;
           case KeyEvent.VK_RIGHT :
               kierunek='E';
               break;
}
 
}

}
	
	

