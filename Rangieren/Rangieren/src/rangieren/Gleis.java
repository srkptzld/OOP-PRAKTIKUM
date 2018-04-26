
import java.util.*;

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
    public ArrayList<Waggon> _waggons;

    /**
     * 
     */
    public int _niedrigsteWaggonNo;
   
    /**
     * 
     */ 
    private String _gleisTyp;



    /**
     * 
     */
    public void Create(String gleisTyp) {
        _gleisTyp = gleisTyp;
    }

    /**
     * @param waggon
     */
    public void waggonHinzufuegen(Waggon waggon) {
        // TODO implement here
    }

    /**
     * @return
     */
    public List<Waggon> getWaggons() {
        // TODO implement here
        return null;
    }

    /**
     * @param index
     */
    public void getAndRemoveWaggon(int index) {
        // TODO implement here
    }

    /**
     * @return the _gleisTyp
     */
    public String getGleisTyp() {
        return _gleisTyp;
    }

}