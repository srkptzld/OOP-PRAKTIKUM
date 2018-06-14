package talerverteilung;

import java.util.ArrayList;

/**
 *
 * @author funbold
 */
public class Terminal {
    
    /**
     *
     */
    public Eingabe in;

    /**
     *
     */
    public Ausgabe out;

    /**
     *
     */
    public Dispatcher disp;
    
    /**
     *
     */
    public Terminal(){

        in = new Eingabe();
        out = new Ausgabe();
        disp = in.run();

    }
    
    /**
     *
     * @param menge
     */
    public void printResult(ArrayList<Menge> menge)
    {
      out.print(menge);
    }
    
}
