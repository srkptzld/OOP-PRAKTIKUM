package xorchiffre;

import java.io.File;
import java.util.*;

/**
 * 
 */
public class Encryptor implements IConverter {

    /**
     * 
     */
    private Double _a;

    /**
     * 
     */
    private Double _b;

    /**
     * 
     */
    private Double _m;

    /**
     * 
     */
    private int _key;

    /**
     * 
     */
    private ArrayList<String> _text;

    /**
     * 
     */
    public ArrayList<Byte> _ergebnis;

    /**
     * 
     */
    private File _file;

    /**
     * @param a 
     * @param b 
     * @param m 
     * @param key 
     * @param text
     */
    public Encryptor(Double a, Double b, Double m, Integer key, ArrayList<String> text) {
        _a = a;
        _b = b;
        _m = m;
        _key = key;
        _text = text;        
    }

    // Verschlüsselt den plainText mit dem keyText
    private String EncryptString(String plainText, String keyText)
    {
        keyText = AdjustKeyLength(plainText,keyText);

        byte[] binaryPlainText = plainText.getBytes();

        byte[] binaryKeyText = keyText.getBytes();

        //Nun iterieren wir durch jedes Zeichen im Klartext und verschlüsseln den Klartextbuchstaben
        for(int i = 0;i<plainText.length();i++)
            binaryPlainText[i] ^=  binaryKeyText[i];

        return Arrays.toString(binaryPlainText);
    }
    
    public String AdjustKeyLength(String text,String keystring)
        {
            StringBuilder key = new StringBuilder(keystring);
 
            //Solange der Schlüsseltext kürzer als der Klartext ist, wird er erweiter.
            while(text.length() > key.length())
                key.append(keystring);
 
            //Gibt den angepassten Schlüsseltext zurück.
            return key.toString();
        }
    /**
     * 
     */
    public void Convert() {
        // TODO implement here
    }

}