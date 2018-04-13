package nimmspiel;

import java.math.*;
import java.util.Random;

/**
 *
 * @author sirkpetzold
 */
//Ableitung von Spieler, hat nur andere Zug-Methode
public class Com implements IPlayingMember {

    private String _name;

    // Konstruktor
    public Com(String name) {
        _name = name;
    }

    //Gibt die Anzahl abzuziehender Steine an
    @Override
    public int Zug(int verbleibendeSteine) {  // Parameter notwendig, da sonst taktisches abziehen unmöglich
        int abzug;
        if (verbleibendeSteine % 2 == 0) 
            abzug = 2;
        else if (verbleibendeSteine >= 10) 
            abzug = 3;
        else 
            abzug = 1;
        

        //    if (verbleibendeSteine >= 10) {
        //        Random rndm = new Random();
        //        abzug = rndm.nextInt(3);
        //    } else {
        //        abzug = 3 - verbleibendeSteine % 2;
        //    }
        return abzug;
    }

    @Override
    public String getName() {
        return _name;
    }
}
