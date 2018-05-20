package rangieren;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Die Klasse Terminal legt zu Beginn des Programms fest, welche Waggons und in 
 * welcher Reihenfolge diese auf dem Abstellgleis stehen. Dafür kann man entweder
 * einzelne Waggonnummern eingeben oder 110 zufällige Waggons generieren lassen.
 * 
 * @author funbold
 */
public class Terminal {
    
    private ArrayList<Waggon> waggons;

    /**
     * Konstruktor
     */
    public Terminal() {
        
        waggons = new ArrayList<>();
        
    }

    /**
     * Lässt den Benutzer mittels Eingabe entweder einzelne, selbstgewählte Waggonnummern einspeisen
     * oder eine gewählte Menge zufälliger Waggonnummern generieren.
     * Die beiden Möglichkeiten können kombiniert werden.
     * 
     * @return waggons
     */
    public ArrayList<Waggon> Wagenreihenfolge() {
        
        boolean scanning = true;
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Es wird nun die Waggon-Reihenfolge festgelegt.");
        System.out.println("Geben Sie Zahlen zwischen 1 und 99 ein und bestätigen Sie diese mit ENTER");
        System.out.println("Geben Sie 'zufall' ein, um das Gleis mit 10-200 zufällig nummerierten Waggons zu füllen.");
        System.out.println("Wenn Sie fertig sind, geben Sie 'fertig' ein und bestätigen Sie mit ENTER");        
        
        while(scanning){
        
        String eingabe = scanner.nextLine();
        
            if(eingabe.equals("fertig")){           
                scanning = false;           
            }else if(eingabe.equals("zufall")){
                System.out.println("Bitte geben Sie nun die Anzahl an zufälligen Waggons zwischen 10 und 200 ein.");
                String anzahl = scanner.nextLine();
                try{
                    if(Integer.parseInt(anzahl) <= 201 && Integer.parseInt(anzahl) >= 10){
                        for(int i = 0; i < Integer.parseInt(anzahl); i++){
                        waggons.add(new Waggon((int) (Math.random() * 99)));
                        }
                    }else{
                        System.out.println("Die Eingabe scheint fehlerhaft zu sein.");
                        System.out.println("Bitte geben sie für einen nächsten Versuch erneut Zufall ein.");
                    }
                }catch(NumberFormatException e){
                    System.out.println("Die Eingabe scheint fehlerhaft zu sein.");
                    System.out.println("Bitte geben sie für einen nächsten Versuch erneut Zufall ein.");
                }
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