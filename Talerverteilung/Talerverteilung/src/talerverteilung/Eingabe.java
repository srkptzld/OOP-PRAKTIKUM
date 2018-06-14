package talerverteilung;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Eingabe nimmt alle Werte entgegen.
 * 
 * @author funbold
 */
public class Eingabe {
    
    private NumSet _set;
    private int anz;
    
    /**
     * Konstruktor
     */
    public Eingabe(){
        _set = new NumSet();
    
    }

    /**
     * run() ist die Hauptfunktion der Eingabe und führt alle anderen Funktionen aus.
     * 
     * @return
     */
    public Dispatcher run(){
    
    getWerte();
    anz = getMenge();
    System.out.println("----------------------------------------------");
    
    Dispatcher disp = new Dispatcher(_set, anz);
    
    return disp;
}
    
private void getWerte(){
    
    String eingabe;
    Scanner scan = new Scanner(System.in);
    boolean scanning = true;
    
    while(scanning){
    
        System.out.println("Bitte geben sie 'new' ein, um eine bestimmte Menge an neuen Talern hinzufuegen.");
        System.out.println("Oder geben sie 1,..,5 für Beispiel 1-5 ein.");
        

        eingabe = scan.nextLine();
        
        switch (eingabe) {
            case "1":
                _set = getExample1();
                return;
            case "2":
                _set = getExample2();
                return;
            case "3":
                _set = getExample3();
                return;
            case "4":
                _set = getExample4();
                return;
            case "5":
                _set = getExample5();
                return;
            case "new":
                _set.addCoinList(getEinzelwerte());
                return;
            default:
                System.out.println("Die Eingabe war fehlerhaft. Versuchen sie es erneut.");
        }
    }   
}

private ArrayList<Integer> getEinzelwerte(){
    ArrayList<Integer> values = new ArrayList<>();
    Scanner s = new Scanner(System.in);
    boolean scanning = true;
    String eingabe = "";
    
    System.out.println("Bitte geben Sie einen Talerwert ein und bestätigen Sie mit <Enter>");
    System.out.println("Wenn die Talermenge ihren Erwartungen entspricht, geben sie 'stop' ein");
    while(scanning){    
         
        eingabe = s.nextLine(); 
        
        if(eingabe.equals("stop")){
            System.out.println("Taler-Grundmenge initialisiert.");
            scanning = false;
        }
        if (scanning)
            try{ 
                if(Integer.parseInt(eingabe) > 0) 
                    values.add(Integer.parseInt(eingabe)); 
                else 
                   System.out.println("Die Eingabe war fehlerhaft. Versuchen sie es erneut.");  

            }catch(NumberFormatException e){ 
                System.out.println("Die Eingabe war fehlerhaft. Versuchen sie es erneut."); 
            } 
    }
    
    return values;
}

private int getMenge(){
    
    int menge = 0;
    boolean scanning = true;
    String eingabe;
    Scanner scan = new Scanner(System.in);
    
    while(scanning){
    
        System.out.println("Bitte geben sie die Anzahl der Mengen ein, auf die sie teilen möchten.");

        eingabe = scan.nextLine();
        
        try{
            if(Integer.parseInt(eingabe) > 0){
                menge = Integer.parseInt(eingabe);
                scanning = false;
            }else{
               System.out.println("Die Eingabe war fehlerhaft. Versuchen sie es erneut."); 
            }
        }catch(NumberFormatException e){
            System.out.println("Die Eingabe war fehlerhaft. Versuchen sie es erneut.");
        }
        
    }    
    return menge;
}


private NumSet getExample1() {
    NumSet menge = new NumSet();
    
    menge.addCoin(1, 5);
    menge.addCoin(3, 3);
    menge.addCoin(5, 2);

    return menge;
}
    

private NumSet getExample2() {
    NumSet menge = new NumSet();
    
    menge.addCoin(1, 1);
    menge.addCoin(3, 3);
    menge.addCoin(10, 2);

    return menge;
}
    

private NumSet getExample3() {
    NumSet menge = new NumSet();
    
    menge.addCoin(1);
    menge.addCoin(2, 3);
    menge.addCoin(3, 3);
    menge.addCoin(4, 5);
    menge.addCoin(5, 5);
    menge.addCoin(6);
    menge.addCoin(7, 3);
    menge.addCoin(8);
    menge.addCoin(9, 2);
    menge.addCoin(10, 3);

    return menge;
}

private NumSet getExample4() {
    NumSet menge = new NumSet();
    
    menge.addCoin(1);
    menge.addCoin(2, 3);
    menge.addCoin(3, 5);
    menge.addCoin(4, 5);
    menge.addCoin(5, 5);
    menge.addCoin(7, 3);
    menge.addCoin(8);
    menge.addCoin(9, 2);
    menge.addCoin(10, 3);

    return menge;
}

private NumSet getExample5() {
    NumSet menge = new NumSet();
    
    menge.addCoin(3, 10);
    menge.addCoin(7, 2);
    menge.addCoin(10, 10);

    return menge;
}
    
}


