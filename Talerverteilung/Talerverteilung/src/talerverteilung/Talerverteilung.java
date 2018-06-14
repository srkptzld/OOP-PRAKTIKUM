package talerverteilung;

import java.util.ArrayList;

/**
 *
 * @author funbold
 */
public class Talerverteilung {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        Terminal terminal = new Terminal();
        
        ArrayList<NumSet> result = new ArrayList<>();
        boolean isDispatchableInKSubSets = terminal.disp.Run(result);
        
        if (isDispatchableInKSubSets)
            terminal.out.print(result, isDispatchableInKSubSets);
       
    }
}
