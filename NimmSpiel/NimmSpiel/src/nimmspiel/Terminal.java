package nimmspiel;

import java.util.Scanner;

/**
 *
 * @author sirkpetzold
 */
public class Terminal {

    private Spiel _spiel;

    // Konstruktor, Instanziert das Feld _spiel und gibt die Spielregeln aus
    public Terminal() {
        Ausgabe.Begruessung();
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        _spiel = new Spiel(name);
        Ausgabe.SpielRegeln(_spiel.getSteine());
    }

    // Schleife bis keine Steine mehr ziehbar
    public void Run() {
        IPlayingMember aktSpieler;
        int abzuziehendeSteine;
        while (_spiel.getSteine() > 0) {
            if (_spiel.getDran > 0) {
                aktSpieler = _spiel.getCom();
            } else {
                aktSpieler = _spiel.getSpieler();
            }

            abzuziehendeSteine = aktSpieler.Zug(_spiel.getSteine());
            _spiel.verringereSteineUm(abzuziehendeSteine);
            _spiel.ErhoeheRunde();
            _spiel.SetDran(1 - _spiel.GetDran());
            Ausgabe.ZugEnde(abzuziehendeSteine, _spiel.getSteine());
        }
        Ausgabe.SpielEnde(_spiel);
    }

}
