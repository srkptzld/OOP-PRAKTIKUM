package talerverteilung;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author sirkpetzold
 */
public class Dispatcher {
    
private NumSet _set;
private int _count;
    
    /**
     * Konstruktor
     * @param set Ausgangsmenge
     * @param count Anzahl Teilmengen
     */
    public Dispatcher(NumSet set, int count){
        _set = set;
        _count = count;
    }
    
    /**
     * Führt das Auftrennen aus
     * @param result Liste von gleichegroßen Teilmengen
     * @return Ist Aufteilbar oder nicht
     */
    public boolean Run(ArrayList<NumSet> result){
        int[] a = new int[_set.getCount()];
        
        for (int i = 0; i < a.length; i++) 
            a[i] = _set.getMenge().get(i);
        
        if (result == null)
            result = new ArrayList<>();
        
         for (int i = 0; i < _count; i++) 
            result.add(new NumSet());
        
         
        boolean isDispatchableInKSubSets = canPartitionKSubsets(a, _count, result);
        return isDispatchableInKSubSets;
    }
    
    /**
     * Sucht nach Hinzufügbaren Zahlen in der Ausgangsmenge und 
     * fügt Sie in die passende Teilmenge ein
     * @param groups Summiert Teilmengen
     * @param row Index
     * @param nums Ausgangsmenge
     * @param target Zielgröße
     * @param result Aufgeteilte Mengen gleicher Größe
     * @return
     */
    private boolean search(int[] groups, int row, int[] nums, int target, List<NumSet> result) {
        if (row < 0) return true;
        int v = nums[row--];
        for (int i = 0; i < groups.length; i++) {
            if (groups[i] + v <= target) {
                groups[i] += v;
                result.get(i).getMenge().add(v);
                if (search(groups, row, nums, target, result)) return true;
                groups[i] -= v;
                result.get(i).getMenge().remove((Integer) v);
            }
            if (groups[i] == 0) break;
        }
        return false;
    }

    /**
     * Checkt ob Aufteilbar
     * @param nums Ausgangsmenge
     * @param k Anzahl Mengen
     * @param result Liste aufgeteilter Mengen
     * @return
     */
    private boolean canPartitionKSubsets(int[] nums, int k, List<NumSet> result) {
        int sum = Arrays.stream(nums).sum();
        if (sum % k > 0) return false;
        int target = sum / k;

        Arrays.sort(nums);
        
        int row = nums.length - 1;
        
        if (nums[row] > target) return false;
        while (row >= 0 && nums[row] == target) {
            result.get(row).getMenge().add(nums[row]);
            row--;
            k--;
        }
        return search(new int[k], row, nums, target, result);
    }
    
    /**
     * Gibt die Anzahl der Mengen zurück
     * @return Anzahl Mengen
     */
    public int getSubSetCount(){
        return _count;
    }

}
