package rangieren;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * @author sirkpetzold
 */
public class Terminal {
    
    private ArrayList<Waggon> waggons;

    /**
     * 
     */
    public Terminal() {
        
        waggons = new ArrayList<>();
        
    }



    /**
     * @return
     */
    public ArrayList<Waggon> Wagenreihenfolge() {
        
        boolean scanning = true;
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Es wird nun die Waggon-Reihenfolge festgelegt.");
        System.out.println("Geben Sie Zahlen zwischen 1 und 99 ein und bestätigen Sie diese mit ENTER");
        System.out.println("Wenn Sie fertig sind, geben Sie 'fertig' ein und bestätigen Sie mit ENTER");
        System.out.println("Geben Sie 'zufall' ein, um das Gleis mit 110 zufällig nummerierten Waggons zu füllen.");
        
        while(scanning){
        
        String eingabe = scanner.nextLine();
        
            if(eingabe.equals("fertig")){           
                scanning = false;           
            }else if(eingabe.equals("zufall")){
                for(int i = 0; i < 10; i++){
                    waggons.add(new Waggon((int) (Math.random() * 99)));
                }
                scanning = false; 
            }else{
                try{
                    if(Integer.parseInt(eingabe) < 100 && Integer.parseInt(eingabe) > 0){
                    waggons.add(new Waggon(Integer.parseInt(eingabe)));
                    }else{
                        System.out.println("Die Eingabe scheint fehlerhaft zu sein. Bitte überprüfen Sie diese.");
                    }
                }catch(NumberFormatException e){
                System.out.println("Die Eingabe scheint fehlerhaft zu sein. Bitte überprüfen Sie diese.");
                }
            }
        }
        
        return waggons;
        
    }

}       