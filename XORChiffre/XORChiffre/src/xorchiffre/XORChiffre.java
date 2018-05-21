package xorchiffre;

import java.util.ArrayList;

/**
 *
 * @author sirkpetzold
 */
public class XORChiffre {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        ArrayList<String> test = new ArrayList<>();
        test.add("Hallo ich bin Sirk");
        test.add("Hallo ich bin Sirk");
        Encryptor enc = new Encryptor(421, 54773, 259200, 3, test);
        enc.convert();
        System.out.println(enc._ergebnis);
        
        Decryptor dec = new Decryptor(421, 54773, 259200, 3, enc._ergebnis);
        dec.convert();
        System.out.println(String.valueOf(dec._ergebnis));
    }
    
}
