package pacman;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


public class Config {
	
    static Properties testData;
    static String dataFile;
    static String propDirectory;

   

   
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


















