
import java.util.*;

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
     * @param _von the _von to set
     */
    public void setVon(Gleis _von) {
        this._von = _von;
    }

    /**
     * @return the _nach
     */
    public Gleis getNach() {
        return _nach;
    }

    /**
     * @param _nach the _nach to set
     */
    public void setNach(Gleis _nach) {
        this._nach = _nach;
    }

    /**
     * @return the _waggonNo
     */
    public int getWaggonNo() {
        return _waggonNo;
    }

    /**
     * @param _waggonNo the _waggonNo to set
     */
    public void setWaggonNo(int _waggonNo) {
        this._waggonNo = _waggonNo;
    }
}