package pacman;


import static pacman.Config.getData;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Główna makieta gry
 */
public class Obrazgra extends Canvas implements Runnable, KeyListener{
	
	/**
     * Obraz pionowej ściany
     */
    private Image pion = null;
    /**
     * Obraz pustego pola
     */
    private Image pusto = null;
    /**
     * Obraz pustego pola
     */
    private Image kropka = null;
    /**
     * Obraz poziomej ściany
     */
    private Image poziom = null;
    /**
     * Obraz pacmana skierowanego w prawo nie skalowany
     */
    private Image pacmanE = null;
    /**
     * Obraz pacmana skierowanego w lewo nie skalowany
     */
    private Image pacmanW = null;
    /**
     * Obraz pacmana skierowanego do dołu nie skalowany
     */
    private Image pacmanS = null;
    /**
     * Obraz pacmana skierowanego w dół nie skalowany
     */
    private Image pacmanN = null;
    /**
     * Obraz pacmana skierowanego w prawo
     */
    private Image pacmanEe = null;
    /**
     * Obraz pacmana skierowanego w lewo
     */
    private Image pacmanWw = null;
    /**
     * Obraz pacmana skierowanego do dołu
     */
    private Image pacmanSs = null;
    /**
     * Obraz pacmana skierowanego w dół
     */
    private Image pacmanNn = null;
    /**
     * Obraz duszka
     */
    private Image duszek = null;
    /**
     * Obraz niebieskiego duszka
     */
    private Image nduszek = null;
    
    
    //TODO TU ZACZYNAJA SIE OBRAZY KTORYCH ROZMIARY SA SKALOWANE, dopisze potem xd
    private Image pacman10=null;
    /**
     * Obrazek przedstawiający puste miejsce
     */
    private Image pusto1=null;
    /**
     * Obrazek przedstawiający pionową ściankę
     */
    private Image pion1=null;
    /**
     * Obrazek przedstawiający poziomą ściankę
     */
    private Image poziom1=null;
    /**
     * Obrazek przedstawiający duszka
     */
    private Image duszek1=null;
    /**
     * Obrazek przedstawiający niebieskiego duszka
     */
    private Image nduszek1=null;
    /**
     * Obrazek przedstawiający podwojna sciane duszka
     */
    private Image x=null;
	/**
     * Obrazek przedstawiający kropke
     */
    private	Image kropka1=null;
    /**
     * Obraz Obraz do podwójnego buforowania
     */
    private Image offscreen = null;
    /**
     * Obraz pionowej ściany
     */
    private Graphics offscreeng = null;
    /**
     * Szerokosc planszy
     */
    private int szerokosc=0;
    /**
     * wysokosc planszy
     */
    private int wysokosc=0;
    /**
     * Zobrazowanie planszy wejsciowej w tablicy charow
     */
    private char[][] punkty;
    /**
     * Współrzędna X pacmana
     */
    private int pacX=-1;
    /**
     * Współrzędna Y pacmana
     */
    private int pacY=-1;
    /**
	  * Obraz dwie sciany
	  */
    private Image skrzyzowanie = null;
    /**
	  * Wspolrzedne scian
	  */
	private int[][] sciany;
	/**
	  *Szybkosc ruchu pacmana
	  */ 
	private int szybkosc=2;
	/**
	  * Kierunek ruch pacmana
	  */   
	private char kierunek='a';
	/**
	  * Poprzedni kierunek ruch pacmana
	  */
	private char popKierunek='a';
	/**
	  * Nastepny kierunek ruch pacmana
	  */  
	private char nasKierunek='a';
	/**
	  * Wysokosc pojedynczego pola
	  */
	private int wys = 32;
	/**
	  * Szerokosc pojedynczego pola
	  */
	private int szer = 32;
	/**
	  * Czy okno zmienilo rozmiary
	  */
	private boolean zmianaRozmiarow = false;
	/**
	  * Obiekt duszek
	  */
	private Duszek duszekk = null;
	   
	   
	 /**
     * Konstruktor podczas którego między innymi ładowane są obrazki
     * @param wysokosc Wysokość
     * @param szerokosc Szerokość
     * @param punkty  Punkty służące do rysowania planszy za pomocą obrazków
     */
	   Obrazgra(int wysokosc,int szerokosc,char[][] punkty,int[][] sciany) {
	        
   
	       /**
	         * Odczyt obrazka odpowiadającego pustemu polu na planszy
	         */
		    pusto = new ImageIcon(getData("Pusto")).getImage();
		    /**
	         * Odczyt obrazka odpowiadającego pustemu polu na planszy
	         */
		    kropka = new ImageIcon(getData("Kropka")).getImage();
	       /**
	         * Odczyt obrazka odpowiadającego pionowej ściance na planszy
	         */
		    pion= new ImageIcon(getData("Pion")).getImage();
	        /**
	         * Odczyt obrazka odpowiadającego poziomej ściance na planszy
	         */
		    poziom = new ImageIcon(getData("Poziom")).getImage();
	        /**
	         * Odczyt obrazka odpowiadającego pacmanowi skierowanemu w prawo na planszy
	         */
		    pacmanE = new ImageIcon(getData("Pacman")).getImage();
	        /**
	         * Odczyt obrazka odpowiadającego pacmanowi skierowanemu w lewo na planszy
	         */
		    pacmanW = new ImageIcon(getData("PacmanW")).getImage();
	        /**
	         * Odczyt obrazka odpowiadającego pacmanowi skierowanemu w dół na planszy
	         */
		    pacmanS = new ImageIcon(getData("PacmanS")).getImage();
	        /**
	         * Odczyt obrazka odpowiadającego pacmanowi skierowanemu w górę na planszy
	         */
		    pacmanN = new ImageIcon(getData("PacmanN")).getImage();
	        /**
	         * Odczyt obrazka odpowiadającego duszkowi na planszy
	         */
		    duszek= new ImageIcon(getData("Duszek")).getImage();
	        /**
	         * Odczyt obrazka odpowiadającego niebieskiemu duszkowi na planszy
	         */
		    nduszek = new ImageIcon(getData("niebieskiDuszek")).getImage();
	        /**
	         * Odczyt obrazka odpowiadającego podwojnej scianie na planszy
	         */
		    skrzyzowanie = new ImageIcon(getData("skrzyzowanie")).getImage();
		   
			this.szerokosc=szerokosc;
			this.wysokosc=wysokosc;
			this.punkty=punkty;
			this.sciany=sciany;
			
			int i=0;
			int j=0;
			  for(int k =0; k<szerokosc*wysokosc; ++k) {
					if(punkty[i][j]=='p')
					{
						pacX=i*szer;
						pacY=j*wys;
					}	
					i++;
			    	if(i==szerokosc)
					  {
						  i=0;
						  j++;
					  }
	
			    }
			
			
			addKeyListener(this);
			
			pacman10=pacmanE;
	        /**
	         * Obrazek przedstawiający puste miejsce
	         */
	        pusto1=pusto;
	        /**
	         * Obrazek przedstawiający pionową ściankę
	         */
	        pion1=pion;
	        /**
	         * Obrazek przedstawiający poziomą ściankę
	         */
	        poziom1=poziom;
	        /**
	         * Obrazek przedstawiający duszka
	         */
	        duszek1=duszek;
	        /**
	         * Obrazek przedstawiający niebieskiego duszka
	         */
	        nduszek1=nduszek;
	        /**
	         * Obrazek przedstawiający podwojna sciane
	         */
    		x=skrzyzowanie;
	        /**
	         * Obrazek przedstawiający kropke
	         */
    		kropka1=kropka;
    		
    		

	    }

