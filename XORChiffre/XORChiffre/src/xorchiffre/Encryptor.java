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
    private ArrayList<String> _text;

    /**
     * 
     */
    public ArrayList<byte[]> _ergebnis;

    /**
     * @param a 
     * @param b 
     * @param m 
     * @param key 
     * @param text
     */
    public Encryptor(int a, int b, int m, Integer key, ArrayList<String> text) {
        _a = a;
        _b = b;
        _m = m;
        _key = key;
        _text = text;       
        _ergebnis = new ArrayList<>();
    }

    // Verschlüsselt den plainText mit dem keySequence
    private byte[] EncryptString(String plainText, byte[] keySequence)
    {
        //keySequence = adjustKeyLength(plainText,keySequence);

        byte[] binaryPlainText = plainText.getBytes();

        //Nun iterieren wir durch jedes Zeichen im Klartext und verschlüsseln den Klartextbuchstaben
        for(int i = 0;i<plainText.length() - 1;i++)
            binaryPlainText[i] ^=  keySequence[i];

        return binaryPlainText;
    }

    
    private byte[] buildEncryptionKeySequence(int sequenceLength){
        byte[] sequence = new byte[sequenceLength];
        
        for (int i = 0; i<= sequenceLength - 1; i++){
            _key = (_a * _key + _b) % _m;
            sequence[i] = (byte)_key;
        }
        
        return sequence;
    }
    /**
     * 
     */
    @Override
    public void convert() {
        byte[] seq;
        for (int i = 0; i <= _text.size() - 1; i++){
            seq = buildEncryptionKeySequence(_text.get(i).length());
            
            byte[] bla = EncryptString(_text.get(i), seq);
            _ergebnis.add(bla);
        }
        
    }

}