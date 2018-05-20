package rangieren;

import java.util.*;

/**
 * Die Klasse Rangieren enthält die Hauptmethode des Programms,
 * welche den ungeordneten Zug in geordneter Reihenfolge auf das Zuggleis rangiert. 
 * 
 * @author funbold
 */
public class Rangieren {

   
    private Gleis _zugGleis;
    private Gleis _abstellGleis;
    private Gleis _rangierGleis;
    private Protokoll _protokoll;

    /**
     * Konstruktor
     * 
     * @param waggons
     */
    public Rangieren(ArrayList<Waggon> waggons) {

        for (int i = 0, j = waggons.size() - 1; i < j; i++) {
            waggons.add(i, waggons.remove(j));
        }

        _zugGleis = new Gleis("zugGleis", null);
        _rangierGleis = new Gleis("rangierGleis", null);
        _abstellGleis = new Gleis("abstellGleis", waggons);
        _protokoll = new Protokoll(_zugGleis, _rangierGleis, _abstellGleis);

    }

    /**
     * Hauptfunktion des Programms in mehreren Schritten.
     *
     * 1. Erneuert die momentanen getNiedrigsteWaggonNo()-Werte der beiden
     * Gleise.
     *
     * 2. Frägt per F-Abfrage ab, wo sich der momentan niedrigst nummerierte
     * Waggon befindet und startet demnach eine der Schleifen.
     *
     * 3. Frägt für jeden Waggon ab, ob dieser der niedrigst nummerierte ist und
     * rangiert diesen demnach entweder auf das Zug- oder Nebengleis.
     *
     */
    public void run() {

        int anzahlWaggons = _abstellGleis.getWaggons().size();

        while (_zugGleis.getWaggons().size() <= anzahlWaggons) {
            if (_zugGleis.getWaggons().size() == anzahlWaggons) 
                break;
            
            // Schritt 1
            _abstellGleis.berechneNiedrigsteWaggonNo();
            _rangierGleis.berechneNiedrigsteWaggonNo();

            ArrayList<Waggon> waggonsAbstellGleis = _abstellGleis.getWaggons();
            ArrayList<Waggon> waggonsRangierGleis = _rangierGleis.getWaggons();
            int waggonNo;
            // Schritt 2
            if (_abstellGleis.getNiedrigsteWaggonNo() <= _rangierGleis.getNiedrigsteWaggonNo()) {
                
                // Schritt 3
                for (int k = waggonsAbstellGleis.size() - 1; k >= 0; k--) {
                    if (waggonsAbstellGleis.get(k).getWaggonNo() == _abstellGleis.getNiedrigsteWaggonNo()) {
                        _zugGleis.waggonHinzufuegen(waggonsAbstellGleis.get(k));
                        waggonsAbstellGleis.remove(k);
                        _protokoll.hinzfuegen(new Aktion(_abstellGleis, _zugGleis, _abstellGleis.getNiedrigsteWaggonNo(), _zugGleis, _abstellGleis, _rangierGleis));
                        break;
                    } else {
                        waggonNo = waggonsAbstellGleis.get(k).getWaggonNo();
                        _rangierGleis.waggonHinzufuegen(waggonsAbstellGleis.get(k));
                        waggonsAbstellGleis.remove(k);
                        _protokoll.hinzfuegen(new Aktion(_abstellGleis, _rangierGleis, waggonNo, _zugGleis, _abstellGleis, _rangierGleis));
                    }
                }
                
            // Schritt 2
            } else {

                // Schritt 3
                for (int k = waggonsRangierGleis.size() - 1; k >= 0; k--) {

                    if (waggonsRangierGleis.get(k).getWaggonNo() == _rangierGleis.getNiedrigsteWaggonNo()) {
                        _zugGleis.waggonHinzufuegen(waggonsRangierGleis.get(k));
                        waggonsRangierGleis.remove(k);
                        _protokoll.hinzfuegen(new Aktion(_rangierGleis, _zugGleis, _rangierGleis.getNiedrigsteWaggonNo(), _zugGleis, _abstellGleis, _rangierGleis));
                        break;
                    } else {
                        waggonNo = waggonsRangierGleis.get(k).getWaggonNo();
                        _abstellGleis.waggonHinzufuegen(waggonsRangierGleis.get(k));
                        waggonsRangierGleis.remove(k);
                    _protokoll.hinzfuegen(new Aktion(_rangierGleis, _abstellGleis, waggonNo, _zugGleis, _abstellGleis, _rangierGleis));
                        
                    }
                }
            }
            if (_zugGleis.getWaggons().size() == anzahlWaggons) {
                break;
            }
        }

        _protokoll.ausgabe();
    }

}
