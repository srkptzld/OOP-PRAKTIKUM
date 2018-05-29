package xorchiffre;

        
import java.io.File;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
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
    private long _key;

    /**
     * 
     */
    private ArrayList<byte[]> _text;

    /**
     * 
     */
    public ArrayList<String> _ergebnis;
    
    private File _file;


    /**
     * @param a 
     * @param b 
     * @param m 
     * @param key 
     * @param encryptedText
     */
    public Decryptor(int a, int b, int m, long key, ArrayList<byte[]> encryptedText, String savePath) {
        _a = a;
        _b = b;
        _m = m;
        _key = key;
        _text = encryptedText; 
        _ergebnis = new ArrayList<String>();
        _file = new File(savePath);
    }
    
     private String DecryptXOR(byte[] chiffreNumberArray, byte[] keyText)
    {
        String plainText = "";

        //Nun iterieren wir durch jeden Eintrag im Chiffre und dechiffrieren den verschlüsselten Buchstaben
        for (int i = 0; i <= chiffreNumberArray.length - 1; i++){
            System.out.println(i + " | " + chiffreNumberArray[i] + " XOR " + keyText[i] + " -> " + (chiffreNumberArray[i] ^ keyText[i]));
            chiffreNumberArray[i] ^= keyText[i];
        }
        
            plainText = new String(chiffreNumberArray, Charset.forName("Windows-1252"));      
        
        System.out.println("==========================");
        System.out.println(plainText);
        
        System.out.println("==========================");
        



        return plainText;
    }

    @Override
    public String convert() {
        byte[] seq;
        for (int i = 0; i <= _text.size() - 1; i++){
            seq = buildDecryptionKeySequence(_text.get(i).length);
            
           String decryptedLine = DecryptXOR(_text.get(i), seq);
           _ergebnis.add(decryptedLine);
        }
        return _ergebnis.toString();
    }

    /**
     * Builds the encryption key sequence
     * @param sequenceLength length of the sequence
     * @return Key sequence
     */
    private byte[] buildDecryptionKeySequence(int sequenceLength){
        byte[] sequence = new byte[sequenceLength];
        
        for (int i = 0; i<= sequenceLength - 1; i++){
            _key = (_a * _key + _b) % _m;
            byte[] bytes = ByteBuffer.allocate(8).putLong(_key).array();
            sequence[i] = (byte) Math.abs(bytes[bytes.length-1]);
        }     
        return sequence;
    }
    
    public ArrayList<String> getResult(){
        return _ergebnis;
    }    
    
    public File getFile(){
        return _file;
    }
    
}