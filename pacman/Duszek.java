package pacman;

public class Duszek {

	private int pozX=0;
	private int pozY=0;
	private int szybkosc =1; //TODO zmienic
	private char kierunek ='a';
	int wys=32;
	int szer=32;
	int[][] sciany;
	
	Duszek(int startPozX, int startPozY, int[][] sciany)
	{
		pozX=startPozX;
		pozY=startPozY;
		this.sciany=sciany;
	}
	
	private void zmianaRozmiarow()
	{
		//TODO ta metoda ;p
	}
	
	public int[] droga(int pacX, int pacY)
	{
		boolean przeszkoda = false;
		
		int roznicaX=pozX-pacX;
		int roznicaY=pozY-pacY;
		
		if(pozX%szer==0 || pozY%wys==0)
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
		
    	switch( kierunek ) { 
        case 'N':

        	for(int i=0; i<sciany.length; i++)
        	if(sciany[i][0]==pozX && sciany[i][1]==pozY-wys)
        	{
		    	przeszkoda = true;
        	}
        	if(przeszkoda==false)	
        		pozY=pozY-szybkosc;
        	break;
        case 'S':
        	for(int i=0; i<sciany.length; i++)
	        	if(sciany[i][0]==pozX && sciany[i][1]==pozY+wys)
	        	{
			    	przeszkoda = true;
	        	}
	        	if(przeszkoda==false)	
	        		pozY=pozY+szybkosc;
            break;
        case 'W':
        	for(int i=0; i<sciany.length; i++)
	        	if(sciany[i][0]==pacX-szer && sciany[i][1]==pozY)
	        	{
			    	przeszkoda = true;
	        	}
	        	if(przeszkoda==false)	
	        		pozX=pozX-szybkosc;
            break;
        case 'E':
        	for(int i=0; i<sciany.length; i++)
	        	if(sciany[i][0]==pacX+szer && sciany[i][1]==pozY)
	        	{
			    	przeszkoda = true;
	        	}
	        	if(przeszkoda==false)	
	        		pozX=pozX+szybkosc;
            break;
     }
    		int[] pozD=new int[2];
    		pozD[0]=pozX;
    		pozD[1]=pozY;
		return pozD;
		
	}
}
