package pacman;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
/**
 * Klasa odpowiadajaca za odczytywania wynikow
 */
public class LoadObjects {

	/**
	 * Odczytywanie wynikow z pliku tekstowego
	 * @return Wyniki
	 * @throws IOException
	 */
		public static String pobierzWyniki() throws IOException{

			StringBuilder sb= new StringBuilder();
			BufferedReader br = new BufferedReader(new FileReader("wyniki.txt"));

				char znak;
				while((znak=(char)br.read())!=']')
				{
					sb.append(znak);


					}
					br.close();
				return sb.toString();	


			
		}



		
}