package nimspiel;

import java.util.Scanner;

/**
 * Terminal Klasse: Führt das Nim-Spiel aus.
 * @author sirkpetzold
 */
public class Terminal {

    private Spiel _spiel;

    /**
     * Konstruktor
     */
    public Terminal() {
        Ausgabe.Begruessung();
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        _spiel = new Spiel(name);
        System.out.println();
        Ausgabe.SpielRegeln(_spiel.getSteine());
    }
    
    /**
     * Schleife bis keine Steine mehr ziehbar
     */
    public void Run() {
        IPlayingMember aktSpieler = null;
        int abzuziehendeSteine;
        Ausgabe.ZugEnde(0, _spiel);
        while (_spiel.getSteine() > 0) {
            if (_spiel.getDran() > 0) {
                aktSpieler = _spiel.getCom();
            } else {
                aktSpieler = _spiel.getSpieler();
            }

            abzuziehendeSteine = aktSpieler.Zug(_spiel.getSteine());
            _spiel.verringereSteineUm(abzuziehendeSteine);
            _spiel.erhoeheRunde();
            Ausgabe.ZugEnde(abzuziehendeSteine, _spiel);
            _spiel.setDran((byte) (1 - _spiel.getDran()));
        }
        Ausgabe.SpielEnde(_spiel);
  
    }
  

    /**
     * Reinitialisiert das Spiel
     */
    public void ReInit(){
        String name = _spiel.getSpieler().getName();
        _spiel = null;
        _spiel = new Spiel(name);
    }

}