	   /**
	     * Ustawianie domyślnego wymiaru planszy
	     * @return Domyślny wymiar
	     */
	    public Dimension getPreferredSize() {
	        return new Dimension(szerokosc*szer, wysokosc*wys);
	    }
	    
	    
	    void updateOffscreenSize(final int w, final int h) {
	    	if (kicker != null) {
	    		Thread k = kicker;
	    		kicker = null;
	    		k.interrupt();
	    	}

	    	offscreen = createImage(w, h);
	        offscreeng = offscreen.getGraphics();
	        zmianaRozmiarow(w,h);
	        (kicker = new Thread(this)).start();
	    }
	    /**
	     * Dodaje domyślny wymiar
	     */
	    public void addNotify() {
	        super.addNotify();
	        offscreen = createImage(getPreferredSize().width, getPreferredSize().height);
	        offscreeng = offscreen.getGraphics();
	    }
	    /**
	     * Odświeża wygląd planszy
	     * @param g Chwilowa wyświetlona grafika
	     */
	    public void update(Graphics g) {
	    	paint(g);
	    }
	    /**
	     * Rysuje obrazek
	     * @param g Chwilowa wyświetlona grafika
	     */
	    public void paint(Graphics g) {
	    	g.drawImage(offscreen, 0, 0, this);
	    	
	}
	    
