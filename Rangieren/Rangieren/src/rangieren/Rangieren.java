package rangieren;

import java.util.*;

/**
 * 
 * @author funbold
 */
public class Rangieren {

    /**
     * Gleis auf welchem der später fertige Zug steht
     */
    private Gleis _zugGleis;

    /**
     * Gleis auf welchem der ungeordnete Zug steht
     */
    private Gleis _abstellGleis;

    /**
     * Rangiergleis
     */
    private Gleis _rangierGleis;

    /**
     * Protokoll
     */
    private Protokoll _protokoll;
    
    /**
     * Konstruktor
     * 
     * @param waggons
     */
    public Rangieren(ArrayList<Waggon> waggons) {
        
        _zugGleis = new Gleis("zugGleis");
        _abstellGleis = new Gleis("abstellGleis");
        _rangierGleis = new Gleis("rangierGleis");
        _protokoll = new Protokoll;
        
        _abstellGleis._waggons = waggons;
        
    }

    /**
     * Hauptfunktion des Programms in mehreren Schritten.
     * 
     * 1. Erneuert die momentanen _niedrigsteWaggonNo-Werte der beiden Gleise.
     * 
     * 2. Frägt per F-Abfrage ab, wo sich der momentan niedrigst nummerierte Waggon befindet
     *    und startet demnach eine der Schleifen.
     * 
     * 3. Frägt für jeden Waggon ab, ob dieser der niedrigst nummerierte ist und rangiert diesen demnach
     *    entweder auf das Zug- oder Nebengleis.
     * 
     */
    public void run() {
    
        int anzahlWaggons = _abstellGleis._waggons.size();
        
        for(int i=0; i <= anzahlWaggons; i++){
            
            // Schritt 1
            _abstellGleis.niedrigsteWaggonNo();
            _rangierGleis.niedrigsteWaggonNo();
            
            // Schritt 2
            if(_abstellGleis._niedrigsteWaggonNo <= _rangierGleis._niedrigsteWaggonNo){
                
                // Schritt 3
                for(int k =_abstellGleis._waggons.size(); k > 0; k--){
                    
                    if(_abstellGleis._waggons.get(k).getWaggonNo() == _abstellGleis._niedrigsteWaggonNo){
                        new Aktion(_abstellGleis, _zugGleis, _abstellGleis._niedrigsteWaggonNo);
                        _zugGleis._waggons.add(_abstellGleis._waggons.get(k));
                        _abstellGleis._waggons.remove(k);                        
                    }else{
                        new Aktion(_abstellGleis, _rangierGleis, _abstellGleis._waggons.get(k).getWaggonNo());
                        _rangierGleis._waggons.add(_abstellGleis._waggons.get(k));
                        _abstellGleis._waggons.remove(k);
                    }                 
                }
                
            }else{
                
                // Schritt 3
                for(int k =_rangierGleis._waggons.size(); k > 0; k--){
                    
                    if(_rangierGleis._waggons.get(k).getWaggonNo() == _rangierGleis._niedrigsteWaggonNo){
                        new Aktion(_rangierGleis, _zugGleis, _rangierGleis._niedrigsteWaggonNo);
                        _zugGleis._waggons.add(_rangierGleis._waggons.get(k));
                        _rangierGleis._waggons.remove(k);
                    }else{
                        new Aktion(_rangierGleis, _abstellGleis, _rangierGleis._waggons.get(k).getWaggonNo());
                        _abstellGleis._waggons.add(_rangierGleis._waggons.get(k));
                        _rangierGleis._waggons.remove(k);      
                    }
                }
            }            
        }  
    }

    /**
     * @return
     */
    public Aktion naechsteAktion() {
        // TODO implement here
        return null;
    }

}