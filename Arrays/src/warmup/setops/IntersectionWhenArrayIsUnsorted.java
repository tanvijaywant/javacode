package warmup.setops;
import java.util.HashSet;
import java.util.Set;

       
public class IntersectionWhenArrayIsUnsorted {

    private static void printIntersectionWithoutDuplicates(int[] small, int[] big) {
        Set<Integer> set = new HashSet<Integer>();

        /**
         * For this type of code it should not matter, if we chose smallArr Or choose largeArr to populate `difference` initially.
         */
        for (int val : small) {
            set.add(val);
        }

        for (int val : big) {
            if (set.contains(val)) {
                System.out.println(val);
            }
        }  
        
        
       // return unique;
    }
//    
// TODO: post checkpoint.
//    
//    private static void printIntersectionWithDuplicates(int[] small, int[] big) {
//        
//        assert small != null;
//        assert big != null;
//        assert small.length <= big.length;
//
//        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
//
//        for (int val : small) {
//            if (map.containsKey(val)) {
//                map.put(val, map.get(val) + 1);
//            } else {
//                map.put(val, 1);
//            }
//        }
//
//        int hits = 0;
//
//        // printing intersection.
//        for (int val : big) {
//            if (map.containsKey(val) && map.get(val) > 0) {
//                System.out.print(val + " ");
//
//                int count = map.get(val);
//                map.put(val, count - 1);
//                hits++;
//
//                if (hits == small.length) {
//                    return;
//                }
//            }
//        }
//    }

    private static boolean overlappingArrays(int[] a1, int[] a2) {
        assert a1 != null;
        assert a2 != null;
        
        if (a1.length == 0 || a2.length == 0) {
            System.out.println("No intersection as one of the arrays is empty");
            return true;
        }

        if (a1[a1.length - 1] < a2[0] || a2[a2.length - 1] < a1[0]) {
            System.out.println("Arrays are distinct, no intersection.");
            return false;
        }

        return true;
    }
    
//    TODO: post checkpoint.
//    public static void findIntersectionWithDuplicates(int[] a1, int[] a2) {
//        
//        if (a1 == null || a2 == null) {
//           throw new NullPointerException();
//        }
//        
//        if (overlappingArrays(a1, a2)) {
//            if (a1.length < a2.length) {
//                printIntersectionWithDuplicates(a1, a2);
//            } else {
//                printIntersectionWithDuplicates(a2, a1);
//            }
//        }
//    }

    public static void findIntersectionWithoutDuplicates(int[] a1, int[] a2) {
        
        if (a1 == null || a2 == null) {
            throw new NullPointerException();
         }
        
        
        if (overlappingArrays(a1, a2)) {
            if (a1.length < a2.length) {
                printIntersectionWithoutDuplicates(a1, a2);
            } else {
                printIntersectionWithoutDuplicates(a2, a1);
            }
        }
    }

    public static void main(String args[]) {

        // the simplest test case:
        int a1[] = {1, 2, 3, 4, 5};
        int a2[] = {3, 4, 5};
       // findIntersectionWithDuplicates(a1, a2);
        System.out.println();
        findIntersectionWithoutDuplicates(a1, a2);

        System.out.println("\n-------------------------------------------------------");

        //no intersection
        int a3[] = {1, 2, 3};
        int a4[] = {4, 5, 6};
       // findIntersectionWithDuplicates(a3, a4);
        System.out.println();
        findIntersectionWithoutDuplicates(a3, a4);

        System.out.println("\n-------------------------------------------------------");

        // only the tail intersects.
        int a5[] = {1, 2, 3};
        int a6[] = {3, 4, 5};
       // findIntersectionWithDuplicates(a5, a6);
        System.out.println();
        findIntersectionWithoutDuplicates(a5, a6);

        System.out.println("\n-------------------------------------------------------");

        // -ve numbers
        int a7[] = {-3, -2, -1};
        int a8[] = {-1, 0, 1};
        //findIntersectionWithDuplicates(a7, a8);
        System.out.println();
        findIntersectionWithoutDuplicates(a7, a8);

        System.out.println("\n-------------------------------------------------------");

        // null array
        int a9[] = {};
        int a10[] = {1, 2, 3};
        //findIntersectionWithDuplicates(a9, a10);
        System.out.println();
        findIntersectionWithoutDuplicates(a9, a10);

        System.out.println("\n-------------------------------------------------------");

        // repeating or warmup.duplicate numbers
        int a11[] = {1, 1, 2, 2 };
        int a12[] = {2, 2, 3, 3 };
        //findIntersectionWithDuplicates(a11, a12);
        System.out.println();
        findIntersectionWithoutDuplicates(a11, a12);

        System.out.println("\n-------------------------------------------------------");

        // common numbers repeat with different frequency
        int a13[] = {1, 2, 3, 3};
        int a14[] = {3, 3, 3, 4, 5 };
       // findIntersectionWithDuplicates(a13, a14);
        System.out.println();
        findIntersectionWithoutDuplicates(a13, a14);

    }
}
