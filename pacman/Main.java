package pacman;

import java.io.IOException;


public class Main {
	public static void main(String... args) throws IOException,InterruptedException{
		
  //  Okno1m okno1 = new Okno1m();
		
	Plansza plansza = new Plansza();
	Odczytplanszy con = new Odczytplanszy();
	char[][] pkty = con.odczytplanszy();
	int[] param = con.odczytparametrow();
	plansza.launchFrame(param[1],param[0],pkty);
	

	
}

}
