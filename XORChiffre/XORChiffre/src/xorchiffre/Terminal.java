package xorchiffre;

import java.io.IOException;

/**
 * Die Klasse Terminal f�hrt das Programm und �bernimmt die Klasseninstanzen und Aufrufe
 * der Hauptmethoden.
 * 
 * @author funbold
 */
public class Terminal {
    
    private Eingabe eingabe;
    private Ausgabe ausgabe;
    private IConverter converter;

    /**
     * Default constructor
     */
    public Terminal() {
    }

    /**
     * F�hrt die Verschl�sselung/Entschl�sselung aus.
     */
    public void run() {
        
        eingabe = new Eingabe();
        ausgabe = new Ausgabe();
       
        IConverter converter = eingabe.Run();
     
        if(eingabe.getType() == true){
            Decryptor dec = (Decryptor)converter;
            dec.convert();
            ausgabe.saveDecrypted(dec);
        }else{
            Encryptor enc = (Encryptor)converter;
            enc.convert();
            ausgabe.saveEncrypted(enc);                    
        }
                
    }

}