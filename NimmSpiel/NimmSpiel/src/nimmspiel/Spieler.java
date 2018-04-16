package nimmspiel;


import java.util.Scanner;
/**
 *
 * @author funbold
 */
public class Spieler implements IPlayingMember {
	
	private String _name;
	
	// Konstruktor	
	public Spieler(String name) { 
		_name = name;	
	}

	// Nimmt den Zug entgegen und pr�ft ob regelkonform
    @Override
    public int Zug(int verbleibendeSteine) { 
        
    	boolean konform = false;
    	int abzug = 0;
    	
    	System.out.println("Wieviele Steine möchten Sie nehmen?");
    	
    	while (konform == false) {
    		
    		Scanner scanner = new Scanner(System.in);
            abzug = scanner.nextInt();
    		
            if (abzug < 1 || abzug > 3) {
            	System.out.println("Die Eingabe ist nicht regelkonform.");
            	System.out.println("Bitte wählen Sie eine Zahl von 1 bis 3.");
            }else if (verbleibendeSteine - abzug < 0){
            	System.out.println("Die Eingabe ist nicht regelkonform.");
                Ausgabe.ZugEnde(0, null);
                
            }else {
            	konform = true;
            }
    		
    	}
    	
    	return abzug;
    	
    }

 // Getter Spielernamen
    @Override
    public String getName() { 
        return _name;
    }

}
