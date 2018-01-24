package sum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * FB:
 * https://www.careercup.com/question?id=5652354158297088
 *
 */
public class FourEqualNum {

    private static class Pair {
        int x;
        int y;
        
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public static void fourSum(int[] arr) {
        
        Map<Integer, List<Pair>> map = new HashMap<>();
        
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                
                int sum = arr[i] + arr[j];
                if (!map.containsKey(sum)) {
                    map.put(sum, new ArrayList<Pair>());
                }
                map.get(sum).add(new Pair(arr[i], arr[j]));
            }
        }
        
        for (Entry<Integer, List<Pair>> entry : map.entrySet()) {
            for (Pair p : entry.getValue()) {
                System.out.print(p.x + ":" + p.y + ", ");
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        int[] arr = {3, 4, 7, 1, 2, 9, 8};
        fourSum(arr);
    }
    
}
