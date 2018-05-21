package xorchiffre;

        
import java.io.File;
import java.util.*;

/**
 * 
 */
public class Decryptor implements IConverter {
    /**
     * 
     */
    private int _a;

    /**
     * 
     */
    private int _b;

    /**
     * 
     */
    private int _m;

    /**
     * 
     */
    private int _key;

    /**
     * 
     */
    private ArrayList<byte[]> _text;

    /**
     * 
     */
    public ArrayList<String> _ergebnis;


    /**
     * @param a 
     * @param b 
     * @param m 
     * @param key 
     * @param encryptedText
     */
    public Decryptor(int a, int b, int m, int key, ArrayList<byte[]> encryptedText) {
        _a = a;
        _b = b;
        _m = m;
        _key = key;
        _text = encryptedText; 
        _ergebnis = new ArrayList<>();
    }
    
     private String DecryptXOREng(byte[] chiffreNumberArray, byte[] keyText)
    {
        String plainText = "";

        //Nun iterieren wir durch jeden Eintrag im Chiffre und dechiffrieren den verschlüsselten Buchstaben
        for (int i = 0; i < chiffreNumberArray.length - 1; i++)
            chiffreNumberArray[i] ^= keyText[i];

        for (int i = 0; i <= chiffreNumberArray.length - 1; i++)
        {
            plainText += String.valueOf((char)chiffreNumberArray[i]);
        }

        return plainText;
    }

    /**
     * 
     */
    @Override
    public void convert() {
        byte[] seq;
        for (int i = 0; i <= _text.size() - 1; i++){
            seq = buildDecryptionKeySequence(_text.get(i).length);
            
           String bla = DecryptXOREng(_text.get(i), seq);
           _ergebnis.add(bla);
        }
    }

    private byte[] buildDecryptionKeySequence(int sequenceLength){
        byte[] sequence = new byte[sequenceLength];
        
        for (int i = 0; i<= sequenceLength - 1; i++){
            _key = (_a * _key + _b) % _m;
            sequence[i] = (byte)_key;
        }
        
        return sequence;
    }

}