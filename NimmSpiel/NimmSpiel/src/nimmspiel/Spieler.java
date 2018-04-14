package nimmspiel;


import java.util.Scanner;
/**
 *
 * @author funbold
 */
public class Spieler implements IPlayingMember {
	
	private String _name;
	
	public Spieler(String name) { // Konstruktor
		
		_name = name;
		
	}

    @Override
    public int Zug(int verbleibendeSteine) { // Nimmt den Zug entgegen und prüft ob regelkonform
        
    	boolean konform = false;
    	int abzug;
    	
    	System.out.println("Wieviele Steine möchten Sie nehmen?");
    	
    	while(konform == false) {
    		
    		Scanner scanner = new Scanner(System.in);
            abzug = scanner.nextLine();
    		
            if(abzug < 1 || abzug > 3) {
            	System.out.println("Die Eingabe ist nicht regelkonform.");
            	System.out.println("Bitte wählen Sie eine Zahl von 1 bis 3.");
            }else {
            	konform == true;
            }
    		
    	}
    	
    	return abzug;
    	
    }

    @Override
    public String getName() {
        return _name;
    }

}
