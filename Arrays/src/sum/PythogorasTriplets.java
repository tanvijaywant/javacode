package sum;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * 
 * BB:
 * 29
 * 
 * 
 * Complexity:
 * O(n2) 
 * 
 */
public final class PythogorasTriplets {
    
    private PythogorasTriplets() {}

    /**
     * Assumes array contains only positive numbers.
     * 
     * input is sorted list.
     */
    public static List<PythoTriplets> pythogorasTripletsSorted(int[] a) {
        if (a.length < 3) {
            throw new IllegalArgumentException("The array length is smaller than 3");
        }
        
        final List<PythoTriplets> triplets = new ArrayList<>();

        for (int i = 2; i < a.length; i++) {
            double cSquared = a[i] * a[i]; // to prevent int overflow

            int j = 0;
            int k = i - 1; // NOTE.

            while (j < k) {
                double sum  = a[j] * a[j] + a[k] * a[k];
                if (sum < cSquared) {
                    j++;
                } else if (sum > cSquared) {
                    k--;
                } else {
                    triplets.add(new PythoTriplets(a[j], a[k], a[i]));
                    j++;
                    k--;
                }
            }
        }  
        return triplets;
    }
    
    
    public static void main(String[] args) {
        int[] a = {6, 8, 10, 164, 625};
        // int[] a = {-8, 6, 10, 164, 625};
        
        for (PythoTriplets t  : PythogorasTriplets.pythogorasTriplets(a)) {
            System.out.println(t.getA() + " : " + t.getB() + " : " + t.getC());
        }
        
        System.out.println("--------------------------------");
        
        for (PythoTriplets t  : PythogorasTriplets.pythogorasTripletsSorted(a)) {
            System.out.println(t.getA() + " : " + t.getB() + " : " + t.getC());
        }
    }
}
