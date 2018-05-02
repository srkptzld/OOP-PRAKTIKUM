package rangieren;

import java.util.ArrayList;

/**
 *
 * @author sirkpetzold
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Terminal terminal = new Terminal();
        ArrayList<Waggon> waggons = terminal.Wagenreihenfolge();
        Rangieren rangieren = new Rangieren(waggons);
        rangieren.run();
        
    }
    
}
