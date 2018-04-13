/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nimmspiel;

/**
 *
 * @author sirkpetzold
 */
public class Terminal {
    
    private Spiel _spiel;
    
    
    // Konstruktor, Instanziert das Feld _spiel und gibt die Spielregeln aus
    public Terminal(){
        _spiel = new Spiel();
        Ausgabe.SpielRegeln();
    }
    
    // Schleife bis keine Steine mehr ziehbar
    public void Run()
    {
        Spieler aktSpieler;
        int abzuziehendeSteine;
        while (_spiel.getSteine() > 0){
            if (_spiel.getDran > 0)
                aktSpieler = _spiel.getCom()
            else
                aktSpieler = _spiel.getSpieler();
            
            abzuziehendeSteine = aktSpieler.Zug();
            _spiel.verringereSteineUm(abzuziehendeSteine);
            _spiel.ErhoeheRunde();
            _spiel.SetDran(1-_spiel.GetDran());
            Ausgabe.ZugEnde(_spiel);
        }
        Ausgabe.SpielEnde(spiel);
    }
        
}
