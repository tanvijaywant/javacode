package sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


final class TripletData {
    
    private final int a;
    private final int b;
    private final int c;
    
    public TripletData(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public int getC() {
        return c;
    }
}





/**
 * http://www.geeksforgeeks.org/find-a-triplet-that-sum-to-a-given-value/
 *
 * BB:
 * 30
 * 
 * Complexity:
 * O(n2)
 * 
 */
public final class Triplets {
    
    private Triplets() {
    }
 
//     
//   TODO: post checkpoint. 
//    
//   /**
//    * Array is unsorted + input structure is not to be modified
//    */
//    public static List<TripletData> getTripletUnSorted(int[] a, int sum) {
//        if (a.length < 3) {
//            throw new NullPointerException("The array cannot be contain less than 3 elements.");
//        }
//        
//        final List<TripletData> triplets = new ArrayList<>(); 
//        final Set<Integer> dedupSet = new HashSet<>();
//        
//        for (int i = 0; i < a.length; i++) {
//            int twoSum = sum - a[i]; // ie: sum which should be equal to sum of 2 numbers.
//            dedupSet.add(a[i]);
//            
//            final Set<Integer> diffSet = new HashSet<>();
//            for (int j = 0; j < a.length; j++) {
//                if (!(dedupSet.contains(a[j]))) {
//                    int diff = twoSum - a[j];
//                    if (diffSet.contains(a[j])) {
//                        triplets.add(new TripletData(a[j], diff, a[i]));
//                    } else {
//                        diffSet.add(diff);
//                    }
//                }
//            }
//        }
//        
//        return triplets;
//    }
    
    
    
    
    /**
     * Array is unsorted and input structure is allowed to be modified.
     * Or
     * Arrays is sorted.
     */
    public static List<TripletData> getTripleSorted(int[] a, int sum) {
        if (a.length < 3) {
            throw new NullPointerException("The array cannot be contain less than 3 elements.");
        }
        
        final List<TripletData> triplets = new ArrayList<>();
         
        Arrays.sort(a);
        
        for (int i = 2; i < a.length; i++) {
            int j = 0;
            int k = i - 1;
            
            while (j < k) {
                int tempSum = a[i] + a[j] + a[k];
                if (tempSum < sum) {
                    j++;
                } else if (tempSum > sum) {
                    k--;
                } else {
                    triplets.add(new TripletData(a[i], a[j], a[k]));
                    j++;
                    k--;
                }
            }
        }
        
        return triplets;
    }
    

    public static void main(String[] args) {
        /**
         * Test case:
         * 1. Boundary (ie arrays is null, or array contains 2 elements)
         * 2. Repeating.
         * 3. Negatives.
         *
         */
        int[] a = {-2, -1, 0, 1, 2, 3, 4, 6};
        
        for (TripletData td :  Triplets.getTripletUnSorted(a, 6)) {
            System.out.println(td.getA() + " : " + td.getB() + " : " + td.getC());
        }
        
        System.out.println("-----------------------------");
        
        for (TripletData td :  Triplets.getTripleSorted(a, 6)) {
            System.out.println(td.getA() + " : " + td.getB() + " : " + td.getC());
        }
    }
}
