
package rangieren;
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


    /**
     * @param von 
     * @param nach 
     * @param waggonNo
     */
    public Aktion(Gleis von, Gleis nach, int waggonNo) {
        _von = von;
        _nach = nach;
        _waggonNo = waggonNo;
    }

    /**
     * @return the _von
     */
    public Gleis getVon() {
        return _von;
    }

    /**
     * @param _von the Gleis to set
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