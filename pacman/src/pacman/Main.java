package pacman;

import java.io.IOException;

/**
 * Authors: M.Bałut, A.Sowińska
 */

public class Main {
	/**
	 *
	 * @param args Argumenty
	 * @throws IOException Wyjątek systemowy
	 * @throws InterruptedException Wyjątek systemowy
	 **/
	public static void main(String... args) {

	 

		Menu menuGlowne = new Menu();
		//Menu menuGlowne = new Menu(pkty,param,sciany,owoce,liczba_punktow);


		/*Plansza okno2 = new Plansza();
		Odczytplanszy con = new Odczytplanszy();
		char[][] pkty = con.odczytplanszy();
		int[] param = con.odczytparametrow();
		int[][] sciany = con.okreslaniePozycjiScian(pkty);
		int[][] owoce = con.pozycjeOwocy(pkty);
		okno2.launchFrame(param[1],param[0],pkty,sciany,owoce);
*/


	}

}

/*

public class Main {

	public static void main(String... args) throws IOException,InterruptedException{
		
   // Okno1m menuGlowne = new Okno1m();

		
		
	Plansza okno2 = new Plansza();
	Odczytplanszy con = new Odczytplanszy();
	char[][] pkty = con.odczytplanszy();
	int[] param = con.odczytparametrow();
	int[][] sciany = con.okreslaniePozycjiScian(pkty);
	okno2.launchFrame(param[1],param[0],pkty,sciany);
	

	
}
	
}*/