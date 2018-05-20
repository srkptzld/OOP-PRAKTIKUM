package xorchiffre;

        
import java.io.File;
import java.util.*;

/**
 * 
 */
public class Decryptor implements IConverter {

    /**
     * Default constructor
     */
    public Decryptor() {
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
    private ArrayList<Byte> text;

    /**
     * 
     */
    public ArrayList<String> ergebnis;

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
    public void Create(Double a, Double b, Double m, int key, ArrayList<String> text) {
        // TODO implement here
    }
    
     private String DecryptXOREng(byte[] chiffreNumberArray, String keyText)
        {
            //Hier werden wir den entschlüsselten Text speichern
            String plainText;
 
            //Um die AdjustKeyLength()-Methode u benutzen müssen wir die Länge des Klartextes
            //aus der Länge des Chiffre-Array auslesen. Dazu erstellen wir ein string-Array
            //mit der Länge des Chiffre-Array.
            String[] cipher = new String[chiffreNumberArray.length];
 
            //Diese Methode benutzen wir um die Lägne des Schlüsseltextes
            //an die des Klartextes anzupassen.
            keyText = AdjustKeyLength(cipher.toString(), keyText);
 
            //Mit diesem Befehl zaubern wir aus dem Schlüsseltext ein array,
            //welches die Indizes der ASCII Zeichen aus dem Schlüsseltext enthält.
            byte[] binaryKeyText = keyText.getBytes();
 
            //Nun iterieren wir durch jeden Eintrag im Chiffre.
            for (int i = 0; i < chiffreNumberArray.length; i++)
            {
                //Mit dem Befehl '^' entschlüsseln wir jeden Eintrag im Chiffre,
                //mit dem entsprechenden Eintrag des Schlüsseltextes.
                chiffreNumberArray[i] ^= binaryKeyText[i];
 
            }
 
            //Hier wandeln wir jeden Eintrag im Chiffre-Array von Zahl nach ASCII Zeichen.
            plainText = Arrays.toString(chiffreNumberArray);
 
            //Unser Rückgabewert ist der entschlüsselte Klartext.
            return plainText;
        }

    /**
     * 
     */
    public void Convert() {
        // TODO implement here
    }

    @Override
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

}