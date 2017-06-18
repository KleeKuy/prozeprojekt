package pacman;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

/**
 * Klasa zawierająca wszystkie stałe parametry
 */
public class Config {
/**
 * Wlasciwosci odczytne z pliku
 */
    static Properties testData;
/**
* Sciezka do pliku
*/
static String dataFile;
/**
 * Folder z plikiem
 */
static String propDirectory;
/**
 * Wysokosc planszy (liczba pol)
 */
private int wysokosc;
/**
 * Szerokosc planszy (liczba pol)
 */
private int szerokosc;



    /**
     * Katalog z plikiem properties
     */
    static {
        propDirectory = System.getProperty("user.dir");
        try {
            /**
             * Odczyt danych z pliku
             */
            loadTestData();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Ladowanie danych z pliku
     * @throws FileNotFoundException Obsługiwany wyjątek
     * @throws IOException Obsługiwany wyjątek
     */
    private static void loadTestData() throws FileNotFoundException, IOException {
        testData = new Properties();
        dataFile = "/config.properties";
        testData.load(new FileInputStream(propDirectory + dataFile));
    }

    /**
     * Metoda używana do ładowania konkretnej wartości z pliku properties
     * @param key Parametr za pomocą którego możliwe jest określenie jakie dane chcemy pobrać
     * @return Zwraca konkretne dane
     */
    protected static String getData(String key) {
        return testData.getProperty(key);
    }
    
    /**
     * Funkcja zwracająca wysokość i szerokość planszy
     * @param numer_planszy numer planszy na ktorej bedzie toczyc sie rozgrywka
     * @return wysokosc i szerokosc planszy (liczba pol)
     * @throws IOException
     */
	public int[] odczytparametrow(int numer_planszy) throws IOException{
	
		int[] parametry = new int[2];
		
		
		  FileReader fr = null;
		  if(numer_planszy==1)
			  fr = new FileReader(getData("plikPoziom"));
			else if(numer_planszy==2)
				fr = new FileReader(getData("plikPoziom2"));
			else if(numer_planszy==3)
				fr = new FileReader(getData("plikPoziom3"));
			else if(numer_planszy==4)
				fr = new FileReader(getData("plikPoziom4"));
			else
				fr = new FileReader(getData("plikPoziom5"));
		  BufferedReader br = new BufferedReader(fr);
	      Scanner sc = new Scanner(br);
	      parametry[0] = sc.nextInt();
	      parametry[1] = sc.nextInt();
	      sc.close();
		return parametry;
	}

	/**
	 * Funkcja odczytujaca plansze z pliku tekstowego i zwracajaca ja w postaci tabeli
	 * @param numer_planszy numer_planszy numer planszy na ktorej bedzie toczyc sie rozgrywka
	 * @return plansza odczytana z pliku zapisana jako tablica charow
	 * @throws IOException
	 */
	public char[][] odczytplanszy(int numer_planszy) throws IOException {
		
		int[] szerokoscwysokosc=this.odczytparametrow(numer_planszy);
		wysokosc=szerokoscwysokosc[1];
		szerokosc=szerokoscwysokosc[0];
		FileReader filer =null;
		
		if(numer_planszy==1)
		 filer = new FileReader(getData("plikPoziom"));
		else if(numer_planszy==2)
		 filer = new FileReader(getData("plikPoziom2"));
		else if(numer_planszy==3)
		 filer = new FileReader(getData("plikPoziom3"));
		else if(numer_planszy==4)
			 filer = new FileReader(getData("plikPoziom4"));
		else if(numer_planszy==5)
			 filer = new FileReader(getData("plikPoziom5"));
		
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
	 * @param punkty plansza zapisana jako tablica charow
	 * @return miejsca wystepowania scian
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
	 * @param punkty plansza zapisana jako tablica charow
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
	/**
	 * Okreslanie maksymalnej liczba punktow do zdobycia na planszy
	 * @param punkty Tablica obrazujaca plansze
	 * @return maksymalna liczba punktow do zdobycia na tej planszy
	 */
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