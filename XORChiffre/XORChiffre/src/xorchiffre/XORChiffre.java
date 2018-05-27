package xorchiffre;

import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author sirkpetzold
 */
public class XORChiffre {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        
        Eingabe eingabe = new Eingabe();
        IConverter test = eingabe.Run();
        Encryptor enc = (Encryptor)test;
        enc.convert();
        System.out.println(enc._result);
        System.out.println();
        
        Decryptor dec = new Decryptor(421, 54773, 259200, 3, enc._result);
        dec.convert();
        System.out.println(dec._ergebnis);
        
       
    }
    
}
