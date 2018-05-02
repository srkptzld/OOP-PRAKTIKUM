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
          
          for(int i = 0, j = waggons.size() - 1; i < j; i++) {
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
     * 1. Erneuert die momentanen getNiedrigsteWaggonNo()-Werte der beiden Gleise.
     * 
     * 2. Frägt per F-Abfrage ab, wo sich der momentan niedrigst nummerierte Waggon befindet
     *    und startet demnach eine der Schleifen.
     * 
     * 3. Frägt für jeden Waggon ab, ob dieser der niedrigst nummerierte ist und rangiert diesen demnach
     *    entweder auf das Zug- oder Nebengleis.
     * 
     */
    public void run() {
    
        int anzahlWaggons = _abstellGleis.getWaggons().size();
        
        for(int i=0; i <= anzahlWaggons; i++){
            
            // Schritt 1
            _abstellGleis.niedrigsteWaggonNo();
            _rangierGleis.niedrigsteWaggonNo();
            
            // Schritt 2
            if(_abstellGleis.getNiedrigsteWaggonNo() <= _rangierGleis.getNiedrigsteWaggonNo()){
                
                // Schritt 3
                for(int k =_abstellGleis.getWaggons().size() - 1; k >= 0; k--){
                    
                    if(_abstellGleis.getWaggons().get(k).getWaggonNo() == _abstellGleis.getNiedrigsteWaggonNo()){
                        _protokoll.hinzfuegen(new Aktion(_abstellGleis, _zugGleis, _abstellGleis.getNiedrigsteWaggonNo()));
                        _zugGleis.getWaggons().add(_abstellGleis.getWaggons().get(k));
                        _abstellGleis.getWaggons().remove(k);                        
                    }else{
                        _protokoll.hinzfuegen(new Aktion(_abstellGleis, _rangierGleis, _abstellGleis.getWaggons().get(k).getWaggonNo()));
                        _rangierGleis.getWaggons().add(_abstellGleis.getWaggons().get(k));
                        _abstellGleis.getWaggons().remove(k);
                    }                 
                }
                
            }else{
                
                // Schritt 3
                for(int k =_rangierGleis.getWaggons().size() - 1; k >= 0; k--){
                    
                    if(_rangierGleis.getWaggons().get(k).getWaggonNo() == _rangierGleis.getNiedrigsteWaggonNo()){
                        _protokoll.hinzfuegen(new Aktion(_rangierGleis, _zugGleis, _rangierGleis.getNiedrigsteWaggonNo()));
                        _zugGleis.getWaggons().add(_rangierGleis.getWaggons().get(k));
                        _rangierGleis.getWaggons().remove(k);
                    }else{
                        _protokoll.hinzfuegen(new Aktion(_rangierGleis, _abstellGleis, _rangierGleis.getWaggons().get(k).getWaggonNo()));
                        _abstellGleis.getWaggons().add(_rangierGleis.getWaggons().get(k));
                        _rangierGleis.getWaggons().remove(k);      
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