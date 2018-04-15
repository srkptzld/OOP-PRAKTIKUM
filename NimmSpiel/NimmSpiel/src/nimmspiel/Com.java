package nimmspiel;

/**
 *
 * @author sirkpetzold
 */
//Ableitung von Spieler, hat nur andere Zug-Methode
public class Com implements IPlayingMember {

    // Konstruktor
    public Com() {
    }

    //Gibt die Anzahl abzuziehender Steine an
    @Override
    public int Zug(int verbleibendeSteine) {  // Parameter notwendig, da sonst taktisches abziehen unmöglich
        int abzug = 0;  
        
        if (verbleibendeSteine <= 3)
            switch (verbleibendeSteine){
                case 1: return 1;
                case 2: return 1;
                case 3: return 2;
            }
            
        if (verbleibendeSteine % 2 == 0) 
            abzug = 2;
        else if (verbleibendeSteine >= 10) 
            abzug = 3;
        else
            abzug = 1;

        return abzug;
    }

    //returns the players name
    @Override
    public String getName() {
        return "COM";
    }
}
