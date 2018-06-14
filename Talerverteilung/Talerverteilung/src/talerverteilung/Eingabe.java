package talerverteilung;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Eingabe nimmt alle Werte entgegen.
 * 
 * @author funbold
 */
public class Eingabe {
    
    private Menge menge;
    private int anz;
    
    /**
     * Konstruktor
     */
    public Eingabe(){
    
}

    /**
     * run() ist die Hauptfunktion der Eingabe und führt alle anderen Funktionen aus.
     * 
     * @return
     */
    public Dispatcher run(){
    
    menge = getWerte();
    anz = getMenge();
    System.out.println("----------------------------------------------");
    
    Dispatcher disp = new Dispatcher(menge, anz);
    
    return disp;
}
    
private Menge getWerte(){
    
    
    Menge menge = new Menge();
    String eingabe;
    Scanner scan = new Scanner(System.in);
    boolean scanning = true;
    
    while(scanning){
    
        System.out.println("Bitte geben sie 'new' ein, um eine bestimmte Menge an neuen Talern hinzuzufuegen.");
        System.out.println("Oder geben sie 1,..,4 für Beispiel 1-4 ein.");
        

        eingabe = scan.nextLine();
        
        switch (eingabe) {
            case "1":
                return getExample1();
            case "2":
                return getExample2();
            case "3":
                return getExample3();
            case "4":
                return getExample4();
            case "new":
                menge.addList(getEinzelwerte());
                break;
            default:
                System.out.println("Die Eingabe war fehlerhaft. Versuchen sie es erneut.");
        }
                
        
    }   
    return menge;   
}

private ArrayList<Integer> getEinzelwerte(){
    ArrayList<Integer> values = new ArrayList<>();
    Scanner s = new Scanner(System.in);
    boolean scanning = true;
    String eingabe = "";
    int wert = 0;
    
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
                    wert = Integer.parseInt(eingabe); 
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


private Menge getExample1() {
    Menge menge = new Menge();
    
    menge.addTaler(1, 5);
    menge.addTaler(3, 3);
    menge.addTaler(5, 2);

    return menge;
}
    

private Menge getExample2() {
    Menge menge = new Menge();
    
    menge.addTaler(1, 1);
    menge.addTaler(3, 3);
    menge.addTaler(10, 2);

    return menge;
}
    

private Menge getExample3() {
    Menge menge = new Menge();
    
    menge.addTaler(1);
    menge.addTaler(2, 3);
    menge.addTaler(3, 3);
    menge.addTaler(4, 5);
    menge.addTaler(5, 5);
    menge.addTaler(6);
    menge.addTaler(7, 3);
    menge.addTaler(8);
    menge.addTaler(9, 2);
    menge.addTaler(10, 3);

    return menge;
}

private Menge getExample4() {
    Menge menge = new Menge();
    
    menge.addTaler(3, 10);
    menge.addTaler(7, 2);
    menge.addTaler(10, 10);

    return menge;
}
    
}


