package talerverteilung;

import java.util.ArrayList;

public class Menge {
    
    public ArrayList<Integer> talerMenge;

    public Menge() {
        this.talerMenge = new ArrayList<>();
    }
    
    public void addTaler(int a){
        talerMenge.add(a);
    }
    
    public int sumMenge(){
        int result = 0;
        for (int i = 0; i < talerMenge.size(); i++) {
            result = talerMenge.get(i);
        }
        return result;
    }
    
    public String toString(){
        String res = "{";
        for (int i = 0; i < talerMenge.size(); i++) {
            res += talerMenge.get(i) + ",";
        }
        res += "}";
        return res;
    }
}
