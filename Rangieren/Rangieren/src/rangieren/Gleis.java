
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
     * Default constructor
     */
    public Gleis(String gleisTyp) {
        
        _gleisTyp = gleisTyp;
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
     * Legt die momentan niedrigste WaggonNo fest
     */
    public void niedrigsteWaggonNo(){
        
        for(int i = 0; i <= _waggons.size(); i++){   
            if(_waggons.get(i).getWaggonNo() < _niedrigsteWaggonNo){
                _niedrigsteWaggonNo = _waggons.get(i).getWaggonNo();
            }
        }
        
    }
}