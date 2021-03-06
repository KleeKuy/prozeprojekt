package pacman;


import static pacman.Config.getData;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;


/**
 * Główna makieta gry
 */
public class Obrazgra extends Canvas implements Runnable, KeyListener{
	
	/**
     * Obraz pionowej ściany nie skalowany
     */
    private Image pion = null;
    /**
     * Obraz pustego pola nie skalowany
     */
    private Image pusto = null;
    /**
     * Obraz pustego pola nie skalowany
     */
    private Image kropka = null;
    /**
     * Obraz poziomej ściany nie skalowany
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
     * Obraz pacmana skierowanego w prawo skalowany
     */
    private Image pacmanEe = null;
    /**
     * Obraz pacmana skierowanego w lewo skalowany
     */
    private Image pacmanWw = null;
    /**
     * Obraz pacmana skierowanego do dołu skalowany
     */
    private Image pacmanSs = null;
    /**
     * Obraz pacmana skierowanego w dół skalowany
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
    /**
     * Obraz  owoca
     */
    private Image owoc = null;
    /**
     * Obraz pacmana skalowany
     */
    private Image pacman10=null;
    /**
     * Obrazek przedstawiający puste miejsce skalowany
     */
    private Image pusto1=null;
    /**
     * Obrazek przedstawiający pionową ściankę skalowany
     */
    private Image pion1=null;
    /**
     * Obrazek przedstawiający poziomą ściankę skalowany
     */
    private Image poziom1=null;
    /**
     * Obrazek przedstawiający skalowany
     */
    private Image duszek1=null;
    /**
     * Obrazek przedstawiający niebieskiego duszka skalowany
     */
    private Image nduszek1=null;
    /**
     * Obrazek przedstawiający podwojna sciane skalowany
     */
    private Image x=null;
	/**
     * Obrazek przedstawiający kropke skalowany
     */
    private	Image kropka1=null;
    /**
     * Obraz  owoca skalowany
     */
    private Image owoc1 = null;
    /**
     * Obraz Obraz do podwójnego buforowania
     */  
    private Image offscreen = null;
    /**
     * Obiekt graphics do podwojnego buforowania
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
     * Startowa współrzędna X pacmana
     */
    private int StartpacX=-1;
    /**
     * Startowa Współrzędna Y pacmana
     */
    private int StartpacY=-1;
    /**
	  * Obraz dwoch scian poziomej i pionowej nie skalowany
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
	private char kierunek='N';
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
	  * Obiekt niebieski duszek
	  */
	private Duszek nduszekk = null;
	  /**
	   *  Tablica z obiektami typu owoc umieszczonymi na planszy
	   */
	private Owoc[] owoce = null;  
	/**
	 * Obiekt plansza na ktorym toczy sie gra
	 */
	private Plansza pl;
	/*
	 * Okresla czy gra jest zapauzowane
	 */
	private boolean zapauzowana=false;
	/*
	 * Okresla czy plansza zostala ukonczona
	 */
	boolean koniec = false;
	/**
	 * Watek tego obiektu
	 */
    public Thread kicker = null;

	
	/**
	 * Konstruktoe obiektu obrazgra
	 * @param wysokosc wysokosc pojedynczego pola
	 * @param szerokosc szerokosc pojedynczego pola
	 * @param punkty Punkty służące do rysowania planszy za pomocą obrazków
	 * @param sciany Wspolrzedna scian
	 * @param wspOwocow Wspolrzedna owocow
	 * @param p Obiekt plansza na ktorym toczy sie gra
	 */
	   Obrazgra(int wysokosc,int szerokosc,char[][] punkty,int[][] sciany,int[][] wspOwocow,Plansza p) {
	        
		   pl=p;
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
	        /**
	         * Odczyt obrazka owoca
	         */
		    owoc = new ImageIcon(getData("owoc")).getImage();
		    
			this.szerokosc=szerokosc;
			this.wysokosc=wysokosc;
			this.punkty=punkty;
			this.sciany=sciany;
			
			//Określenie pozycji pacmana
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
			
			  //Utworzenie tablicy owocow
			  owoce = new Owoc[wspOwocow.length+1];
			  owoce[0] = new Owoc(szybkosc,-1,-1,-1,-1);
			  for(int k=1; k<wspOwocow.length+1; k++)
			  {
				  owoce[k] = new Owoc(szybkosc,wspOwocow[k-1][0],wspOwocow[k-1][1],wys,szer);
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
    		/**
	         * Obrazek przedstawiający owoc
	         */
    		owoc1=owoc;
    		
    		

	    }

	   /**
	     * Ustawianie domyślnego wymiaru planszy
	     * @return Domyślny wymiar
	     */
	    public Dimension getPreferredSize() {
	        return new Dimension(szerokosc*szer, wysokosc*wys);
	    }
	    
/**
 * Funkcja wywolywana gdy wielkosc planszy sie zmieni
 * @param w nowa szerokosc planszy
 * @param h nowa wysokosc planszy
 */
	   synchronized void updateOffscreenSize(final int w, final int h) {
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
	     //TODO
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
	    	
	    	//Skalowanie o ile zmienila sie plansza
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
            /**
	         * Obrazek przedstawiający kropke
	         */
    		owoc1=owoc.getScaledInstance(szer, wys, Image.SCALE_DEFAULT);
    		
    		while(pacman10.getHeight(null)==-1 ||owoc1.getHeight(null)==-1 || pusto1.getHeight(null)==-1 || pion1.getHeight(null)==-1 || poziom1.getHeight(null)==-1 || duszek1.getHeight(null)==-1 || nduszek1.getHeight(null)==-1 || x.getHeight(null)==-1 || kropka1.getHeight(null)==-1)
       		{
       		sleeep();
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
						StartpacX=i*szer;
						StartpacY=j*wys;

					}	
					else if(punkty[i][j]=='d')
					{
						offscreeng.drawImage(duszek1, w*i, h*j, null);
						if(duszekk==null)
						{
						duszekk = new Duszek(w*i,h*j, sciany,szybkosc-1,punkty);
						}
						punkty[i][j]=' ';

					}
					else if(punkty[i][j]=='n')
					{
						offscreeng.drawImage(nduszek1, w*i, h*j, null);
						nduszekk = new Duszek(w*i, h*j, sciany, szybkosc,punkty);
						punkty[i][j]=' ';

					}
					else if(punkty[i][j]=='o')
					{
						offscreeng.drawImage(owoc1, w*i, h*j, null);

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
	    	
	    	//Sprawdzenie/zmiana aktualnej szybkosci pacmana
	    	if(owoce!=null)
	    	   		for(int i=0; i<owoce.length; i++)
	    	   			if(szybkosc<owoce[i].jakaSzybkosc())
	    	   			{
	    	   				szybkosc=owoce[i].jakaSzybkosc();
	    	   				break;
	    	   			}
	    	   			else
	    	   				szybkosc=owoce[i].jakaSzybkosc();
	    	
	    	//Ustalanie kierunku ruch pacmana
    		if(pacX%szer!=0 || pacY%wys!=0)
    		{
    			if(popKierunek!=kierunek)
    		nasKierunek=kierunek;
    		kierunek=popKierunek;
    		}
    		else
    		{
    			if(punkty[pacX/szer][pacY/wys]==' ')
    			pl.dodajPunkt();

    			
    			punkty[pacX/szer][pacY/wys]='0';

    			if(nasKierunek!='a')
    			{
    			kierunek=nasKierunek;
    			nasKierunek='a';
    			}
    		}
	    	//Ruch pacmana
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
	    		
	    		//Czy pacman zjadl owoc
	    		for(int i=0; i<owoce.length; i++)
	    		{
	    			if(owoce[i].koniec==false)
	    			{
	    			owoce[i].koniecCzasu();
	    			}
	    			if(owoce[i].zjedzony==false)
		    		owoce[i].czyzjadl(pacX, pacY);

	    		}
	    		
	    		//Ruch duszka oraz sprawdzenie czy duszek trafil na pacmana
	    		if(duszekk!=null)
	    		{
	    		int pozDuszek[]=duszekk.droga(pacX,pacY);
	    		offscreeng.drawImage(duszek1, pozDuszek[0], pozDuszek[1],null);
	    		if(Math.abs(pozDuszek[0]-pacX)<szer && Math.abs(pozDuszek[1]-pacY)<wys)
					pl.utrataZycia();
	    		
	    		}
	    		if(nduszekk!=null)
    			{
	    			int pozDuszek[]=nduszekk.droga(pacX,pacY);
		    		offscreeng.drawImage(nduszek1, pozDuszek[0], pozDuszek[1],null);
		    		if(Math.abs(pozDuszek[0]-pacX)<szer && Math.abs(pozDuszek[1]-pacY)<wys)
						pl.utrataZycia();
    			}
	    		

	    }
	    

	    
	    
	    /**
	     * Czekanie
	     */
	    void sleeep() {
	        try {
	            Thread.sleep(15);
	        } catch (InterruptedException ie) {
	        }
	    }

	    /**
	     * Metoda run tego obiektu, jezeli pauza jest wlaczona to czeka,
	     * w innym przypadku tworzy uaktualniona plansze, po czym naklada na nia pacmana i duszki, ostatecznie aktualizuje wyswietlana plansze
	     */
	    public void run() {
	    	while (kicker == Thread.currentThread()) {
		    	if(zapauzowana ==false)
		    	{
		    		if(koniec==true)
		    			break;
		     		zaladujplansze();
		    		zmianaRozmiarow = false;
		    		updateOffscreen();
	        	repaint();
	    		sleeep();
		    	}
		    	else
		    		sleeep();
	        }
	    }


	    /**
	     * Nacisniecie przycisku na klawiaturze - ruch pacmana
	     */
		@Override
		public void keyPressed(KeyEvent arg0) {
			displayInfo(arg0);
		}

		@Override
		public void keyReleased(KeyEvent arg0) {
			
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			
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

/**
 * Aktualizacja wartosci w przypadku zmiany wielkosci planszy
 * @param w nowa szerokosc planszy
 * @param h nowa wysokosc planszy
 */
synchronized private void zmianaRozmiarow(int w, int h)
{
	//Ustalenie aktualnej pozycji scian
	int k;
	 for(k =0; k<sciany.length; k++)
	 {
 		sciany[k][0]=sciany[k][0]/szer;
 		sciany[k][1]=sciany[k][1]/wys;
	 }
		pacX=pacX/szer;
		pacY=pacY/wys;
		
	//Nowa szerokosc pojedynczego pola
		szer=(w-18)/szerokosc;
		while(szer%szybkosc!=0)
			szer--;
		wys=(h-83)/wysokosc;
	//Nowa wysokosc pojedynczego pola
		while(wys%szybkosc!=0)
			wys--;
	//Zmiana rozmiarow grafiki pacman
		zmianaRozmiarow = true;
		pacmanNn=pacmanN.getScaledInstance(szer, wys, Image.SCALE_DEFAULT);
		pacmanSs=pacmanS.getScaledInstance(szer, wys, Image.SCALE_DEFAULT);
		pacmanWw=pacmanW.getScaledInstance(szer, wys, Image.SCALE_DEFAULT);
		pacmanEe=pacmanE.getScaledInstance(szer, wys, Image.SCALE_DEFAULT);
		duszek1=duszek.getScaledInstance(szer, wys, Image.SCALE_DEFAULT);
		nduszek1=nduszek.getScaledInstance(szer,wys,Image.SCALE_DEFAULT);


	//Nowa lokalizacja scian
		 for(k =0; k<sciany.length; k++)
		 {
	 		sciany[k][0]=sciany[k][0]*szer;
	 		sciany[k][1]=sciany[k][1]*wys;

		 }
	//Nowe wspolrzedne pacmana
	 		pacX=pacX*szer;
	 		pacY=pacY*wys;
			while(pacX%szer!=0)
				pacX--;
			while(pacY%wys!=0)
				pacY--;
			
	//Skalowanie duszka
    			if(duszekk!=null)
    			{
    			duszekk.zmianaRozmiarow(wys,szer,sciany);
    			}
    			if(nduszekk!=null)
    			{
    			nduszekk.zmianaRozmiarow(wys,szer,sciany);
    			}
    //Skalowanie owocow
    			for(int i=1; i<owoce.length; i++)
    				owoce[i].skalowanie(wys,szer);

}


/**
 * Zmiana szybkosci pacmana zwiazana ze zjedzeniem owocu
 * @param nowa_szybkosc nowa szybkosc pacmana
 */
public void zmiana_szybkosci(int nowa_szybkosc)
{
	szybkosc=nowa_szybkosc;
}

/**
 * Obsluga nacieniecia guzika pauza
 */
public void pauza()
{
	if(zapauzowana == false)
	{
	zapauzowana =true;
	}
	else
	{
		zapauzowana = false;
	}
	
    
}

/**
 * Utrata zycia przez pacmana
 */

public void utrata_zycia()
{
	
	zapauzowana=true;
	pacX=StartpacX;
	pacY=StartpacY;
	while(pacX%szer!=0)
		pacX--;
	while(pacY%wys!=0)
		pacY--;
	if(duszekk!=null)
	{
		duszekk.powrot();
	}
	if(nduszekk!=null)
	{
		nduszekk.powrot();
	}
}

}






	
	

