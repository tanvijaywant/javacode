package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * Get random triplet:
 * https://www.careercup.com/question?id=5678056593162240
 *
 * Looking:
 * helloworld
 *
 * hlo
 * hew
 * wld
 * owo
 *
 * 
 * http://www.geeksforgeeks.org/print-all-possible-combinations-of-r-elements-in-a-given-array-of-size-n/
 * http://ideone.com/ywsqBz
 * 
 * BB:
 * 44
 *
 * Complexity:
 * Time:
 * http://stackoverflow.com/questions/24643367/whats-time-complexity-of-this-algorithm-for-finding-all-combinations
 * the time complexity = O(C(n,k) * k) = O((n!/(k! * (n - k)!)) * k), n and k is input,
 * The extra (*k) comes because we are going to print stuff in the end.
 * 
 * space:
 * I will be printing it not returning a value, thus aux complexity is O(r).
 * 
 * space:
 * http://stackoverflow.com/questions/27309065/does-return-value-account-for-space-complexity
 *
 */
public final class VariableCombinations {
    
    public VariableCombinations() { }
     
    public static List<int[]> variableCombinations(int[] a, int r) {
        if (r > a.length) { throw new IllegalArgumentException("The r : " + r + " should be greater than array"); }

        // sorting arrays to skip duplicates.
        Arrays.sort(a);
        
        final int[] buff = new int[r];
        final List<int[]> sets = new ArrayList<>();
        // remember parameters as : RIP.
        computeCombinations(a, buff,  0, 0, sets);
        return sets;
    } 
    
    private static void computeCombinations(int[] a, int[] buff, int pos, int index, List<int[]> sets) {
      //  if (pos > r) return;
        
        if (pos == buff.length) {
            /**
             *  https://www.careercup.com/question?id=5088794078347264
             *  compute sum here.
             */
            int[] temp = new int[buff.length];
            System.arraycopy(buff, 0, temp, 0, buff.length);
            sets.add(temp);
            return;
        }
        
        for (int i = index; i < a.length; i++) { 
            buff[pos] = a[i];
            computeCombinations(a, buff, pos + 1, i + 1, sets); 
            // same as run-length encoding.
            while ((i < a.length - 1) && (a[i] == a[i + 1])) {
                i++;
            }
        }
    }
    
    public static void main(String[] args) {
        int[] a = {11, 12, 13,  14};
       //  int[] a = {11, 12, 11,  13};
        List<int[]> list = VariableCombinations.variableCombinations(a, 3);
        
        for (int[] arr : list) {
            for (int i : arr) {
                System.out.print(i + ",");
            }
            System.out.println();
        }
    }
}
