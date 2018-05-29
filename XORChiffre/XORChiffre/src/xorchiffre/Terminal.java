package xorchiffre;

import java.io.IOException;
import java.util.*;

/**
 * 
 */
public class Terminal {
    
    /**
     * 
     */
    private Eingabe eingabe;
    private Ausgabe ausgabe;
    private IConverter converter;

    /**
     * Default constructor
     */
    public Terminal() {
    }

    /**
     * 
     */
    public void run() throws IOException {
        
        Eingabe eingabe = new Eingabe();
        IConverter test = eingabe.Run();
        Encryptor enc = (Encryptor)test;
        enc.convert();
        System.out.println(enc.getResult());
        System.out.println();
        
        Ausgabe ausgabe = new Ausgabe();
        ausgabe.saveEncrypted(enc);
        
        Decryptor dec = new Decryptor(421, 54773, 259200, 3, enc.getResult(), "Daten/klartext.txt");
        dec.convert();
        System.out.println(dec._ergebnis);
        
        ausgabe.saveDecrypted(dec);
                
    }

}