/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package talerverteilung;

/**
 *
 * @author sirkpetzold
 */
public class Talerverteilung {

    /**
     * @param args the command line arguments
     */
 /*Driver function to check for above function*/
    public static void main (String[] args)
    {
        int arr[] = {1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 6, 7, 7, 7, 8, 9, 9, 10, 10, 10};
        int n = arr.length;
        if (Partition.findPartition(arr, n, 12) == true)
            System.out.println("Can be divided into two " +
                               "subsets of equal sum");
        else
            System.out.println("Can not be divided into" +
                            " " + n + " subsets of equal sum");
 
    }
    
}
