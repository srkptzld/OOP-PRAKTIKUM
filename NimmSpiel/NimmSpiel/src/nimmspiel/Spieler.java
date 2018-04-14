package nimmspiel;


import java.util.Scanner;
/**
 *
 * @author funbold
 */
public class Spieler implements IPlayingMember {

    @Override
    public int Zug(int verbleibendeSteine) {
        
    	int abzug;
    	
    	System.out.println("Wieviele Steine möchtest du nehmen?");
    	Scanner scanner = new Scanner(System.in);
        abzug = scanner.nextLine();
        
        return abzug;
    	
    }

    @Override
    public String getName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
