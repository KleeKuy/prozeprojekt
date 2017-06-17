package pacman;

import java.awt.Image;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import static pacman.Config.getData;


@SuppressWarnings("serial")
public class Plansza extends JFrame{

	public int liczba_punktow=0;
	public int liczba_punktow_wynik=0;
	public int numer_planszy=1;
	private int max_punkty=0;
	private int liczba_zyc = 3;
	private JTextField wynik=null;
	private JTextField zycia=null;
	private Obrazgra gra=null;
	private OknoNick okno=null;
	private String nazwa=null;
	
	
	//Funkcja tworzaca Frame na ktorym toczy sie rozgrywka
	public void launchFrame(int wysokosc, int szerokosc,char[][] punkty,int[][] sciany,int[][] owoce,int maxPunkty,
			int[] param,OknoNick oknoN, String nazwa_gracza) {
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(1);
			}
		});
		nazwa=nazwa_gracza;
		okno=oknoN;
		okno.setVisible(false);
		liczba_zyc=param[0];
		max_punkty=maxPunkty;
		liczba_punktow_wynik=param[1];
		numer_planszy=param[2];
		
		//tworzenie panelu
		JPanel mainpanel = new JPanel(new BorderLayout());

		
		
		//tworzenie komponentow interfejsu
		wynik = new JTextField("Wynik");
		wynik.setPreferredSize(new Dimension(100,35));
		wynik.setEditable(false);
		zycia = new JTextField("Życia " +liczba_zyc);
		zycia.setEditable(false);
		zycia.setHorizontalAlignment(JTextField.CENTER);
		JButton button = new JButton(getData("pauza"));
		button.setPreferredSize(new Dimension(100,40));
		
		button.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
			    selectionButtonPressed();
			  }

			private void selectionButtonPressed()
			{
				gra.pauza();
			} 
			} );
		  // final Obrazgra gra = new Obrazgra(wysokosc,szerokosc,punkty,sciany,owoce,this);
		gra = new Obrazgra(wysokosc,szerokosc,punkty,sciany,owoce,this);
		   addComponentListener(new ComponentAdapter() {
	        	public void componentResized(ComponentEvent ce) {
	        		gra.updateOffscreenSize(ce.getComponent().getWidth(), ce.getComponent().getHeight());
	        	}
	        });
			//dodawanie komponentow do panelu
			mainpanel.add(wynik,BorderLayout.WEST);
			mainpanel.add(zycia,BorderLayout.CENTER);
			mainpanel.add(button,BorderLayout.EAST);
			mainpanel.add(gra,BorderLayout.SOUTH);
			add(mainpanel);
	
		
		pack();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				setVisible(true);
			}
		});		
		(gra.kicker = new Thread(gra)).start();

	
}
	
	public void dodajPunkt()
	{
		liczba_punktow++;
		liczba_punktow_wynik++;
		wynik.setText("Wynik "+liczba_punktow_wynik);	
		if(liczba_punktow==max_punkty)
		{
			gra.koniec=true;
			this.setVisible(false);
			okno.setVisible(true);
			numer_planszy++;
			try {
				int[] parametr = new int[3];
				parametr[0]=liczba_zyc;
				parametr[1]=liczba_punktow_wynik;
				parametr[2]=numer_planszy;
				okno.config(parametr,nazwa);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
	}

	public void utrataZycia()
	{
		liczba_zyc--;
		zycia.setText("Życia "+liczba_zyc);
		if(liczba_zyc==0)
		{
			gra.koniec=true;
			this.setVisible(false);
			JOptionPane.showMessageDialog(null,"Porażka!", "Porażka!", JOptionPane.PLAIN_MESSAGE);
			okno.setVisible(true);
			try {
				//Zycia sie skonczyly, przekazywana jest informacja o numerze planszy i liczbie zyc oraz punktow
				int[] parametr = new int[3];
				parametr[0]=3;
				parametr[1]=0;
				parametr[2]=1;
			     try {
						SaveObjects.aktualizuj_wyniki(nazwa, liczba_punktow_wynik);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				okno.config(parametr,nazwa);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		gra.utrata_zycia();
		
		
	}



		
	}
