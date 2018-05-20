package xorchiffre;

import java.io.File;
import java.util.*;

/**
 * 
 */
public class Encryptor implements IConverter {

    /**
     * Default constructor
     */
    public Encryptor() {
    }

    /**
     * 
     */
    private Double a;

    /**
     * 
     */
    private Double b;

    /**
     * 
     */
    private Double m;

    /**
     * 
     */
    private int key;

    /**
     * 
     */
    private ArrayList<String> text;

    /**
     * 
     */
    public ArrayList<Byte> ergebnis;

    /**
     * 
     */
    private File file;

    /**
     * @param a 
     * @param b 
     * @param m 
     * @param key 
     * @param text
     */
    public void Create(Double a, Double b, Double m, Integer key, ArrayList<String> text) {
        // TODO implement here
    }

    
    private String EncryptString(String plainText, String keyText)
    {
             //Diese Methode benutzen wir um die Lägne des Schlüsseltextes
            //an die des Klartextes anzupassen.
            keyText = AdjustKeyLength(plainText,keyText);
 
            //Mit diesem Befehl zaubern wir aus dem Klartext ein array,
            //welches die Indizes der ASCII Zeichen aus dem Klartext enthält.
            byte[] binaryPlainText = plainText.getBytes();
 
            //Mit diesem Befehl zaubern wir aus dem Schlüsseltext ein array,
            //welches die Indizes der ASCII Zeichen aus dem Schlüsseltext enthält.
            byte[] binaryKeyText = keyText.getBytes();
 
            //Nun iterieren wir durch jedes Zeichen im Klartext.
            for(int i = 0;i<plainText.length();i++)
            {
                // Mit dem Befehl '^' verschlüsseln wir jeden Buchstaben im KlarText,
                //mit dem entsprechenden Buchstaben des Schlüsseltextes
                binaryPlainText[i] ^=  binaryKeyText[i];
            }
 
            //Der Rückgabewert ist ein überschriebenes byte-array welches die Verschlüsselung
            //als Folge ganzer Zahlen enthält.
            return Arrays.toString(binaryPlainText);
    }
    
    public String AdjustKeyLength(String text,String keystring)
        {
            StringBuilder key = new StringBuilder(keystring);
 
            //Solange der Schlüsseltext kürzer als der Klartext ist, wird er erweiter.
            while(text.length() > key.length())
            {
                key.append(keystring);
            }
 
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