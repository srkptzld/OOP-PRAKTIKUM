package nimspiel;

import java.util.Scanner;
/**
 *
 * @author funbold
 */
public class Main {

    /**
     *
     * @param args
     */
    public static void main(String[] args) { 
        Terminal terminal = new Terminal();
        
        int run = 1;
        while (run > 0)
        {
            terminal.Run();
            System.out.println("Nochmal? (1 = Ja / 0 = Nein)");
            Scanner s = new Scanner(System.in);
            run = s.nextInt();  
            if (run > 0)
                terminal.ReInit();
        }
    }

}
