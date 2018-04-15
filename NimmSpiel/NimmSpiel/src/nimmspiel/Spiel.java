package nimmspiel;

/**
 *
 * @author funbold
 */
public class Spiel {
	
	private Spieler _spieler;
	private Com _com;
	private int _anzSteine;
	private byte _dran;
	private int _rundenZaehler;
	
	public Spiel(String name) {
		
		_anzSteine = (int)(Math.random() * 10) + 20; // Legt einen Anfangswert zwischen 20 & 30 f�r den Steinhaufen fest
		
		_spieler = new Spieler(name); // Erzeugt Spieler
                _com = new Com(); // Erzeugt Com
		
		_rundenZaehler = 1; // Setzt Runde auf 1
		
	}
    
	public Spieler getSpieler() {
		
		return _spieler;
		
	}
	
	public Com getCom() {
		
		return _com;
		
	}
	
	public int getSteine() {
		
		return _anzSteine;
		
	}
	
	public byte getDran() {
		
		return _dran;
		
	}
	
	public int getRunde() {
		
		return _rundenZaehler;
	
	}
	
	public void verringereSteineUm(int anzahl) { // Verrignert nach Zug den Steinhaufen um angegebenen Wert
		
		_anzSteine = _anzSteine - anzahl;
		
	}
	
	public void setDran(byte dran) { 
		
		_dran = dran;
		
	}
	
	public void erhoeheRunde() { // N�chste Runde
		
		_rundenZaehler = _rundenZaehler + 1;
		
	}
	
}
