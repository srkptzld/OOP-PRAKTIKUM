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
    public void print(ArrayList<Menge> werte){
        
         for (int i = 0; i < werte.size(); i++) {
            System.out.println((i+1) + ": " + werte.get(i).getMenge().toString());
        }
        
//        for(int i = 0; i < werte.size(); i++){
//            for(int k = 0; k < werte.get(i).length; k++){
//                System.out.print(werte.get(i)[k]);
//            }
//            
//        }
        
    }
}
