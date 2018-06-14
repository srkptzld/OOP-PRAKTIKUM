package talerverteilung;

import java.util.ArrayList;

/**
 *
 * @author sirkpetzold
 */
public class Menge {
    
    private ArrayList<Integer> _talerMenge;

    /**
     *
     */
    public Menge() {
        _talerMenge = new ArrayList<>();
    }
    
    /**
     *
     * @param a
     */
    public void addTaler(int a){
        _talerMenge.add(a);
    }
    
    /**
     *
     * @param a
     * @param b
     */
    public void addTaler(int a, int b)
    {
        for (int i = 0; i < b; i++) 
            addTaler(a);       
    }
    
    /**
     *
     * @param list
     */
    public void addList(ArrayList<Integer> list)
    {
        _talerMenge.addAll(list);
    }
    
    /**
     *
     * @return
     */
    public int sumMenge(){
        int result = 0;
        for (int i = 0; i < _talerMenge.size(); i++) {
            result = _talerMenge.get(i);
        }
        return result;
    }
    
    /**
     *
     * @return
     */
    public ArrayList<Integer> getMenge()
    {
        return _talerMenge;
    }
    
    /**
     *
     * @return
     */
    public int getCount(){
        return _talerMenge.size();
    }
    
    public String toString(){
        String res = "{";
        for (int i = 0; i < _talerMenge.size(); i++) {
            res += _talerMenge.get(i) + ",";
        }
        res += "}";
        return res;
    }
}
