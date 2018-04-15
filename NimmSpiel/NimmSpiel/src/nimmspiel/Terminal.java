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
        System.out.println();
        Ausgabe.SpielRegeln(_spiel.getSteine());
    }

    // Schleife bis keine Steine mehr ziehbar
    public void Run() {
        IPlayingMember aktSpieler = null;
        int abzuziehendeSteine;
        Ausgabe.ZugEnde(0, _spiel.getSteine(), aktSpieler);
        while (_spiel.getSteine() > 0) {
            if (_spiel.getDran() > 0) {
                aktSpieler = _spiel.getCom();
            } else {
                aktSpieler = _spiel.getSpieler();
            }

            abzuziehendeSteine = aktSpieler.Zug(_spiel.getSteine());
            _spiel.verringereSteineUm(abzuziehendeSteine);
            _spiel.erhoeheRunde();
            _spiel.setDran((byte) (1 - _spiel.getDran()));
            Ausgabe.ZugEnde(abzuziehendeSteine, _spiel);
        }
        Ausgabe.SpielEnde(_spiel);
    }
    
    // Re-Initializes 
    public void ReInit(){
        String name = _spiel.getSpieler().getName();
        _spiel = null;
        System.gc();
        _spiel = new Spiel(name);
    }

}
