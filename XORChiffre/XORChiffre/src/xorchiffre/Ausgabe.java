package xorchiffre;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;
import java.io.FileWriter;

/**
 * Die Klasse Ausgabe speichert die output-Datei des IConverters.
 * 
 * @author funbold
 */
public class Ausgabe {

    /**
     * Default constructor
     */
    public Ausgabe() {
    }

    /**
     * Speichert die Chiffre.
     * 
     * @param enc
     */
    public void saveEncrypted(Encryptor enc){
        
        FileOutputStream fop = null;
        ArrayList<byte[]> encrypted = enc.getResult();            
        try { 
            File f = enc.getFile();
              
            fop = new FileOutputStream(f);       
            boolean b;
            if (!f.exists())
                b = f.createNewFile();
            
            for (int i = 0; i <= encrypted.size() - 1; i++) {
               fop.write(encrypted.get(i));
            }
            fop.flush();
            fop.close();

        } catch (IOException e) {
                        e.printStackTrace();
        } finally {
                try {
                        if (fop != null) {
                                fop.close();
                        }
                } catch (IOException e) {
                        e.printStackTrace();
                }
        
        }
    }
    
    /**
     * Speichert das Dechiffrierte.
     *
     * @param dec
     */
    public void saveDecrypted(Decryptor dec){
        
        FileWriter fop = null;
        ArrayList<String> decrypted = dec.getResult();            
        try { 
            File f = dec.getFile();
              
            fop = new FileWriter(f);       
            boolean b;
            if (!f.exists())
                b = f.createNewFile();
            
            for (int i = 0; i <= decrypted.size() - 1; i++) {
               fop.write(decrypted.get(i));
               fop.write("\r\n");
            }     
            fop.flush();
            fop.close();

        } catch (IOException e) {
                        e.printStackTrace();
        } finally {
                try {
                        if (fop != null) {
                                fop.close();
                        }
                } catch (IOException e) {
                        e.printStackTrace();
                }
        
        }
        
    }

}