package nimmspiel;

import java.util.Random;

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
	
	// Konstruktor
	public Spiel(String name) { 
		
		// Legt einen Anfangswert zwischen 20 & 30 f�r den Steinhaufen fest
		_anzSteine = (int)(Math.random() * 10) + 20; 
		
		// Erzeugt Spieler
		_spieler = new Spieler(name); 
		// Erzeugt Com
		_com = new Com(); 
                
		// Legt fest, welcher Spieler anf�ngt
                boolean starter = new Random().nextBoolean();
                _dran = (byte)(starter?1:0);
        
		
        // Setzt Runde auf 1
		_rundenZaehler = 1; 
		
	}
	// Getter Spieler
	public Spieler getSpieler() { 		
		return _spieler;		
	}
	// Getter Com	
	public Com getCom() { 	
		return _com;		
	}
	// Getter Anzahl Steine
	public int getSteine() { 		
		return _anzSteine;		
	}
	// Getter Dran
	public byte getDran() { 		
		return _dran;		
	}
	// Getter Rundenzaehler
	public int getRunde() { 		
		return _rundenZaehler;	
	}
	// Verringert nach Zug den Steinhaufen um angegebenen Wert
	public void verringereSteineUm(int anzahl) { 		
		_anzSteine = _anzSteine - anzahl;	
	}
	// Setter Dran
	public void setDran(byte dran) { 		
		_dran = dran;		
	}
	// N�chste Runde
	public void erhoeheRunde() { 	
		_rundenZaehler = _rundenZaehler + 1;		
	}
	
}
