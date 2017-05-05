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
	public char[][] odczytplanszy() throws IOException {
		
		int[] szerokoscwysokosc=this.odczytparametrow();
		wysokosc=szerokoscwysokosc[1];
		szerokosc=szerokoscwysokosc[0];
		

		FileReader filer = new FileReader(getData("plikPoziom"));
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
		    		sciany[k][0]=32*i;
		    		sciany[k++][1]=32*j;
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
}
		
		

