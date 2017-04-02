package pacman;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


public class Config {
	
    static Properties testData;
    static String dataFile;
    static String propDirectory;

    //Wysokość okienka gry
    public static int wysokosc;

    //Szerokość okienka gry
    public static int szerokosc;

    //Kod obrazu rozróżniający pliki graficzne
    public static int kodobrazu;

    //Pliki z kolejnymi poziomami
    public  static String[] plikPoziom;

    //Plik z najlepszym wynikami
    public static String plikWyniki;

    //Plik z informacjami
    public static String plikInformacje;

    //Liczba dostępnych poziomów
    public static int liczbaPoziomow;

    //Liczba żyć
    public static int zycia;

    //Liczba punktów za zjedzenie białej kropki
    public static int pktKropka;

    //Liczba punktów za zjedzenie różowej kropki
    public static int pkyRozowaKropka;

    //Liczba duszków na aktualnej planszy
    public static int duszki;

    //Poziom trudności
    public static int poziomTrudnosci;

    //Tekst na przycisku Button1
    public static String tekstButton1;

    //Tekst na przycisku Button2
    public static String tekstButton2;

    //Tekst na przycisku Button3
    public static String tekstButton3;

    //Tekst na przycisku Button4
    public static String tekstButton4;
    
    /**
     * Metoda parsująca dane konfiguracyjne, dane są wczytane z lokalnego pliku konfiguracyjnego
     * 
     * @param config obiekt Properties przechowujący dane konfiguracyjne, które należy sparsować
     */
    public static void readConstants(Properties config) {

    	wysokosc = Integer.parseInt(config.getProperty("wysokosc"));
    	szerokosc = Integer.parseInt(config.getProperty("szerokosc"));
    	kodobrazu = Integer.parseInt(config.getProperty("kodobrazu"));
    	plikPoziom = config.getProperty("plikPoziom").split(","); //zmienielm na rodzielanie przecinkiemxd
    	plikWyniki = config.getProperty("plikWyniki");
    	plikInformacje=config.getProperty("plikInformacje");
    	liczbaPoziomow=Integer.parseInt(config.getProperty("liczbaPoziomow"));
    	zycia=Integer.parseInt(config.getProperty("zycia"));
    	pktKropka=Integer.parseInt(config.getProperty("pktKropka"));
    	pkyRozowaKropka=Integer.parseInt(config.getProperty("pkyRozowaKropka"));
    	duszki=Integer.parseInt(config.getProperty("duszki"));
    	poziomTrudnosci=Integer.parseInt(config.getProperty("poziomTrudnosci"));
    	tekstButton1=config.getProperty("tekstButton1");
    	tekstButton2=config.getProperty("tekstButton2");
    	tekstButton3=config.getProperty("tekstButton3");
    	tekstButton4=config.getProperty("tekstButton4");
   

    }
    


   
    static {
        propDirectory = System.getProperty("user.dir") + "/src/pacman/"; //katalog z plikiem properties
        try {
            loadTestData(); //odczyt danych z pliku
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    private static void loadTestData() throws FileNotFoundException, IOException {
        testData = new Properties();
        dataFile = "/config.properties";
        testData.load(new FileInputStream(propDirectory + dataFile));
    }
    
    //metoda używana do ładowania konkretnej wartości z pliku properties 
    protected static String getData(String key) {
 return testData.getProperty(key);
    }
}


















