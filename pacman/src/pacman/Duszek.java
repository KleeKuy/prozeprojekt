package pacman;

/**
 * Klasa opisujaca duszka
 */
public class Duszek {

	/**
	 * Pozycja Duszka w poziomie
	 */
	private int pozX=0;
	/**
	 * Pozycja Duszka w pionie
	 */
	private int pozY=0;
	/**
	 * Pozycja startowa Duszka w poziomie
	 */
	private int StartpozX=0;
	/**
	 * Pozycja startowa Duszka w pionie
	 */
	private int StartpozY=0;
	/**
	 * Szybkosc duszka
	 */
	private int szybkosc =0; 
	/**
	 * Aktualny kierunek ruchu duszka
	 */
	private char kierunek ='a';
	/**
	 * Wysokosc duszka
	 */
	public int wys=32;
	/**
	 * Szerokosc duszka
	 */
	public int szer=32;
	/**
	 *	Tabela ze scianami
	 */
	private int[][] sciany=null;
	/**
	 *	Tabela obrazujaca plansze gry
	 */
	private char[][] plansza=null;


	/**
	 * Konstruktor duszka, tworzy duszka z okreslona pozycja startowa, szybkoscia
	 * @param startPozX Pozycja startowa duszka w poziomie
	 * @param startPozY Pozycja startowa duszka w pionie
	 * @param sciany	Pozycje scian
	 * @param szybkoscp Szybkosc pacmana
	 * @param punkty Plansza zobrazowana jako tablica charow
	 */
	Duszek(int startPozX, int startPozY, int[][] sciany, int szybkoscp, char[][] punkty)
	{
		//Wczytywanie wartosci
		pozX=startPozX;
		pozY=startPozY;
		StartpozX=startPozX;
		StartpozY=startPozY;
		szybkosc=szybkoscp;
		this.sciany=sciany;
		this.plansza=new char[punkty.length][punkty.length];
		int j =0;
		for(int i=0; j<punkty.length; i++)
		{
			plansza[i][j]=punkty[i][j];
					
					if(i==punkty.length-1)
					{
						i=0;
						j++;
					}
		}

	}

	/**
	 * Funkcja odpowiadajaca za skalowanie duszka
	 * @param nowaWys nowa wysokosc duszka
	 * @param nowaSzer nowa szerokosc duszka
	 * @param scianyNowe nowe pozycje scian
	 */
	public void zmianaRozmiarow(int nowaWys, int nowaSzer,int[][] scianyNowe)
	{
		//Przypisanie nowych wartosci
		    sciany=scianyNowe;
		 
	 		pozX=pozX/szer*nowaSzer;
	 		pozY=pozY/wys*nowaWys;
	 		
			wys=nowaWys;
			szer=nowaSzer;
	 		
			while(pozX%szer!=0)
				pozX--;
			while(pozY%wys!=0)
				pozY--;
	}
	
	/**
	 *  Funkcja odpowiadajaca za ruch duszka
	 * @param pacX Pozycja x pacmana (pozycha do ktorej dazy duszek)
	 * @param pacY Pozycja y pacmana (pozycja do ktorej dazy duszek)
	 * @return Nowa pozycja duszka
	 */
	public int[] droga(int pacX, int pacY)
	{
		//Ustalanie kierunku ruchu duszka
		int roznicaX=pozX-pacX;
		int roznicaY=pozY-pacY;
		
		if(pozX%szer==0 && pozY%wys==0)
		{
		if(roznicaX*roznicaX>roznicaY*roznicaY)
			if(roznicaX>0)
				 kierunek='W';
			else kierunek='E';
		else
			if(roznicaY>0)
				 kierunek='N';
			else kierunek='S';
		}

		boolean kontynuuj = true;
		int licznik =0;
		while(kontynuuj==true)
		{
			licznik++;
			if(licznik>3)
			{
				if(kierunek=='N')
					kierunek='W';
				if(kierunek=='S')
					kierunek='E';
				if(kierunek=='W')
					kierunek='N';
				if(kierunek=='E')
					kierunek='S';
			}
			kontynuuj = false;
			//Sprawdzenie czy duszek nie napotka na sciane
    	switch( kierunek ) { 
        case 'N':
        	for(int i=0; i<sciany.length; i++)
        	if(sciany[i][0]==pozX && sciany[i][1]==pozY-wys)
        	{
		    	kontynuuj = true;
		    	kierunek='E';
		    	break;
        	}
        	if(kontynuuj==false)
        		pozY=pozY-szybkosc;
        	break;
        case 'S':
        	for(int i=0; i<sciany.length; i++)
	        	if(sciany[i][0]==pozX && sciany[i][1]==pozY+wys)
	        	{
			    	kontynuuj = true;
			    	kierunek='W';
			    	break;
	        	}
	        	if(kontynuuj==false)	
	        		pozY=pozY+szybkosc;
            break;
        case 'W':
        	for(int i=0; i<sciany.length; i++)
	        	if(sciany[i][0]==pozX-szer && sciany[i][1]==pozY)
	        	{
			    	kontynuuj = true;
			    	kierunek='S';
			    	break;
	        	}
	        	if(kontynuuj==false)	
	        		pozX=pozX-szybkosc;
            break;
        case 'E':
        	for(int i=0; i<sciany.length; i++)
	        	if(sciany[i][0]==pozX+szer && sciany[i][1]==pozY)
	        	{
			    	kontynuuj = true;
			    	kierunek='N';
			    	break;
	        	}
	        	if(kontynuuj==false)	
	        		pozX=pozX+szybkosc;
            break;
     }
		}
		//Ustalenie ostatecznej pozycji duszka po tym ruchu
    		int[] pozD=new int[2];
    		pozD[0]=pozX;
    		pozD[1]=pozY;
		return pozD;
		
	}
	

	/**
	 * Powrot duszka do lokalizacji poczatkowej na skutek utraty zycia przez gracza
	 */
	public void powrot()
	{
		pozX=StartpozX;
		pozY=StartpozY;
		while(pozX%szer!=0)
			pozX--;
		while(pozY%wys!=0)
			pozY--;
	}
}

