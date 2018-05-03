
package rangieren;

import java.util.ArrayList;

/**
 * 
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
        _zugGleisWaggons = buildGleisString(zugGleis);
        _abstellGleisWaggons = buildGleisString(abstellGleis);
        _rangierGleisWaggons = buildGleisString(rangierGleis);
        
    }
    
private String buildGleisString(Gleis gleis)
    {
        StringBuilder builder = new StringBuilder();   
        ArrayList<Waggon> waggons = gleis.getWaggons();
        for(int i = 0; i <= waggons.size() - 1;i++)
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
     *
     * @return
     */
    public String getWaggonStrings(){
        return _zugGleisWaggons + " | " + _rangierGleisWaggons +  " | " + _abstellGleisWaggons;
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

    /**
     * @param waggonNo the _waggonNo to set
     */
    public void setWaggonNo(String waggonNo) {
        this._waggonNo = waggonNo;
    }
}