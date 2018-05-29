package xorchiffre;

import java.io.File;
import java.util.*;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    public IConverter Run() throws IOException {
        
       // ArrayList<Integer> parameter = readABM();
        int a = 421;//parameter.get(0);
        int b = 54773; //parameter.get(1);
        int m = 259200; //parameter.get(2);
        
        long key = 3; //readKey();
        
        Boolean type = false; //readType();
        
        ArrayList<String> text = new ArrayList<>();
        IConverter xorchiffre;
        if(type == true){
            ArrayList<byte[]> bytes = new ArrayList<>();
            xorchiffre = new Decryptor(a, b, m, key, bytes, "Daten.klartext.txt");
        }else{
            boolean found = false;
            Scanner scanner = new Scanner(System.in);
            
            System.out.println("Bitte geben Sie den Dateinamen ein.");
            while(!found){
                String eingabe = scanner.nextLine();               
                File file = new File("Daten/" + eingabe + ".txt");
                if(file.exists()){                   
                    text = readFileEnc(file);                    
                    found = true;
                }else{
                    System.out.println("Die Datei scheint nicht nicht vorhanden zu sein. Bitte versuchen Sie erneut.");
                }                
            }
            xorchiffre = new Encryptor( a, b, m, key, text, "Daten/geheimtext.txt");
       }               
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
    private long readKey() {
        
        long key = 0;
        boolean scanning = true;
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Bitte geben Sie eine positive Ganzzahl als Schlüssel ein.");        
        
        while(scanning){
            
            String eingabe = scanner.nextLine();
            
            try{
                if(Integer.parseInt(eingabe) > 0){
                    key = Integer.parseUnsignedInt(eingabe);
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
        
        System.out.println("Bitte geben Sie ein, ob sie 'decrypt' oder 'encrypt' möchten.");
           
        while(scanning){     
            
            String eingabe = scanner.nextLine();
            
            if(eingabe.equals("decrypt")){
                scanning = false;
            }else if(eingabe.equals("encrypt")){
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
    private ArrayList<String> readFileEnc(File file) throws IOException {
                
        ArrayList<String> text = new ArrayList<>();
        String textline = "";
        Boolean found = false;
        
        BufferedReader buf;
        while (!found){
            try{
                    FileInputStream fis = new FileInputStream(file);
                    InputStreamReader isr = new InputStreamReader(fis, "ISO-8859-1");
                    buf = new BufferedReader(isr);             

                while ((textline = buf.readLine()) != null)
                        text.add(textline);
       
                
                found = true;
            }catch(FileNotFoundException e){
                System.out.println("File wurde nicht gefunden.");
            }
        }
                
        return text;
    }
    
    private ArrayList<byte[]> readFileDec(File file) {
         
        ArrayList<byte[]> bytes = new ArrayList<>();
        byte[] byteX = new byte[]{};
        Boolean found = false;
        
        Scanner scanner;
        while (!found){
            try{
                
                scanner = new Scanner(new FileInputStream(file), "ISO-8859-1");

                while (scanner.hasNextLine())
                    {
                        byteX[byteX.length]=scanner.nextByte();
                    }        
                
                    bytes.add(byteX);
                scanner.close();
                found = true;
            }catch(FileNotFoundException e){
                System.out.println("File wurde nicht gefunden.");
            }
        }
        return bytes;
    }
    
    public String readSavePath(){
               
        String savePath = "";
        boolean scanning = true;
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Bitte geben Sie einen Namen für die abzuspeichernde Datei an.");        
        
        while(scanning){
            
            String eingabe = scanner.nextLine();
            
            if(eingabe != null){               
                savePath = eingabe;
                scanning = false;
            }else{
                System.out.println("Die Eingabe ist fehlerhaft. Bitte versuchen sie erneut.");
            }
        }
        
        return savePath;
        
    }

}