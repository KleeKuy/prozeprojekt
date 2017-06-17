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
 * Created by Alison on 2017-04-23.
 */

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
    
    private OknoNick okno;

    
	private char[][] pkty ;
	private int[] param  ;
	private int[][] sciany ;
	private int[][] owoce ;
	private int liczba_punktow ;
    

    public OknoNick(Menu menu) throws IOException {

 
        /**
         * Nadpisywanie parametru klasy nadrzędnej JFrame
         */
        super("Nick");

        
        	int temp[] = {3,0,1};
        	
        	config(temp,"TBD");
        
        
        
        //setContentPane(OknoNcikPanel);
        okno = this;
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


        nickFormattedTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        nickFormattedTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
            }
        });
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

                Plansza nextWindowGamew = new Plansza();
                nextWindowGamew.setVisible(true);
                
                
                Plansza okno2 = new Plansza();
        		//try {
					okno2.launchFrame(param[1],param[0],pkty,sciany,owoce,liczba_punktow,temp,okno,nazwyGraczy.get(0).pobierzNazwy());
				//} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
				//	e1.printStackTrace();
			//	}


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
    
    public void config(int[] parametry,String nazwa) throws IOException
    {
    		Odczytplanszy con = new Odczytplanszy();
    		pkty = con.odczytplanszy(parametry[2]);
    		param = con.odczytparametrow();
    		sciany = con.okreslaniePozycjiScian(pkty);
    		owoce = con.pozycjeOwocy(pkty);
    		liczba_punktow = con.liczba_punktow(pkty);
    	//	this.setVisible(false);
    		if(parametry[2]!=1)
    		{
    			OknoPlUkonczona okienko = new OknoPlUkonczona(param[1],param[0],pkty,sciany,owoce,liczba_punktow,okno,parametry,nazwa);
    			

    		}
    			
    }
    
}