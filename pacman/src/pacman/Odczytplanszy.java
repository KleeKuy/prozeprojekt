package pacman;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import static pacman.Config.getData;


public class Odczytplanszy {
	
	public String tabela;
	private int wysokosc;
	private int szerokosc;
	
	 /**
     * Funkcja zwracająca wysokość i szerokość planszy
     */
	public int[] odczytparametrow() throws IOException{
	
		int[] parametry = new int[2];
		
		  FileReader fr = new FileReader(getData("plikPoziom"));
		  BufferedReader br = new BufferedReader(fr);
	      Scanner sc = new Scanner(br);
	      parametry[0] = sc.nextInt();
	      parametry[1] = sc.nextInt();
	      sc.close();
		return parametry;
	}

	 /**
     * Funkcja odczytujaca plansze z pliku tekstowego i zwracajaca ja w postaci tabeli
     */
	public char[][] odczytplanszy(int numer_planszy) throws IOException {
		
		int[] szerokoscwysokosc=this.odczytparametrow();
		wysokosc=szerokoscwysokosc[1];
		szerokosc=szerokoscwysokosc[0];
		FileReader filer =null;
		
		if(numer_planszy==1)
		 filer = new FileReader(getData("plikPoziom"));
		else if(numer_planszy==2)
		 filer = new FileReader(getData("plikPoziom2"));
		else
		 filer = new FileReader(getData("plikPoziom3"));
		
		BufferedReader buffr = new BufferedReader(filer);
		
		if(wysokosc<10 && szerokosc<10)
		buffr.skip(6);
		else if((wysokosc>=10 && szerokosc<10) || (wysokosc<10 && szerokosc>=10))
		buffr.skip(7);
		else if(wysokosc>10 && szerokosc>10)
		buffr.skip(8);
		
		
		char[][] punkty = new char[szerokosc][wysokosc];
		
		int i=0;
		int j=0;
		
		while(j!=wysokosc)
		{
			char temp = (char)buffr.read();
			punkty[i][j] = temp;
			i++;
			if(i==szerokosc)
			{
				buffr.skip(2);
				i=0;
				j++;
			}
		

		}

		buffr.close();
		return punkty;
		}

	

	 /**
     * Funkcja odczytujaca miejsca wystepowania scian
     */
	public int[][] okreslaniePozycjiScian(char punkty[][])
	{
		int i=0;
		int j=0;
		int liczbaScian=0;
		
		 for(int k =0; k<szerokosc*wysokosc; k++) {
		    	if(punkty[i][j]=='-' || punkty[i][j]=='|' || punkty[i][j]=='x')
				{
		    		liczbaScian++;
				}
				
		    	i++;
		    	if(i==szerokosc)
				  {
					  i=0;
					  j++;
				  }
		    }
		 
		 i=0;
		 j=0;
		int sciany[][] = new int[liczbaScian][2];
		
		 for(int k =0; k<liczbaScian;) {
		    	if(punkty[i][j]=='-' || punkty[i][j]=='|' || punkty[i][j]=='x')
				{
		    		sciany[k][0]=i*32;
		    		sciany[k++][1]=j*32;
				}
				
		    	i++;
		    	if(i==szerokosc)
				  {
					  i=0;
					  j++;
				  }
		    }
		return sciany;
	}
	/**
	 * Okreslanie pozycji owocy
	 * @param punkty plansza
	 * @return pozycje owocy
	 */
	public int[][] pozycjeOwocy(char punkty[][])
	{
		int i=0;
		int j=0;
		int liczbaOwocow=0;
		
		 for(int k =0; k<szerokosc*wysokosc; k++) {
		    	if(punkty[i][j]=='o')
				{
		    		liczbaOwocow++;
				}
				
		    	i++;
		    	if(i==szerokosc)
				  {
					  i=0;
					  j++;
				  }
		    }
		 
		 i=0;
		 j=0;
		int owoce[][] = new int[liczbaOwocow][2];
		
		 for(int k =0; k<liczbaOwocow;) {
		    	if(punkty[i][j]=='o')
				{
		    		owoce[k][0]=i*32;
		    		owoce[k++][1]=j*32;
				}
				
		    	i++;
		    	if(i==szerokosc)
				  {
					  i=0;
					  j++;
				  }
		    }
		return owoce;
	}
	
	public int liczba_punktow(char punkty[][])
	{
		int i=0;
		int j=0;
		int liczba_punktow=0;
		
		 for(int k =0; k<szerokosc*wysokosc; k++) {
		    	if(punkty[i][j]==' ' || punkty[i][j]=='d' || punkty[i][j]=='n')
				{
		    		liczba_punktow++;
				}
				
		    	i++;
		    	if(i==szerokosc)
				  {
					  i=0;
					  j++;
				  }
		    }
		 
		return liczba_punktow;
	}
	
}



		
		

