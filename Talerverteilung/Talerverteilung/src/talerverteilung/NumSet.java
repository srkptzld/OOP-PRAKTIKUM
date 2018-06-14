package talerverteilung;

import java.util.ArrayList;

/**
 *
 * @author sirkpetzold
 */
public class NumSet {
    
    private ArrayList<Integer> _coinSet;

    /** 
     * Konstruktor
     */
    public NumSet() {
        _coinSet = new ArrayList<>();
    }
    
    /**
     * F�gt a _coinset hinzu
     * @param a Wert
     */
    public void addCoin(int a){
        _coinSet.add(a);
    }
    
    /**
     * F�gt a b-mal _coinset hinzu
     * @param a
     * @param b
     */
    public void addCoin(int a, int b)
    {
        for (int i = 0; i < b; i++) 
            addCoin(a);       
    }
    
    public void addCoinList(ArrayList<Integer> set){
        _coinSet.addAll(set);
    }
    
    /**
     * Gibt die Menge zur�ck
     * @return
     */
    public ArrayList<Integer> getMenge()
    {
        return _coinSet;
    }
    
    /**
     * Gibt Anzahl Taler zur�ck
     * @return
     */
    public int getCount(){
        return _coinSet.size();
    }
    
    
    @Override
    public String toString(){
        String res = "{";
        for (int i = 0; i < _coinSet.size(); i++) {
            res += _coinSet.get(i) + ",";
        }
        res += "}";
        return res;
    }
}
