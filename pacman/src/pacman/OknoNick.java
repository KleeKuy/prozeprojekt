package pacman;

import Nazwy.Nazwy;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Okienko z wpisywaniem nazwy przez gracza
 */
public class OknoNick extends JFrame  {
    /**
     * Panel okienka
     */
    private JPanel OknoNcikPanel;
    /**
     * Pole instruujące do wpisania nazwy
     */
    private JTextField wpiszSwójNickTextArea;
    /**
     * Pole do wpisywania nazwy
     */
    private JFormattedTextField nickFormattedTextField;
    /**
     * Przycisk "Wstecz"
     */
    private JButton wsteczButton;
    /**
     *  Przycisk zapisujący nazwę i przechodzący do gry
     */
    private JButton zapiszIGrajButton;
    /**
     * Lista składająca się z nazw graczy
     */
    private final List<Nazwy> nazwyGraczy = new ArrayList<Nazwy>();
    /**
     * Ten obiekt
     */
    private OknoNick okno;
    /**
     * Plansza gry zapisana w postali tablicy charow
     */
	private char[][] pkty ;
	/**
	 * Zawiera wysokosc i szerokosc planszy oraz numer planszy
	 */
	private int[] param  ;
	/**
	 * Pozycje scian na planszy
	 */
	private int[][] sciany ;
	/**
	 * Pozycje owocy na planszy
	 */
	private int[][] owoce ;
	/**
	 * Liczba zdobytych punktow
	 */
	private int liczba_punktow ;
    
/**
 * Konstruktor okna zapisujacego nick gracza
 * @param menu menu glowne
 * @throws IOException
 */
    public OknoNick(Menu menu) throws IOException {

 
        /**
         * Nadpisywanie parametru klasy nadrzędnej JFrame
         */
        super("Nick");

        
        	int temp[] = {3,0,1};
        	
        	config(temp,"TBD");
        
        
        
        okno = this;
        //Tworzenie zawartosci okna
        OknoNcikPanel = new JPanel();
        JPanel panel2 = new JPanel();
        OknoNcikPanel.setLayout(new BorderLayout());
        panel2.setLayout(new BorderLayout());
        wsteczButton = new JButton();
        wsteczButton.setPreferredSize(new Dimension(200,35));
        zapiszIGrajButton = new JButton();
        zapiszIGrajButton.setPreferredSize(new Dimension(200,35));
        
        wpiszSwójNickTextArea = new  JTextField();
        
        nickFormattedTextField = new JFormattedTextField();
        
        wpiszSwójNickTextArea.setPreferredSize(new Dimension(200,35));
        nickFormattedTextField.setPreferredSize(new Dimension(200,35));
        
        wpiszSwójNickTextArea.setEditable(false);
        wpiszSwójNickTextArea.setHorizontalAlignment(JTextField.CENTER);
        wpiszSwójNickTextArea.setText("Podaj swój nick:");
        
        wsteczButton.setText("Wstecz");
        zapiszIGrajButton.setText("Zapisz i graj");
        panel2.add(zapiszIGrajButton,BorderLayout.WEST);
        panel2.add(wsteczButton,BorderLayout.EAST);

        OknoNcikPanel.add(panel2,BorderLayout.SOUTH);
        OknoNcikPanel.add(nickFormattedTextField,BorderLayout.CENTER);
        OknoNcikPanel.add(wpiszSwójNickTextArea,BorderLayout.NORTH);

        
        
        add(OknoNcikPanel);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

/**
 * Ustawienie widoczności okienka
 */
        setVisible(true);
  
        zapiszIGrajButton.addActionListener(new ActionListener() {
            @Override
            /**
             * Ustawienie funkcji przycisku
             */
            public void actionPerformed(ActionEvent e) {
                nazwyGraczy.add(new Nazwy(nickFormattedTextField.getText()));

                /**
                 * Wyświetlenie komunikatu
                 */
                JOptionPane.showMessageDialog(null,"Podana nazwa: "+ nazwyGraczy.get(0).pobierzNazwy(), "Nazwa #1", JOptionPane.PLAIN_MESSAGE);
                //Rozpoczecie gry
                Plansza okno2 = new Plansza();
				okno2.launchFrame(param[1],param[0],pkty,sciany,owoce,liczba_punktow,temp,okno,nazwyGraczy.get(0).pobierzNazwy());



            }
        });
        /**
         * Ustawienie funckji prycisku
         */
        wsteczButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	menu.setVisible(true);
                setVisible(false);
            }
        });
    }
    /**
     * Funkcja odczytujaca z pliku wartosci potrzebne do rozpoczecia gry
     * @param parametry Zawiera wysokosc i szerokosc planszy oraz numer planszy
     * @param nazwa Nazwa gracza
     * @throws IOException
     */
    public void config(int[] parametry,String nazwa) throws IOException
    {
    		Config con = new Config();
    		pkty = con.odczytplanszy(parametry[2]);
    		param = con.odczytparametrow(parametry[2]);
    		sciany = con.okreslaniePozycjiScian(pkty);
    		owoce = con.pozycjeOwocy(pkty);
    		liczba_punktow = con.liczba_punktow(pkty);
    		if(parametry[2]!=1)
    		{
    			OknoPlUkonczona okienko = new OknoPlUkonczona(param[1],param[0],pkty,sciany,owoce,liczba_punktow,okno,parametry,nazwa);
    			

    		}
    			
    }
    
}