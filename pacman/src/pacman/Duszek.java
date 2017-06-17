package pacman;

public class Duszek {

	/*
	 * Pozycja Duszka w poziomie
	 */
	private int pozX=0;
	/*
	 * Pozycja Duszka w pionie
	 */
	private int pozY=0;
	/*
	 * Pozycja startowa Duszka w poziomie
	 */
	private int StartpozX=0;
	/*
	 * Pozycja startowa Duszka w pionie
	 */
	private int StartpozY=0;
	/*
	 * Szybkosc duszka
	 */
	private int szybkosc =0; 
	/*
	 * Aktualny kierunek ruchu duszka
	 */
	private char kierunek ='a';
	/*
	 * Wysokosc duszka
	 */
	public int wys=32;
	/*
	 * Szerokosc duszka
	 */
	public int szer=32;
	/*
	 *	Tabela ze scianami
	 */
	private int[][] sciany=null;
	/*
	 *	Tabela obrazujaca plansze
	 */
	private char[][] plansza=null;
	/*
	 *	Tabela z zaznaczona droga do pacmana
	 */
	private char[][] droga=null;
	/*
	 * Okresla czy odnaleziona zostala sciezka do pacmana
	 */
	private boolean pacmanOdnaleziony =false;


	
	Duszek(int startPozX, int startPozY, int[][] sciany, int szybkoscp, char[][] punkty)
	{
		pozX=startPozX;
		pozY=startPozY;
		StartpozX=startPozX;
		StartpozY=startPozY;
		szybkosc=szybkoscp/2;
		this.sciany=sciany;
	//	int temp = punkty.length;
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
	/*
	 * Funkcja odpowiadajaca za zmiane skalowanie duszka
	 */
	public void zmianaRozmiarow(int nowaWys, int nowaSzer)
	{

		
		 for(int k =0; k<sciany.length; k++)
		 {
	 		sciany[k][0]=sciany[k][0]/szer*nowaSzer;
	 		sciany[k][1]=sciany[k][1]/wys*nowaWys;

		 }
	 		pozX=pozX/szer*nowaSzer;
	 		pozY=pozY/wys*nowaWys;
	 		
			wys=nowaWys;
			szer=nowaSzer;
	 		
			while(pozX%szer!=0)
				pozX--;
			while(pozY%wys!=0)
				pozY--;
	}
	
	/*
	 * Funkcja odpowiadajaca za ruch duszka
	 */
	public int[] droga(int pacX, int pacY)
	{
		int j=0;
		for(int i=0; j<plansza.length; i++)
		{
			if(plansza[i][j]=='q')
				plansza[i][j]=' ';
					
					if(i==plansza.length-1)
					{
						i=0;
						j++;
					}		
			
		}
		plansza[pacX/szer][pacY/wys]='q';

		
	//	pacmanOdnaleziony = false;
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

		/*szukajDrogi(pozX, pozY, plansza);
		
		if(pozX%szer==0 && pozY%wys==0)
		{
		if(droga[(pozX/szer)+1][pozY/wys] == 'O')
		{
			kierunek='E';
			droga[(pozX/szer)][pozY/wys] = 'M';
		}
		else if(droga[(pozX/szer)-1][pozY/wys] == 'O')
		{
			kierunek='W';
			droga[(pozX/szer)][pozY/wys] = 'M';
		}
		else if(droga[(pozX/szer)][(pozY/wys+1)] == 'O')
		{
			kierunek='S';
			droga[pozX/szer][(pozY/wys)] = 'M';
		}
		else if(droga[(pozX/szer)][(pozY/wys-1)] == 'O')
		{
			kierunek='N';
			droga[pozX/szer][(pozY/wys)] = 'M';
		}
		}*/
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
    	switch( kierunek ) { 
        case 'N':
        	for(int i=0; i<sciany.length; i++)
        	if(sciany[i][0]==pozX && sciany[i][1]==pozY-wys)
        	{
        		//if(bN==true || (sciany[i][0]==pozX+szer && sciany[i][1]==pozY))
        		//{
        		//	kierunek ='W';
        		//	kontynuuj =true;
        		//	break;
        			
        		//}
        		//else
        		//	bN=false;
        		
		    	kontynuuj = true;
		    	kierunek='E';
		    	break;
		    	//pozX=pozX+szybkosc;
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
    //	popKierunek=kierunek;
    		int[] pozD=new int[2];
    		pozD[0]=pozX;
    		pozD[1]=pozY;
		return pozD;
		
	}
	
	/*
	 * Funkcja szukajaca drogi do Pacmana
	 */
	private void szukajDrogi(int x, int y, char[][] plansza2)
	{

		//plansza2 - zmienna na ktorej zaznaczane beda punkty juz rozpatrzone

		plansza2[x/szer][y/wys] = 'O';
		if(pacmanOdnaleziony == false)
		{
		if(plansza2[(x/szer)+1][y/wys] != 'x' && plansza2[(x/szer)+1][y/wys]!= '-' && plansza2[(x/szer)+1][y/wys]!= '|' && plansza2[(x/szer)+1][y/wys]!= 'O')
		{
			if(plansza2[(x/szer)+1][y/wys] == 'q')
			{
				pacmanOdnaleziony = true;
				droga=plansza2;
			}
			szukajDrogi(x+szer,y,plansza2);
		}
		else if(plansza2[(x/szer)-1][y/wys] != 'x' && plansza2[(x/szer)-1][y/wys]!= '-' && plansza2[(x/szer)-1][y/wys]!= '|' && plansza2[(x/szer)-1][y/wys]!= 'O')
		{
			if(plansza2[(x/szer)-1][y/wys] == 'q')
			{
				pacmanOdnaleziony = true;
				droga=plansza2;
			}
			szukajDrogi(x-szer,y,plansza2);
		}
		if(plansza2[x/szer][(y/wys)+1] != 'x' && plansza2[x/szer][(y/wys)+1]!= '-' && plansza2[x/szer][(y/wys)+1]!= '|' && plansza2[x/szer][(y/wys)+1]!= 'O')
		{
			if(plansza2[x/szer][(y/wys)+1] == 'q')
			{
				pacmanOdnaleziony = true;
				droga=plansza2;
			}
			szukajDrogi(x,y+wys,plansza2);
		}
		if(plansza2[x/szer][(y/wys)-1] != 'x' && plansza2[x/szer][(y/wys)-1]!= '-' && plansza2[x/szer][(y/wys)-1]!= '|' && plansza2[x/szer][(y/wys)-1]!= 'O')
		{
			if(plansza2[x/szer][(y/wys)-1] == 'q')
			{
				pacmanOdnaleziony = true;
				droga=plansza2;
			}
			szukajDrogi(x,y-wys,plansza2);
		}
		
	}
	

}
	/*
	 * Duszek powraca do lokalizacji poczatkowej
	 */
	public void powrot()
	{
		pozX=StartpozX;
		pozY=StartpozY;
	}
}

