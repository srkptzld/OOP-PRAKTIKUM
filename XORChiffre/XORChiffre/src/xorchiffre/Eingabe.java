package xorchiffre;

import java.io.File;
import java.util.*;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

/**
 * Die Klasse Eingabe nimmt alle Eingaben entgegen, die die Ver- oder
 * Entschlüsselung betreffen. Außerdem liest sie die betreffende Datei.
 * 
 * @author funbold
 */
public class Eingabe  {
    
    private boolean type;

    /**
     * Default constructor
     */
    public Eingabe() {
    }


    /**
     * Ruft alle Methoden der Eingabe auf und initialisiert den IConverter.
     * 
     * @return IConverter
     */
    public IConverter Run() {
        
        ArrayList<Integer> parameter = readABM();
        int a = parameter.get(0);
        int b = parameter.get(1);
        int m = parameter.get(2);
        
        long key = readKey();
        
        type = readType();
        
        String path = readSavePath();
        
        IConverter xorchiffre;
        if(type == true){
            
            ArrayList<byte[]> bytes = new ArrayList<>();
            boolean found = false;
            Scanner scanner = new Scanner(System.in);
            
            System.out.println("Bitte geben Sie den Dateinamen der zu verarbeitenden Datei ein.");
            while(!found){
                String eingabe = scanner.nextLine();               
                File file = new File("Daten/" + eingabe + ".txt");
                if(file.exists()){                   
                    bytes = readFileDec(file);                    
                    found = true;
                }else{
                    System.out.println("Die Datei scheint nicht nicht vorhanden zu sein. Bitte versuchen Sie erneut.");
                }                
            }
            xorchiffre = new Decryptor(a, b, m, key, bytes, "Daten/" + path + ".txt");

        }else{
            
            ArrayList<String> text = new ArrayList<>();
            boolean found = false;
            Scanner scanner = new Scanner(System.in);
            
            System.out.println("Bitte geben Sie den Dateinamen der zu verarbeitenden Datei ein.");
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
            xorchiffre = new Encryptor( a, b, m, key, text, "Daten/" + path + ".txt");
       }               
        return xorchiffre;        
    }
    
    private int getParameterValue()
    {
        int value = 0;
        boolean done = false;
        Scanner scanner = new Scanner(System.in);
           while(!done){            
 
            String eingabe = scanner.nextLine();
        
            try{
                if(Integer.parseInt(eingabe) > 0){
                    value = Integer.parseInt(eingabe);
                    done = true;
                }else{
                    System.out.println("Die Eingabe ist fehlerhaft. Bitte versuchen sie erneut.");
                }
            }catch(NumberFormatException e){
                System.out.println("Die Eingabe ist fehlerhaft. Bitte versuchen sie erneut."); 
            }
        }
        return value;
    }

    /**
     * Liest die Parameter der Ver- / Entschlüsselung ein.
     * 
     * @return ArrayList<Integer>
     */
    private ArrayList<Integer> readABM() {
        
        ArrayList<Integer> parameter = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int reihenfolge = 0;
        
        System.out.println("Bitte geben Sie eine positive Ganzahl als Wert für den A-Parameter ein.");
        
        parameter.add(getParameterValue());
        
        System.out.println("Bitte geben Sie eine positive Ganzahl als Wert für den B-Parameter ein.");
        
        parameter.add(getParameterValue());
        System.out.println("Bitte geben Sie eine positive Ganzahl als Wert für den M-Parameter ein.");
        
        parameter.add(getParameterValue());
        
        return parameter;
    }

    /**
     * Liest den Schlüssel ein.
     * 
     * @return long
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
     * Liest den Typ (Ver- / Entschlüsselung) ein.
     * 
     * @return Boolean
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
     * Liest die Datei zum verschlüsseln ein.
     * 
     * @param file
     * @return ArrayList<String>
     */
    private ArrayList<String> readFileEnc(File file) {
                
        ArrayList<String> text = new ArrayList<>();
        String textline = "";
        Boolean found = false;
        String lineFeed = System.getProperty("line.separator");
        BufferedReader buf;
        while (!found){
            try{
                    FileInputStream fis = new FileInputStream(file);
                    Charset set = Charset.forName("Windows-1252");
                    InputStreamReader isr = new InputStreamReader(fis, set);
                    buf = new BufferedReader(isr);             

                while ((textline = buf.readLine()) != null)
                        text.add(textline + lineFeed);
       
                
                found = true;
            }catch(FileNotFoundException e){
                System.out.println("File wurde nicht gefunden.");
            }catch(IOException e){
                System.out.println("Unerwarteter Fehler. Bitte starten Sie das Programm erneut.");
            }
        }
                
        return text;
    }
    
    /**
     * Liest die Datei zum entschlüsseln ein.
     * 
     * @param file
     * @return ArrayList<byte[]>
     */
    private ArrayList<byte[]> readFileDec(File file) {
         
        ArrayList<byte[]> bytes = new ArrayList<>();
        byte[] byteX = new byte[]{};
        Boolean found = false;
        
        byte[] data = new byte[(int) file.length()];
        try (DataInputStream dis = new DataInputStream(new FileInputStream(file))) {
            dis.readFully(data);
        } catch (IOException ex) {
                System.out.println("Datei konnte nicht eingelesen werden!");
            
        }
        bytes.add(data);
        return bytes;
    }
    
    /**
     * List den Namen der abzuspeichernden Datein ein.
     *
     * @return String
     */
    private String readSavePath(){
               
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
    
    /**
     * Getter für type (Für das Terminal)
     *
     * @return Boolean
     */
    public boolean getType(){
        return type;
    }

}