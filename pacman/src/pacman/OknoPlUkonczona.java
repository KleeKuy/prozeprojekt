package pacman;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * Okno wyswietlajace sie po ukonczeniu planszy
 */
public class OknoPlUkonczona extends JFrame{
	
	/*
	 * Przycisk ktorego nacisniecie powoduje rozpoczecie kolejnej planszy
	 */
	private JButton OK;
	/*
	 * Pole tekstowe informujace o ukonczeniu planszy
	 */
	private JTextField plansza_ukonczona;
	/*
	 * Glowny panel okna
	 */
	private JPanel ukonconopanel;
	
	/**
	 * Konstruktor obiektu
	 * @param param1 wysokosc planszy
	 * @param param2 szerokosc planszy
	 * @param pkty plansza
	 * @param sciany pozycje scian
	 * @param owoce pozycje owocow
	 * @param liczba_punktow zdobyte do tej pory punkty
	 * @param okno okno z ktorego wywolany zostal ten konstruktor
	 * @param liczbaZyc pozostala liczba zyc
	 * @param nazwa nazwa gracza
	 */
	public OknoPlUkonczona(int param1,int param2,char [][] pkty,int[][] sciany,int[][] owoce,int liczba_punktow,OknoNick okno,int[] liczbaZyc,String nazwa)
	{
		
		  super("Plansza ukonczona!");

		  

		  //Utworzenie przyciskow i tekstu oraz jego wyswietlenie
      ukonconopanel = new JPanel();
      ukonconopanel.setLayout(new BorderLayout());
      OK = new JButton();
      OK.setPreferredSize(new Dimension(500,100));
      plansza_ukonczona = new JTextField();
      plansza_ukonczona.setPreferredSize(new Dimension(500,300));
      
      
      plansza_ukonczona.setEditable(false);
      plansza_ukonczona.setHorizontalAlignment(JTextField.CENTER);
      plansza_ukonczona.setText("Gratulacje! Plansza ukonczona!");
      
      OK.setText("Nastepna plansza");

      ukonconopanel.add(OK,BorderLayout.SOUTH);
      ukonconopanel.add(plansza_ukonczona,BorderLayout.NORTH);

      
      
      add(ukonconopanel);
      pack();
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

/**
* Ustawienie widoczności okienka
*/
      setVisible(true);
      
      /**
       * Ustawienie funckji prycisku
       */
      OK.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
    			Plansza okno2 = new Plansza();
    			okno2.launchFrame(param1,param2,pkty,sciany,owoce,liczba_punktow,liczbaZyc,okno,nazwa);
              setVisible(false);
          }
      });
	}

}
