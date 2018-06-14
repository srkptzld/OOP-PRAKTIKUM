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
     * Konstruktor
     */
    public Terminal(){

        in = new Eingabe();
        out = new Ausgabe();
        disp = in.run();

    }
    
    /**
     * Methode für Ergbenis, falls es keins gibt
     * 
     * @param menge Menge
     * @param isDispatchable Ist teilbar oder nicht
     */
    public void printResult(ArrayList<NumSet> menge, boolean isDispatchable)
    {
      out.print(menge, isDispatchable);
    }
    
}
