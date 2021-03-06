package nimspiel;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Enthält die Zug-Methode des Spielers sowie eine get-Methode für den
 * Spielernamen
 *
 * @author funbold
 */
public class Spieler implements IPlayingMember {

    private String _name;

    /**
     * Konstruktor
     *
     * @param name
     */
    public Spieler(String name) {
        _name = name;
    }

    /**
     * Nimmt den Zug entgegen und pr�ft ob regelkonform
     *
     * @param verbleibendeSteine
     * @return
     */
    @Override
    public int Zug(int verbleibendeSteine) {

        boolean konform = false;
        int abzug = 0;

        System.out.println("Wieviele Steine möchten Sie nehmen?");

        while (konform == false) {
            Scanner scanner = new Scanner(System.in);

            try {
                abzug = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Bitte eine Zahl zwischen 1 und 3 eingeben.");
                System.out.println("Wieviele Steine möchten Sie nehmen?");
                continue;
            }

            if (abzug < 1 || abzug > 3) {
                System.out.println("Die Eingabe ist nicht regelkonform.");
                System.out.println("Bitte wählen Sie eine Zahl von 1 bis 3.");
            } else if (verbleibendeSteine - abzug < 0) {
                System.out.println("Die Eingabe ist nicht regelkonform.");
                Ausgabe.ZugEnde(0, null);
            } else {
                konform = true;
            }

        }

        return abzug;

    }

    /**
     * Get-Methode für Spielernamen
     *
     * @return
     */
    @Override
    public String getName() {
        return _name;
    }

}
