/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package talerverteilung;

import java.util.ArrayList;

/**
 *
 * @author sirkpetzold
 */
public class Partition
{
    // A utility function that returns true if there is a
    // subset of arr[] with sun equal to given sum
    static boolean isSubsetSum (int arr[], int n, int sum)
    {
        // Base Cases
        if (sum == 0)
            return true;
        
        if (n == 0 && sum != 0)
            return false;
 
        // If last element is greater than sum, then ignore it
        if (arr[n-1] > sum)
            return isSubsetSum (arr, n-1, sum);
        else
            System.out.println(n + " | " + sum + " | " + arr[n-1] + " | " + (sum-arr[n-1]));
            
        /* else, check if sum can be obtained by any of
           the following
        (a) including the last element
        (b) excluding the last element
        */
        return isSubsetSum (arr, n-1, sum) ||
               isSubsetSum (arr, n-1, sum-arr[n-1]);
    }
 
    // Returns true if arr[] can be partitioned in m
    // subsets of equal sum, otherwise false
    static boolean findPartition (int arr[], int n, int m)
    {
        // Calculate sum of the elements in array
        int sum = 0;
        for (int i = 0; i < n; i++)
            sum += arr[i];
 
        // If sum is odd, there cannot be two subsets
        // with equal sum
        if (sum%m != 0)
            return false;
 
        // Find if there is subset with sum equal to half
        // of total sum
        
        return isSubsetSum (arr, n, sum/m);
    }

}