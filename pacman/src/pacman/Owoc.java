package pacman;

public class Owoc{
	
	/**
	 * Okresla szybkosc z jaka aktualnie bedzie poruszac sie pacman
	 */
	private int szybkosc=0;
	/**
	 * Określa ile razy zmieni sie szybkosc pacmana
	 */
	private int zmiana_szybkosci=2;
	/**
	 * Pozycja w osi pionowej obiektu
	 */
	private int pozX=0;
	/**
	 * Pozycja w osi poziomej obiektu
	 */
	private int pozY=0;
	/**
	 * Czas zjedzenia owocu
	 */
	private long czas=0;
	/**
	 * Czy owoc zostal zjedzony
	 */
	public boolean zjedzony = false;
	/**
	 * Okresla czy owoc zostal zjedzony i czas jego dzialania sie skonczyl
	 */
	public boolean koniec = false;
	

	/**	
	 * Konstruktor w ktorym do zmiennej szybkosc przypisaywana jest akutalna szybkosc pacmana i pozycja owocu
	 * @param szybkosc Szybkosc pacmana przed przyspieszeniem
	 * @param x Pozycja x
	 * @param y Pozycja y
	 */
	Owoc(int szybkosc,int x, int y){
		this.szybkosc=szybkosc;
		pozX= x;
		pozY= y;
	}

	

	/**
	 * Funkcja sprawdzajaca czy Pacman zjadl owoc
	 * @param x Pozycja x pacmana
	 * @param y Pozycja y pacmana
	 */
	public void czyzjadl(int x, int y)
	{
		if(x==pozX && y==pozY)
		{
			szybkosc=szybkosc*zmiana_szybkosci;
			czas = System.currentTimeMillis();
			zjedzony = true;
		}
	}

	public void skalowanie()
	{
		//TODO skalowanie
	}
	public void koniecCzasu()
	{
		if(czas!=0)
		if(System.currentTimeMillis()-czas>5000)
		{
			szybkosc=szybkosc/zmiana_szybkosci;
			koniec = true;
		}
	}
	
	public int jakaSzybkosc()
	{
		return szybkosc;
	}
	
}
