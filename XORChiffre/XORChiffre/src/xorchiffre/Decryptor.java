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
            String plainText;
            String[] cipher = new String[chiffreNumberArray.length];

            keyText = AdjustKeyLength(Arrays.toString(cipher), keyText);

            byte[] binaryKeyText = keyText.getBytes();

            //Nun iterieren wir durch jeden Eintrag im Chiffre und dechiffrieren den verschlüsselten Buchstaben
            for (int i = 0; i < chiffreNumberArray.length; i++)
                chiffreNumberArray[i] ^= binaryKeyText[i];

            plainText = Arrays.toString(chiffreNumberArray);

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