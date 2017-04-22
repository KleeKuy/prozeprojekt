package pacman;

import java.awt.Frame;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Date;

public class LoadObjects {

	public static void main(String[] args) {
		FileInputStream istream = null;
		String tekst="";
		Date date = null;
		int i = 0;
		Frame okno = null;
		try {
			istream = new FileInputStream("obiekty.sav");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		ObjectInputStream p;
		try {
			p = new ObjectInputStream(istream);
			i = p.readInt();
			try {
				tekst = (String)p.readObject();
				date = (Date)p.readObject();
				okno = (Frame)p.readObject();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
			istream.close(); 
		} catch (IOException e) {
			e.printStackTrace();
		}
		okno.setVisible(true);
		System.out.println(i);
		System.out.println(tekst);
		System.out.println(date.toString());
	}

}