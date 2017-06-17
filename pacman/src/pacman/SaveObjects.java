package pacman;

import java.awt.Frame;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;


public class SaveObjects {

	public static void main(String[] args) {
		
		Frame a = new Frame ("Tytul okna do zachowania w pliku");
		a.setBounds(20,20,400,500);
		a.setVisible(true);
		a.getGraphics().drawString("Ten napis nie zostanie zapisany razem z oknem...", 50, 100);
		
		FileOutputStream ostream = null;
		try {
			ostream = new FileOutputStream("obiekty.sav");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		ObjectOutputStream p = null;
		try {
			p = new ObjectOutputStream(ostream);
		    p.writeInt(1);
			p.writeObject("Tekst do zapisania");
			p.writeObject(new Date());
			p.writeObject(a);
			p.flush();
			ostream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		a.dispose();
	}
	
	public static void aktualizuj_wyniki(String nazwa_gracza, int zdobyte_punkty) throws IOException
	{
		StringBuilder sb= new StringBuilder();
	     Scanner sc = new Scanner(new FileReader("wyniki.txt"));
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
			int n = wyniki.length;
			boolean swapped;


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
			
			 PrintWriter writer = new PrintWriter("wyniki.txt", "UTF-8");	
			 
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