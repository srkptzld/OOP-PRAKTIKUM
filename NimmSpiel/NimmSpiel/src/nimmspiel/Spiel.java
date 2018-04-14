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
		// keine Methode SetSteine sondern VerringereSteineUm(int anzahl) !! macht mehr sinn
                // Methode getCom(): Com auch ins UML..
		
		this._anzSteine = (int)(Math.random() * 10) + 20; // Legt einen Anfangswert zwischen 20 & 30 für den Steinhaufen fest
		
		this._spieler_spieler = new Spieler(name); // Erzeugt Spieler
		this._spieler_com = new Spieler(COM); // Erzeugt Com
		
		this._rundenZaehler = 1; // Setzt Runde auf 1
		
	}
    
	public void Run() {
		
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
		
		return dran;
		
	}
	
	public int getRunde() {
		
		return rundenZaehler;
	
	}
	
	public void verringereSteineUm(int anzahl) { // Verrignert nach Zug den Steinhaufen um angegebenen Wert
		
		_anzSteine = _anzSteine - anzahl;
		
	}
	
	public void setDran(byte dran) { 
		
		_dran = dran;
		
	}
	
	public void erhoeheRunde() { // Nächste Runde
		
		rundenZaehler = rundenZaehler + 1;
		
	}
	
}
