package talerverteilung;

import java.util.ArrayList;
/**
 *
 * @author funbold
 */
public class Ausgabe {
    
    /**
     * Konstruktor
     */
    public Ausgabe(){
        
    }  
    
    /**
     * Gibt das Ergebnis aus.
     *
     * @param werte
     */
    public void print(ArrayList<NumSet> werte, boolean isDispatchable){
        if (isDispatchable)
         for (int i = 0; i < werte.size(); i++) 
            System.out.println((i+1) + ": " + werte.get(i).getMenge().toString()); 
        else
            System.out.println("Keine Lösung möglich!");
    }
}
