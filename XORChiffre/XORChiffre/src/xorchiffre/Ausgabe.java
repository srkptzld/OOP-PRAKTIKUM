package xorchiffre;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.FileWriter;

/**
 * 
 */
public class Ausgabe {

    /**
     * Default constructor
     */
    public Ausgabe() {
    }

    
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
     * 
     */

    /**
     *
     */
    public void run() {
        // TODO implement here
    }

}