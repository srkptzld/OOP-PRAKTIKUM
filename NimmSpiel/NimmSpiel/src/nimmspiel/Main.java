package nimmspiel;

import java.util.Scanner;
/**
 *
 * @author funbold
 */
public class Main {

    public static void main(String[] args) {
        Terminal terminal = new Terminal();
        
        boolean run = true;
        while (run)
        {
            terminal.Run();
            System.out.println("Nochmal? (1 = Ja / 0 = Nein");
            Scanner s = new Scanner(System.in);
            run = s.nextBoolean();  
        }
    }

}
