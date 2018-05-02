
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
    private Gleis _von;

    /**
     * Zielgleis
     */
    private Gleis _nach;

    /**
     * Waggon Nummer
     */
    private int _waggonNo;
    
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
        _von = von;
        _nach = nach;
        _waggonNo = waggonNo;
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
    public Gleis getVon() {
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
     * @param von
     */
    public void setVon(Gleis von) {
        this._von = von;
    }

    /**
     * @return the _nach
     */
    public Gleis getNach() {
        return _nach;
    }

    /**
     * @param nach the Gleis to set
     */
    public void setNach(Gleis nach) {
        this._nach = nach;
    }

    /**
     * @return the _waggonNo
     */
    public int getWaggonNo() {
        return _waggonNo;
    }

    /**
     * @param waggonNo the _waggonNo to set
     */
    public void setWaggonNo(int waggonNo) {
        this._waggonNo = waggonNo;
    }
}