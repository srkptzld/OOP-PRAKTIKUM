
package rangieren;

import java.util.ArrayList;

/**
 * Datenhaltestruktur für das Wechseln des Gleises
 * @author sirkpetzold
 */
public class Aktion {

    /**
     * Aktuelles Gleis
     */
    private String _von;

    /**
     * Zielgleis
     */
    private String _nach;

    /**
     * Waggon Nummer
     */
    private String _waggonNo;
    
    private String _zugGleisWaggons;
    private String _abstellGleisWaggons;
    private String _rangierGleisWaggons;


    /**
     * @param von 
     * @param nach 
     * @param waggonNo
     * @param zugGleis
     * @param abstellGleis
     * @param rangierGleis
     */
    public Aktion(Gleis von, Gleis nach, int waggonNo, Gleis zugGleis, Gleis abstellGleis,Gleis rangierGleis) {
        _von = von.getGleisTyp();
        _nach = nach.getGleisTyp();
        _waggonNo = Integer.toString(waggonNo);
        _zugGleisWaggons = buildGleisString(zugGleis, false);
        _abstellGleisWaggons = buildGleisString(abstellGleis, true);
        _rangierGleisWaggons = buildGleisString(rangierGleis, true);
        
    }
    
private String buildGleisString(Gleis gleis, boolean reverseSort)
    {
        StringBuilder builder = new StringBuilder();   
        ArrayList<Waggon> waggons = gleis.getWaggons();
        if (!reverseSort)
            for(int i = 0; i <= waggons.size() - 1;i++)
           builder.append(waggons.get(i).getWaggonNo()).append((i == waggons.size()) ? " |" : " ");
        else
            for(int i = waggons.size() - 1; i >= 0 ;i--)
           builder.append(waggons.get(i).getWaggonNo()).append((i == waggons.size()) ? " |" : " ");
        return builder.toString();
    }

    /**
     * @return the _von
     */
    public String getVon() {
        return _von;
    }
    
    /**
     * Gibt String mit Waggons zurück
     * @param spaltenBreite
     * @return
     */
    public String getWaggonStrings(Integer spaltenBreite){
        return String.format("%" + spaltenBreite + "s", _zugGleisWaggons) + " | " + 
                String.format("%" + spaltenBreite + "s", _rangierGleisWaggons) + 
                " | " + String.format("%" + spaltenBreite + "s", _abstellGleisWaggons);
    }

    /**
     * @return the _nach
     */
    public String getNach() {
        return _nach;
    }

    /**
     * @return the _waggonNo
     */
    public String getWaggonNo() {
        return _waggonNo;
    }
    
}