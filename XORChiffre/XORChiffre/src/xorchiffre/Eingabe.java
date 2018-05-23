package xorchiffre;

import java.io.File;
import java.io.FileReader;
import java.util.*;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import static javafx.application.Platform.exit;

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
        
        IConverter xorchiffre;
        if(type == true){
            ArrayList<byte[]> bytes = new ArrayList<byte[]>();
            xorchiffre = new Decryptor(a, b, m, key, bytes);
        }else{
            ArrayList<String> text = new ArrayList<String>();
            text = readFileEnc("Gedicht");
            xorchiffre = new Encryptor( a, b, m, key, text);
        }               
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
    private ArrayList<String> readFileEnc(String filename) {
               
        File file = new File("Daten/" + filename + ".txt");  
        ArrayList<String> text = new ArrayList<>();
        String textline;
        Boolean found = false;
        if(!file.exists())
            exit();
        Scanner scanner;
        while (found = false)
        try{
         scanner = new Scanner(file);
         found = true;
            }
        catch(FileNotFoundException e){
            System.out.println("File wurde nicht gefunden.");
        }
        
        while (scanner.hasNextLine())
        {
            textline = scanner.next();
            text.add(textline);
        }        
        scanner.close();        
        }        
        return text;
    }
    
    private ArrayList<byte[]> readFileDec(String filename) {
        
        File file = new File("../Daten/" + filename + ".txt");  
        ArrayList<byte[]> bytes = new ArrayList<byte[]>();
        if(!file.exists())
            exit();
        else{
        Scanner scanner = new Scanner(file.getAbsolutePath());
               
        while (scanner.hasNext())
        {           
            bytes.add(scanner.nextLine().getBytes());
        }        
        scanner.close();        
        }        
        return bytes;
    }

}