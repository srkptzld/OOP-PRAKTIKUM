package xorchiffre;

import java.util.*;

/**
 * 
 */
public class Eingabe  {

    /**
     * Default constructor
     */
    public Eingabe() {
    }


    /**
     * @return
     */
    public IConverter Run() {
        
        ArrayList<Double> parameter = readABM();
        Double _a = parameter.get(0);
        Double _b = parameter.get(1);
        Double _m = parameter.get(2);
        
        Integer _key = readKey();
        
        Boolean _type = readType();
        
        
        
        
       
    }

    /**
     * @return
     */
    private ArrayList<Double> readABM() {
        
        ArrayList<Double> parameter = new ArrayList<Double>();
        Scanner scanner = new Scanner(System.in);
        int reihenfolge = 0;
        
        System.out.println("Bitte geben Sie eine positive Fließkommazahl als Wert für den A-Parameter ein.");
        
        while(reihenfolge == 0){            
 
            String eingabe = scanner.nextLine();
        
            try{
                if(Double.parseDouble(eingabe) > 0){
                    parameter.add(Double.parseDouble(eingabe));
                    reihenfolge = 1;
                }else{
                    System.out.println("Die Eingabe ist fehlerhaft. Bitte versuchen sie erneut.");
                }
            }catch(NumberFormatException e){
                System.out.println("Die Eingabe ist fehlerhaft. Bitte versuchen sie erneut."); 
            }
        }
        
        System.out.println("Bitte geben Sie eine positive Fließkommazahl als Wert für den B-Parameter ein.");
        
        while(reihenfolge == 1){            
 
            String eingabe = scanner.nextLine();
        
            try{
                if(Double.parseDouble(eingabe) > 0){
                    parameter.add(Double.parseDouble(eingabe));
                    reihenfolge = 2;
                }else{
                    System.out.println("Die Eingabe ist fehlerhaft. Bitte versuchen sie erneut.");
                }
            }catch(NumberFormatException e){
                System.out.println("Die Eingabe ist fehlerhaft. Bitte versuchen sie erneut."); 
            }
        }
        
        System.out.println("Bitte geben Sie eine positive Fließkommazahl als Wert für den M-Parameter ein.");
        
        while(reihenfolge == 2){            
 
            String eingabe = scanner.nextLine();
        
            try{
                if(Double.parseDouble(eingabe) > 0){
                    parameter.add(Double.parseDouble(eingabe));
                    reihenfolge = 3;
                }else{
                    System.out.println("Die Eingabe ist fehlerhaft. Bitte versuchen sie erneut.");
                }
            }catch(NumberFormatException e){
                System.out.println("Die Eingabe ist fehlerhaft. Bitte versuchen sie erneut."); 
            }
        }                
        return parameter;
    }

    /**
     * @return
     */
    private Integer readKey() {
        
        int key = 0;
        boolean scanning = true;
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Bitte geben Sie eine positive Ganzzahl als Schlüssel ein.");
        
        String eingabe = scanner.nextLine();
        
        while(scanning){
            try{
                if(Integer.parseInt(eingabe) > 0){
                    key = Integer.parseInt(eingabe);
                    scanning = false;
                }else{
                    System.out.println("Die Eingabe ist fehlerhaft. Bitte versuchen sie erneut.");
                }
            }catch(NumberFormatException e){
                System.out.println("Die Eingabe ist fehlerhaft. Bitte versuchen sie erneut.");
            }
        }
        
        return key;
    }

    /**
     * @return
     */
    private Boolean readType() {
        
        Boolean type = true;
        boolean scanning = true;
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Bitte geben Sie ein, ob sie 'entschlüsseln' oder 'verschlüsseln' möchten.");
        
        String eingabe = scanner.nextLine();
        
        while(scanning){     
            if(eingabe.equals("entschlüsseln")){
                scanning = false;
            }else if(eingabe.equals("verschlüsseln")){
                type = false;
                scanning = false;
            }else{
                System.out.println("Die Eingabe ist fehlerhaft. Bitte versuchen sie erneut.");
            }
        }
        return type;
    }

    /**
     * @return
     */
    private String readFileName() {
        // TODO implement here
        return null;
    }

    /**
     * 
     */
    public void Convert() {
        // TODO implement here
    }

}