
package rangieren;

import java.util.ArrayList;

/**
 * 
 * @author sirkpetzold
 */
public class Gleis {

    /**
     * Default constructor
     */
    public Gleis() {
    }

    /**
     * 
     */
    private ArrayList<Waggon> _waggons;

    /**
     * 
     */
    private int _niedrigsteWaggonNo;
   
    /**
     * 
     */ 
    private String _gleisTyp;



    /**
     * 
     * @param gleisTyp
     */
    public void Create(String gleisTyp) {
        _gleisTyp = gleisTyp;
    }

    /**
     * @param waggon
     */
    public void waggonHinzufuegen(Waggon waggon) {
        // TODO implement here
        _waggons.add(waggon);
    }

    /**
     * @return
     */
    public ArrayList<Waggon> getWaggons() {
        // TODO implement here
        return _waggons;
    }

    /**
     * @param index
     * @return 
     */
    public Waggon getAndRemoveWaggon(int index) {
        return _waggons.get(index);
    }

    /**
     * @return the _gleisTyp
     */
    public String getGleisTyp() {
        return _gleisTyp;
    }

}