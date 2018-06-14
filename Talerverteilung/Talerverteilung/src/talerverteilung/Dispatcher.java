package talerverteilung;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author all
 */
public class Dispatcher {
    
private Menge _menge;
private int _count;
    
    /**
     *
     * @param menge
     * @param count
     */
    public Dispatcher(Menge menge, int count){
        _menge = menge;
        _count = count;
    }
    
    /**
     *
     * @param result
     * @return
     */
    public boolean Run(ArrayList<Menge> result){
        int[] a = new int[_menge.getCount()];
        for (int i = 0; i < a.length; i++) 
            a[i] = _menge.getMenge().get(i);
        
        if (result == null)
            result = new ArrayList<>();
        
         for (int i = 0; i < _count; i++) {
            result.add(new Menge());
        }
         
        boolean isDispatchableInKSubSets = canPartitionKSubsets(a, _count, result);
        return isDispatchableInKSubSets;
    }
    
    /**
     *
     * @param groups
     * @param row
     * @param nums
     * @param target
     * @param result
     * @return
     */
    public boolean search(int[] groups, int row, int[] nums, int target, List<Menge> result) {
        if (row < 0) return true;
        int v = nums[row--];
        for (int i = 0; i < groups.length; i++) {
            if (groups[i] + v <= target) {
                groups[i] += v;
                result.get(i).getMenge().add(v);
                if (search(groups, row, nums, target, result)) return true;
                groups[i] -= v;

            }
            if (groups[i] == 0) break;
        }
        return false;
    }

    /**
     *
     * @param nums
     * @param k
     * @param result
     * @return
     */
    public boolean canPartitionKSubsets(int[] nums, int k, List<Menge> result) {
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
     *
     * @return
     */
    public int getSubSetCount(){
        return _count;
    }

}
