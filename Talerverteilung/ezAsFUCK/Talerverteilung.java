package talerverteilung;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Talerverteilung {

    public static void main(String[] args) {
        int k = 12;
        
        Menge menge = new Menge();
        menge.addTaler(1);
        menge.addTaler(2);
        menge.addTaler(2);
        menge.addTaler(2);
        menge.addTaler(3);
        menge.addTaler(3);
        menge.addTaler(3);
        menge.addTaler(4);
        menge.addTaler(4);
        menge.addTaler(4);
        menge.addTaler(4);
        menge.addTaler(4);
        menge.addTaler(5);
        menge.addTaler(5);
        menge.addTaler(5);
        menge.addTaler(5);
        menge.addTaler(5);
        menge.addTaler(6);
        menge.addTaler(7);
        menge.addTaler(7);
        menge.addTaler(7);
        menge.addTaler(8);
        menge.addTaler(9);
        menge.addTaler(9);
        menge.addTaler(10);
        menge.addTaler(10);
        menge.addTaler(10);
        
        int[] a = new int[27];
        for (int i = 0; i < a.length; i++) {
            a[i] = menge.talerMenge.get(i);
        }

        ArrayList<Menge> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(new Menge());
        }
        Talerverteilung tv = new Talerverteilung();
        
        System.out.println(tv.canPartitionKSubsets(a, k, result));
        
        for (int i = 0; i < k; i++) {
            System.out.println(i + ": " + result.get(i).talerMenge.toString());
        }
    }

    public boolean search(int[] groups, int row, int[] nums, int target, List<Menge> result) {
        if (row < 0) return true;
        int v = nums[row--];
        for (int i = 0; i < groups.length; i++) {
            if (groups[i] + v <= target) {
                groups[i] += v;
                result.get(i).talerMenge.add(v);
                if (search(groups, row, nums, target, result)) return true;
                groups[i] -= v;

            }
            if (groups[i] == 0) break;
        }
        return false;
    }

    public boolean canPartitionKSubsets(int[] nums, int k, List<Menge> result) {
        int sum = Arrays.stream(nums).sum();
        if (sum % k > 0) return false;
        int target = sum / k;

        Arrays.sort(nums);
        
        int row = nums.length - 1;
        
        if (nums[row] > target) return false;
        while (row >= 0 && nums[row] == target) {
            result.get(row).talerMenge.add(nums[row]);
            row--;
            k--;
        }
        return search(new int[k], row, nums, target, result);
    }

}
