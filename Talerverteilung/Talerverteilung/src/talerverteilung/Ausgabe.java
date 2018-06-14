package talerverteilung;

import java.util.ArrayList;
/**
 *
 * @author all
 */
public class Ausgabe {
    
    public Ausgabe(){
        
    }  
    
    public void result(ArrayList<int[]> werte){
        
        for(int i = 0; i < werte.size(); i++){
            for(int k = 0; k < werte.get(i).length; k++){
                System.out.print(werte.get(i)[k]);
            }
            
        }
        
    }
}
