package nimspiel;

import java.util.InputMismatchException;
import java.util.Scanner;
/**
 *
 * @author funbold
 */
public class Main {

    /**
     * Main: Führt das Spiel aus
     * @param args
     */
    public static void main(String[] args) { 
        Terminal terminal = new Terminal();
        boolean wertIstGueltig;
        int run = 1;
        
        while (run > 0)
        {
            wertIstGueltig = false;
            terminal.Run();
            
            System.out.println("Nochmal? (1 = Ja / 0 = Nein)");
            while (!wertIstGueltig)
               try{ 
                    Scanner s = new Scanner(System.in);         
                    run = s.nextInt(); 
                    wertIstGueltig = ((run <= 1)||(run >= 0));
                    if (!wertIstGueltig){
                        System.out.println("Bitte 0 oder 1 eingeben.");
                        System.out.println("Nochmal? (1 = Ja / 0 = Nein)");              
                    }
                }catch(InputMismatchException e){
                    System.out.println("Bitte 0 oder 1 eingeben.");
                    System.out.println("Nochmal? (1 = Ja / 0 = Nein)");
                    continue;
                }
           
            if (run > 0)
                terminal.ReInit();
        }
    }

}
