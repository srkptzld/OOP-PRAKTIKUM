package xorchiffre;

import java.io.File;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
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
    private long _key;

    /**
     * array containing the original text
     */
    public ArrayList<String> _text;
    
        /**
     * array containing the original text
     */

    /**
     * encrypted result
     */
    private ArrayList<byte[]> _result;
    
    private File _file;

    /**
     * @param a 
     * @param b 
     * @param m 
     * @param key 
     * @param text
     */
    public Encryptor(int a, int b, int m, long key, ArrayList<String> text, String savePath) {
        _a = a;
        _b = b;
        _m = m;
        _key = key;
        _text = text;       
        _result = new ArrayList<>();
        _file = new File(savePath);
//            System.setProperty("file.encoding", "UTF-8");
    }
    
    /**
     *  Verschlüsselt den plainText mit dem keySequence
     * @param plainText
     * @param keySequence
     */
    private byte[] EncryptString(byte[] binaryPlainText, byte[] keySequence)
    {
        //Nun iterieren wir durch jedes Zeichen im Klartext und verschlüsseln den Klartextbuchstaben
        for(int i = 0;i <= binaryPlainText.length - 1;i++)
        {
            System.out.println(i + " | " + binaryPlainText[i] + " XOR " + keySequence[i] + " -> " + (binaryPlainText[i] ^ keySequence[i]));
            binaryPlainText[i] ^=  keySequence[i];
        }
        System.out.println("==========================");
        return binaryPlainText;
    }

    /**
     * Builds the encryption key sequence
     * @param sequenceLength length of the sequence
     * @return Key sequence
     */
    private byte[] buildEncryptionKeySequence(int sequenceLength){
        byte[] sequence = new byte[sequenceLength];
        
        for (int i = 0; i <= sequenceLength - 1; i++){
            _key = (_a * _key + _b) % _m;
            byte[] bytes = ByteBuffer.allocate(8).putLong(_key).array();
            sequence[i] = (byte) Math.abs(bytes[bytes.length-1]);
        }     
        return sequence;
    }
    

    @Override
    public String convert() {
        byte[] seq;
        for (int i = 0; i <= _text.size() - 1; i++){
            byte[] bytewurst = _text.get(i).getBytes(Charset.forName("Windows-1252"));
            seq = buildEncryptionKeySequence(_text.get(i).length());
            byte[] encrypted = EncryptString(bytewurst, seq);
            _result.add(encrypted);
        }
        return _result.toString();
    }
    
    public ArrayList<byte[]> getResult(){
        return _result;
    }    
    
    public File getFile(){
        return _file;
    }

}