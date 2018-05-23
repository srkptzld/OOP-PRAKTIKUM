package xorchiffre;

import java.io.File;
import java.util.*;

/**
 * 
 */
public class Encryptor implements IConverter {

    /**
     * Used to build the key sequence
     */
    private int _a;

    /**
     * Used to build the key sequence
     */
    private int _b;

    /**
     * Used to build the key sequence
     */
    private int _m;

    /**
     * encryption key
     */
    private int _key;

    /**
     * array containing the original text
     */
    private ArrayList<String> _text;

    /**
     * encrypted result
     */
    private ArrayList<byte[]> _result;

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
        _result = new ArrayList<>();
    }
    
    /**
     *  Verschlüsselt den plainText mit dem keySequence
     * @param plainText
     * @param keySequence
     */
    private byte[] EncryptString(String plainText, byte[] keySequence)
    {
        byte[] binaryPlainText = plainText.getBytes();

        //Nun iterieren wir durch jedes Zeichen im Klartext und verschlüsseln den Klartextbuchstaben
        for(int i = 0;i<plainText.length() - 1;i++)
            binaryPlainText[i] ^=  keySequence[i];

        return binaryPlainText;
    }

    /**
     * Builds the encryption key sequence
     * @param sequenceLength length of the sequence
     * @return Key sequence
     */
    private byte[] buildEncryptionKeySequence(int sequenceLength){
        byte[] sequence = new byte[sequenceLength];
        
        for (int i = 0; i<= sequenceLength - 1; i++){
            _key = (_a * _key + _b) % _m;
            sequence[i] = (byte)_key;
        }     
        return sequence;
    }
    

    @Override
    public String convert() {
        byte[] seq;
        for (int i = 0; i <= _text.size() - 1; i++){
            seq = buildEncryptionKeySequence(_text.get(i).length());
            
            byte[] bla = EncryptString(_text.get(i), seq);
            _result.add(bla);
        }
        return _result.toString();
    }

}