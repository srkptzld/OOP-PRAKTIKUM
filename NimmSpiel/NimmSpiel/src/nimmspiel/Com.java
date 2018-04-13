/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nimmspiel;

import java.math.*;
import java.util.Random;

/**
 *
 * @author sirkpetzold
 */

//Ableitung von Spieler, hat nur andere Zug-Methode
public class Com implements IPlayingMember{
   
    private String _name;
    
    public Com(String name){
        _name = name;
    }
    
    //Gibt die Anzahl abzuziehender Steine an
    public int Zug(int verbleibendeSteine){  // Paramter notwendig, da sonst taktisches abziehen unmöglich
        int abzug;
        if (verbleibendeSteine >= 10){
            Random rndm = new Random();
            abzug = rndm.nextInt(3);
        }else{
            abzug = 3 - verbleibendeSteine % 2;
        }
        
        return abzug;
    }

    @Override
    public String getName() {
        return _name;
    }
}