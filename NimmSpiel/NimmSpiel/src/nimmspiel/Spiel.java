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
		
		_anzSteine = (int)(Math.random() * 10) + 20; // Legt einen Anfangswert zwischen 20 & 30 für den Steinhaufen fest
		
		_spieler = new Spieler(name); // Erzeugt Spieler
		_com = new Spieler(Com); // Erzeugt Com
		
	}
    
	
	
}
