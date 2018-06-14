package talerverteilung;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author funbold
 */
public class Eingabe {
    
    private ArrayList<Integer> werte;
    private int menge;
    
public Eingabe(){
    
}

public Dispatcher run(){
    
    werte = getWerte();
    menge = getMenge();
    
    Dispatcher disp = new Dispatcher(werte, menge);
    
    return disp;
}
    
private ArrayList<Integer> getWerte(){
    
    ArrayList<Integer> werte = new ArrayList<Integer>();
    ArrayList<Integer> einzelwerte = new ArrayList<Integer>();
    String eingabe;
    Scanner scan = new Scanner(System.in);
    boolean scanning = true;
    
    while(scanning){
    
        System.out.println("Bitte geben sie 'new' ein, um eine bestimmte Menge an neuen Talern hinzuzufuegen.");
        System.out.println("Wenn die Talermenge ihren Erwartungen entspricht, geben sie 'stop' ein");

        eingabe = scan.nextLine();
        
        if(eingabe.equals("new")){
            einzelwerte = getEinzelwerte();            
            for(int i = 0; i < einzelwerte.size(); i++){
                werte.add(einzelwerte.get(i));
            }           
        }else if(eingabe.equals("stop")){
            System.out.println("Taler-Grundmenge initialisiert.");
            scanning = false;
        }else{
            System.out.println("Die Eingabe war fehlerhaft. Versuchen sie es erneut.");
        }        
        
    }   
    return werte;   
}

private ArrayList<Integer> getEinzelwerte(){
    
    ArrayList<Integer> einzelwerte = new ArrayList<Integer>();
    int wert = 0;
    int menge = 0;
    boolean scanningWert = true;
    boolean scanningMenge = true;
    String eingabe;
    Scanner scan = new Scanner(System.in);
    
    while(scanningWert){
    
        System.out.println("Bitte geben sie einen Talerwert als Zahl ein.");

        eingabe = scan.nextLine();
        
        try{
            if(Integer.parseInt(eingabe) > 0){
                wert = Integer.parseInt(eingabe);
                scanningWert = false;
            }else{
               System.out.println("Die Eingabe war fehlerhaft. Versuchen sie es erneut."); 
            }
        }catch(NumberFormatException e){
            System.out.println("Die Eingabe war fehlerhaft. Versuchen sie es erneut.");
        }
        
    }   
    
    while(scanningMenge){
        
        System.out.println("Bitte geben sie einen Mengenwert als Zahl an.");

        eingabe = scan.nextLine();
        
        try{
            if(Integer.parseInt(eingabe) > 0){
                menge = Integer.parseInt(eingabe);
                scanningMenge = false;
            }else{
               System.out.println("Die Eingabe war fehlerhaft. Versuchen sie es erneut."); 
            }
        }catch(NumberFormatException e){
            System.out.println("Die Eingabe war fehlerhaft. Versuchen sie es erneut.");
        }
        
    }
    
    for(int i = 0; i < menge; i++){
        einzelwerte.add(wert);
    }
    
    return einzelwerte; 
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
    
}


