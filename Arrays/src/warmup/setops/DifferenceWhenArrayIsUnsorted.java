package warmup.setops;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 
 * BB:
 * 7
 * 
 * Complexity :
 * O(n)
 * 
 */
public class DifferenceWhenArrayIsUnsorted {

    // Assumes no repeatitions.
    public static Set<Integer> findDifferenceWhenSetsContainUniqueElements(int[] a1, int[] a2) {
        if (a1.length < a2.length) {
            return findDiff(a1, a2);
        } else {
            return findDiff(a2, a1);
        }
    }
    
    
    private static Set<Integer> findDiff(int[] smallArr, int[] largeArr) {
        Set<Integer> unique = new HashSet<Integer>();
        Set<Integer> visited = new HashSet<Integer>();
        
        List<Integer> list = new ArrayList<>();
 
        /**
         * For this type of code it should not matter, if we chose smallArr Or choose largeArr to populate `difference` initially.
         */
        for (int val : smallArr) {
            unique.add(val);
        }
        
        for (int val : largeArr) { 
            if (!visited.contains(val)) {
                if (!unique.contains(val)) {
                    unique.add(val);
                } else {
                    unique.remove(val);
                    visited.add(val);
                }
            } 
        }
        
        for (int val : unique) {
            System.out.print(val + ","); 
            list.add(val);
        }
        
        return unique;
    }
    
    
//  TODO: past checkpoint.    
//
//    public static void findDifferenceWhenSetsContainDuplicates(int[] a1, int[] a2) {
//
//        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
//
//        for (int i=0; i < a1.length; i++) {
//            if (map.containsKey(a1[i])) {
//                map.put(a1[i], map.get(a1[i]) + 1);
//            } else {
//                map.put(a1[i], 1);
//            }
//        }
//
//        // printing difference.
//        for (int i=0; i < a2.length; i++) {
//            if (map.containsKey(a2[i]) && map.get(a2[i]) > 0) {
//                int count = map.get(a2[i]);
//                if (count > 0) {
//                    map.put(a2[i], count - 1); 
//                } else {
//                    System.out.print(a2[i] + " ");
//                }
//             } else {
//                System.out.print(a2[i] + " ");
//             }
//        }
//
//        for (int val : a1)  {
//            if (map.get(val) > 0) {
//                System.out.print(val + " ");
//            }
//        }
//    }
//    
//    
//    
//    private static List<Integer> getDiff(int[] small, int[] large) {
//        final Map<Integer, Integer> map = new HashMap<Integer, Integer>();
//
//        for (int i=0; i < small.length; i++) {
//            if (!map.containsKey(small[i])) {
//                map.put(small[i], 1);
//            } 
//            map.put(small[i], map.get(small[i]) + 1);
//        }
//        
//        for (int i = 0; i < large.length; i++) {
//            if (map.containsKey(key))
//        }
//        
//        
//        
//        
//    }
//    
    
    

    public static void main(String args[]) {

        // happy test case.
        int[] a1 = {1, 2, 3, 4, 5};
        int[] a2 =           {4, 5, 12, 14};
        findDifferenceWhenSetsContainUniqueElements(a1, a2);
        System.out.println();
       // findDifferenceWhenSetsContainDuplicates(a1, a2);

        System.out.println("\n ---------------------------------------------------------");

        // no intersection between 2 arrays.
        int[] a3 = {1, 2, 3};
        int[] a4 = {4, 5, 6};
        findDifferenceWhenSetsContainUniqueElements(a3, a4);
        System.out.println();
        //findDifferenceWhenSetsContainDuplicates(a3, a4);

        System.out.println("\n ---------------------------------------------------------");

        // testing null array
        int[] a5 = {};
        int[] a6 = {1, 2, 3};
        findDifferenceWhenSetsContainUniqueElements(a5, a6);
        System.out.println();
        // findDifferenceWhenSetsContainDuplicates(a5, a6);

        System.out.println("\n ---------------------------------------------------------");

        // same arrays
        int[] a7 = {1, 2, 3};
        int[] a8 = {1, 2, 3};
        findDifferenceWhenSetsContainUniqueElements(a7, a8);
        System.out.println();
       // findDifferenceWhenSetsContainDuplicates(a7, a8);

        System.out.println("\n ---------------------------------------------------------");
        System.out.println();

        // negative integers
        int[] a9 = {-3, -2, -1};
        int[] a10 = {-1, 1, 2 };
        findDifferenceWhenSetsContainUniqueElements(a9, a10);
        System.out.println();
        //findDifferenceWhenSetsContainDuplicates(a9, a10);

        System.out.println("\n ---------------------------------------------------------");

        // repeating or warmup.duplicate numbers
        int[] a11 = {1, 1, 2, 2 };
        int[] a12 = {2, 2, 3, 3 };
        findDifferenceWhenSetsContainUniqueElements(a11, a12); // expected malfunction
        System.out.println();
        //findDifferenceWhenSetsContainDuplicates(a11, a12);

        System.out.println("\n ---------------------------------------------------------");

        // common numbers repeat with different frequency
        int[] a13 = {1, 2, 3, 3};
        int[] a14 = {3, 3, 3, 4, 5 };
        findDifferenceWhenSetsContainUniqueElements(a13, a14); // expected malfunction
        System.out.println();
       // findDifferenceWhenSetsContainDuplicates(a13, a14);
    }
}
