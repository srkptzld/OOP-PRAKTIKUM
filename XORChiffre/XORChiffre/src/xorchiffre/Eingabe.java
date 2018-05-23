package xorchiffre;

import java.io.File;
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
        
        ArrayList<Integer> parameter = readABM();
        int a = parameter.get(0);
        int b = parameter.get(1);
        int m = parameter.get(2);
        
        Integer key = readKey();
        
        Boolean type = readType();
        
        ArrayList<String> text = new ArrayList<>();
        ArrayList<byte[]> bytes = new ArrayList<>();
        IConverter xorchiffre;
        if(type == false)
            xorchiffre = new Decryptor(a, b, m, key, bytes);
        else
            xorchiffre = new Encryptor( a, b, m, key, text);
                       
        String f = new File("texts/gedicht.txt").getAbsolutePath();
        return xorchiffre;        
    }

    /**
     * @return
     */
    private ArrayList<Integer> readABM() {
        
        ArrayList<Integer> parameter = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int reihenfolge = 0;
        
        System.out.println("Bitte geben Sie eine positive Ganzahl als Wert für den A-Parameter ein.");
        
        while(reihenfolge == 0){            
 
            String eingabe = scanner.nextLine();
        
            try{
                if(Integer.parseInt(eingabe) > 0){
                    parameter.add(Integer.parseInt(eingabe));
                    reihenfolge = 1;
                }else{
                    System.out.println("Die Eingabe ist fehlerhaft. Bitte versuchen sie erneut.");
                }
            }catch(NumberFormatException e){
                System.out.println("Die Eingabe ist fehlerhaft. Bitte versuchen sie erneut."); 
            }
        }
        
        System.out.println("Bitte geben Sie eine positive Ganzahl als Wert für den B-Parameter ein.");
        
        while(reihenfolge == 1){            
 
            String eingabe = scanner.nextLine();
        
            try{
                if(Integer.parseInt(eingabe) > 0){
                    parameter.add(Integer.parseInt(eingabe));
                    reihenfolge = 2;
                }else{
                    System.out.println("Die Eingabe ist fehlerhaft. Bitte versuchen sie erneut.");
                }
            }catch(NumberFormatException e){
                System.out.println("Die Eingabe ist fehlerhaft. Bitte versuchen sie erneut."); 
            }
        }
        
        System.out.println("Bitte geben Sie eine positive Ganzahl als Wert für den M-Parameter ein.");
        
        while(reihenfolge == 2){            
 
            String eingabe = scanner.nextLine();
        
            try{
                if(Integer.parseInt(eingabe) > 0){
                    parameter.add(Integer.parseInt(eingabe));
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

}