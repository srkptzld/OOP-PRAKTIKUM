package nimmspiel;

import java.util.Random;

/**
 * Enthält größtenteils Daten des Spiels und 
 * Get-/Set-Methoden der Attribute
 * 
 * @author funbold
 */
public class Spiel {
	
    private Spieler _spieler;
    private Com _com;
    private int _anzSteine;
    private byte _dran;
    private int _rundenZaehler;

    /**
     * Konstruktor
     * 
     * @param name
     */
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

    /**
     * Get-Methode für Spieler
     * 
     * @return
     */
    public Spieler getSpieler() { 		
	return _spieler;		
    }
	

    /**
     * Get-Methode für COM
     * 
     * @return
     */
    public Com getCom() { 	
	return _com;		
    }

    /**
     * Get-Methode für die Anzahl der Steine
     * 
     * @return
     */
    public int getSteine() { 		
	return _anzSteine;		
    }

    /**
     * Get-Methode für "dran"
     * 
     * @return
     */
    public byte getDran() { 		
	return _dran;		
    }

    /**
     * Get-Methode für Runde
     * 
     * @return
     */
    public int getRunde() { 		
	return _rundenZaehler;	
    }

    /**
     * Methode, um bei einem Zug die AnzahlSteine zu verringern
     *
     * @param anzahl
     */
    public void verringereSteineUm(int anzahl) { 		
	_anzSteine = _anzSteine - anzahl;	
    }

    /**
     * Set-Methode, um festzulegen wer an der Reihe ist
     * 
     * @param dran
     */
    public void setDran(byte dran) { 		
	_dran = dran;		
    }
	// N�chste Runde

    /**
     * Erhöht den Rundenzaehler
     */
    public void erhoeheRunde() { 	
	_rundenZaehler = _rundenZaehler + 1;		
    }
	
}
