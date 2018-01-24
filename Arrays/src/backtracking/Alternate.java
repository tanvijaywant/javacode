package backtracking;

import java.util.ArrayList;
import java.util.List;


/**
 * 
 * Given a number num and size of array 'level'. 
 * Print all combination of element in the array such that first element of array is d and
 * next element in the array can be +1 or -1 the previous element in the array. Code was required.
   Input: num=4, level=3. Output - 4, 3, 2 || 4, 3, 4 || 4, 5, 4 || 4, 5, 6
 * 
 * BB:
 * 43
 * 
 * Complexity:
 * O(2^n) where n is array length.
 * Space
 * http://stackoverflow.com/questions/27309065/does-return-value-account-for-space-complexity
 *
 */
public final class Alternate {

    private Alternate() { }
    
    public static List<int[]> getCombinations(int num, int level) {
        final List<int[]> combinations = new ArrayList<int[]>();
        int[] arr = new int[level]; 
        computeCombinations(num, 0, combinations, arr); 
        return combinations;
    }
    
    private static void computeCombinations(int num, int currLevel, List<int[]> list, int[] arr) {
        if (currLevel == arr.length) {
            // list.add(arr);  <- wrong to do it so
            int[] temp = new int[arr.length];
            System.arraycopy(arr, 0, temp, 0, arr.length);
            list.add(temp);
            return;
        }
        
        arr[currLevel] = num;
        computeCombinations(num - 1, currLevel + 1, list, arr);
        computeCombinations(num + 1, currLevel + 1, list, arr);
    }
    
    public static void main(String[] args) {
        List<int[]> list = getCombinations(4, 3);
        
        for (int[] a : list) {
            for (int i : a) {
                System.out.print(i + ",");
            }
            System.out.println();
        }
    }
}