	    /**
	     * Tworzenie wyswielanej planszy
	     */
	    void zaladujplansze() {


	    	
	    	if(zmianaRozmiarow == true)
	    	{
	        /**
	         * Obrazek przedstawiający pacmana
	         */
	        pacman10=pacmanE.getScaledInstance(szer, wys, Image.SCALE_DEFAULT);
	        /**
	         * Obrazek przedstawiający puste miejsce
	         */
	        pusto1=pusto.getScaledInstance(szer, wys, Image.SCALE_DEFAULT);
	        /**
	         * Obrazek przedstawiający pionową ściankę
	         */
	        pion1=pion.getScaledInstance(szer, wys, Image.SCALE_DEFAULT);
	        /**
	         * Obrazek przedstawiający poziomą ściankę
	         */
	        poziom1=poziom.getScaledInstance(szer, wys, Image.SCALE_DEFAULT);
	        /**
	         * Obrazek przedstawiający duszka
	         */
	        duszek1=duszek.getScaledInstance(szer, wys, Image.SCALE_DEFAULT);
	        /**
	         * Obrazek przedstawiający niebieskiego duszka
	         */
	        nduszek1=nduszek.getScaledInstance(szer, wys, Image.SCALE_DEFAULT);
	        /**
	         * Obrazek przedstawiający podwojna sciane 
	         */
    		x=skrzyzowanie.getScaledInstance(szer, wys, Image.SCALE_DEFAULT);
	        /**
	         * Obrazek przedstawiający kropke
	         */
    		kropka1=kropka.getScaledInstance(szer, wys, Image.SCALE_DEFAULT);
    		
    		while(pacman10.getHeight(null)==-1 || pusto1.getHeight(null)==-1 || pion1.getHeight(null)==-1 || poziom1.getHeight(null)==-1 || duszek1.getHeight(null)==-1 || nduszek1.getHeight(null)==-1 || x.getHeight(null)==-1 || kropka1.getHeight(null)==-1)
       		{
       		sleeep(); //TODO optymalniej to sie raczej da zrobic xd, soon^tm
       		}
	    	}
	    	
	    	int w=szer;
	    	int h =wys;
	        int i=0;
			int j=0;
	        /**
	         * Rysowanie planszy z tablicy odczytanej z pliku tekstowego
	         */
			  for(int k =0; k<szerokosc*wysokosc; ++k) {
			    	if(punkty[i][j]==' ')
					{
			    		offscreeng.drawImage(kropka1, w*i, h*j, null);
					}
			    	else if(punkty[i][j]=='0')
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
						offscreeng.drawImage(pusto1, w*i, h*j, null);
					//	offscreeng.drawImage(pacman10, w*i, h*j, null);
					//	pacX=i*szer;
					//	pacY=j*wys;

					}	
					else if(punkty[i][j]=='d')
					{
						offscreeng.drawImage(duszek1, w*i, h*j, null);
						duszekk = new Duszek(w*i,h*j, sciany);
						punkty[i][j]=' ';

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
	    
	    
	    /**
	     * Uaktualnienie obrazu wyświetlaniego na ekranie
	     */
	    void updateOffscreen() {
	    	   		
    		if(pacX%szer!=0 || pacY%wys!=0)
    		{
    			if(popKierunek!=kierunek)
    		nasKierunek=kierunek;
    		kierunek=popKierunek;
    		}
    		else
    		{
    			punkty[pacX/szer][pacY/wys]='0';

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
	        	if(sciany[i][0]==pacX && sciany[i][1]==pacY-wys)
	        	{
			    	przeszkoda = true;
	        	}
	        	if(przeszkoda==false)	
	        		pacY=pacY-szybkosc;
	        	offscreeng.drawImage(pacmanNn, pacX, pacY,null);    	
	        	break;
	        case 'S':
	        	for(int i=0; i<sciany.length; i++)
		        	if(sciany[i][0]==pacX && sciany[i][1]==pacY+wys)
		        	{
				    	przeszkoda = true;
		        	}
		        	if(przeszkoda==false)
		        		pacY=pacY+szybkosc;
		    	offscreeng.drawImage(pacmanSs, pacX, pacY,null);
	            break;
	        case 'W':
	        	for(int i=0; i<sciany.length; i++)
		        	if(sciany[i][0]==pacX-szer && sciany[i][1]==pacY)
		        	{
				    	przeszkoda = true;
		        	}
		        	if(przeszkoda==false)	
		        		pacX=pacX-szybkosc;
		    	offscreeng.drawImage(pacmanWw, pacX, pacY,null);
	            break;
	        case 'E':
	        	for(int i=0; i<sciany.length; i++)
		        	if(sciany[i][0]==pacX+szer && sciany[i][1]==pacY)
		        	{
				    	przeszkoda = true;
		        	}
		        	if(przeszkoda==false)	
		        		pacX=pacX+szybkosc;
		    	offscreeng.drawImage(pacmanEe, pacX, pacY,null);
	            break;
	     }
	    		popKierunek=kierunek;
	    		
	    		//Ruch duszka
	    		if(duszekk!=null || duszek!=null)
	    		{
	    		int pozDuszek[]=duszekk.droga(pacX,pacY);
	    		offscreeng.drawImage(duszek, pozDuszek[0], pozDuszek[1],null);
	    		}

	    }
	    

	    
	    public Thread kicker = null;
	    
	    /**
	     * Czekanie na ruch
	     */
	    void sleeep() {
	        try {
	            Thread.sleep(15);
	        } catch (InterruptedException ie) {
	        }
	    }

	    /**
	     * Ruch pacmana
	     */
	    public void run() {
	    	while (kicker == Thread.currentThread()) {
		     		zaladujplansze();
		    		zmianaRozmiarow = false;
		    		updateOffscreen();
	        	repaint();
	    		sleeep();
	        }
	    }


	    /**
	     * Nacisniecie przycisku na klawiaturze
	     */
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


	    
	    
		 /**
	     * Odczyt zdarzenia, przypisanie jego symbolicznej wartosci do zmiennej
	     * @param e Zdarzenie
	     */
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

private void zmianaRozmiarow(int w, int h)
{
	 for(int k =0; k<sciany.length; k++)
	 {
 		sciany[k][0]=sciany[k][0]/szer;
 		sciany[k][1]=sciany[k][1]/wys;
	 }
		pacX=pacX/szer;
		pacY=pacY/wys;
		

		szer=(w-18)/szerokosc;
		while(szer%szybkosc!=0)
			szer--;
		wys=(h-83)/wysokosc;
		while(wys%szybkosc!=0)
			wys--;

		zmianaRozmiarow = true;
		pacmanNn=pacmanN.getScaledInstance(szer, wys, Image.SCALE_DEFAULT);
		pacmanSs=pacmanS.getScaledInstance(szer, wys, Image.SCALE_DEFAULT);
		pacmanWw=pacmanW.getScaledInstance(szer, wys, Image.SCALE_DEFAULT);
		pacmanEe=pacmanE.getScaledInstance(szer, wys, Image.SCALE_DEFAULT);
		

		 for(int k =0; k<sciany.length; k++)
		 {
	 		sciany[k][0]=sciany[k][0]*szer;
	 		sciany[k][1]=sciany[k][1]*wys;

		 }
	 		pacX=pacX*szer;
	 		pacY=pacY*wys;
	 		
			while(pacX%szer!=0)
				pacX--;
			while(pacY%wys!=0)
				pacY--;


}


}


	
	

