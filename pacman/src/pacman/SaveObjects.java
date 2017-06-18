package pacman;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

/**
 * Klasa odpowiadajaca za uaktualnianie pliku tekstowego z wynimaki
 */
public class SaveObjects {

	/**
	 * Aktualizacja wynikow w pliku tekstowym
	 * @param nazwa_gracza Nowa nazwa gracza nowego rekordu
	 * @param zdobyte_punkty Liczba punktow nowego rekordu
	 */
	public static void aktualizuj_wyniki(String nazwa_gracza, int zdobyte_punkty) 
	{
		//Odczyt aktualnych wynikow
	     Scanner sc = null;
		try {
			sc = new Scanner(new FileReader("wyniki.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
			String test = new String();
			String temp = null;
			Rekord[] wyniki = new Rekord[11]; 
			for(int i=1; i<11;)
			{
				 test = sc.next();
				 temp = new String(i + ".");
			if(test.equals(temp) == true)
			{
				wyniki[i-1] = new Rekord();
				wyniki[i-1].liczba_punktow=sc.nextInt();
				sc.next();
				wyniki[i-1].nazwa_gracza=sc.next();
				i++;
				
			}
			}
			sc.close();
			wyniki[10] = new Rekord();
			wyniki[10].liczba_punktow=zdobyte_punkty;
			wyniki[10].nazwa_gracza=nazwa_gracza;
			
			Rekord temp1 = new Rekord();

			//Sortowanie tablicy wynikow z juz dodanym nowym rekordem
			int j;
			for(int i=1; i<wyniki.length; i++)
			{
				j=i;
				while(j > 0 && wyniki[j-1].liczba_punktow > wyniki[j].liczba_punktow)
				{
					temp1=wyniki[j-1];
					wyniki[j-1]=wyniki[j];
					wyniki[j]=temp1;
					j--;
				}
			}
			//Zapisywanie nowych wynikow
			 PrintWriter writer = null;
			try {
				writer = new PrintWriter("wyniki.txt", "UTF-8");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}	
			 
			 int k=1;
			 for(int i=11; i>1; i--)
			 {
				 writer.println(k + ". " + wyniki[i-1].liczba_punktow + " pkt " + wyniki[i-1].nazwa_gracza);
				 k++;
			 }
			 writer.write("]");
			    writer.close();	

	 
	
	}

}