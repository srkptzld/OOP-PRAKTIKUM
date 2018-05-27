package xorchiffre;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        
        ByteArrayOutputStream fop = null;
        ArrayList<byte[]> encrypted = enc.getResult();            
        try { 
            File f = enc.getFile();
              
            fop = new ByteArrayOutputStream(enc.getResult().size());       
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
     * 
     */

    /**
     *
     */
    public void run() {
        // TODO implement here
    }

}