package talerverteilung;

/**
 *
 * @author all
 */
public class Terminal {
    
    Eingabe in;
    Ausgabe out;
    Dispatcher disp;
    
    public Terminal(){

        Eingabe eingabe = new Eingabe();
        disp = in.run();

    }
    
}
