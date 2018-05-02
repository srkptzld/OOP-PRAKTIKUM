
package rangieren;

import java.util.ArrayList;

/**
 * 
 * @author sirkpetzold
 */
public class Gleis {

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
     * Default constructor
     * @param gleisTyp
     * @param waggons
     */
    public Gleis(String gleisTyp, ArrayList<Waggon> waggons) {
        
        _gleisTyp = gleisTyp;
        if (waggons == null)
            _waggons = new ArrayList<>();
        else
        _waggons = waggons;
        _niedrigsteWaggonNo = 0; 
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
    
    /**
     *
     * @return
     */
    public int getNiedrigsteWaggonNo(){
        return _niedrigsteWaggonNo;
    }

    /**
     * Legt die momentan niedrigste WaggonNo fest
     */
    public void niedrigsteWaggonNo(){
        
        for(int i = 0; i < _waggons.size(); i++){   
            if(_waggons.get(i).getWaggonNo() < _niedrigsteWaggonNo){
                _niedrigsteWaggonNo = _waggons.get(i).getWaggonNo();
            }
        }
        
    }
}