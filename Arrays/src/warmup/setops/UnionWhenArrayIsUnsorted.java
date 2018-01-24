package warmup.setops;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Complexity : O(n)
 * 
 * @author ameya.patil
 */
public class UnionWhenArrayIsUnsorted {

    private static void simplyPrint(int a[]) {

        assert a != null;

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        } 
    }

    /**
     * The output of this function would differ with function findUnionCondideringDuplicates.
     * 
     *  int a13[] = {1, 2, 3, 3};
     *  int a14[] = {3, 3, 3, 4, 5 };
     *  findUnionCondideringDuplicates(a13, a14);
     * 
     * @param small
     * @param large
     */
    public static void findUnionWhenSetsAreUnique(int[] a1, int[] a2) {
        int[] small;
        int[] large;
        
        if (a1.length < a2.length) {
            small = a1;
            large = a2;
        } else {
            small = a2;
            large = a1;
        }
        
        Set<Integer> set = new HashSet<Integer>();

        /**
         * For this type of code it should not matter, if we chose smallArr Or choose largeArr to populate `difference` initially.
         */
        for (int val : small) {
            set.add(val);
        }
        
        for (int val : large) {
            set.add(val);
        }
        
        List<Integer> union =  new ArrayList<>(set);
        // return list;
    }

//    TODO: post checkpoint.
//    
//    /**
//     * The answer to this question would be exactly same as:
//     * https://bitbucket.org/ameyapatil/arrays/src/1febb896cabf0bc571c4d7d476ebd5aaed8bed27/src/UnionWhenArrayIsSorted.java?at=master
//     * 
//     * @param a1
//     * @param a2
//     */
//    public static void findUnionCondideringDuplicates(int[] a1, int[] a2) {
//
//        if (a1 == null || a2 == null) {
//            throw new NullPointerException();
//        }
//
//        if (a1.length == 0) {
//            simplyPrint(a2);
//            return;
//        }
//
//        if (a2.length == 0) {
//            simplyPrint(a1);
//            return;
//        }
//
//        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
//
//        for (int i=0; i < a1.length; i++) {
//            System.out.print(a1[i] + " ");
//            if (map.containsKey(a1[i])) {
//                map.put(a1[i], map.get(a1[i]) + 1);
//            } else {
//                map.put(a1[i], 1);
//            }
//        }
//
//        // printing union
//        for (int i=0; i < a2.length; i++) {
//            if (map.containsKey(a2[i]) && map.get(a2[i]) > 0) {
//                int count = map.get(a2[i]);
//                map.put(a2[i], count - 1); 
//             } else {
//                System.out.print(a2[i] + " ");
//             }
//        }
//    }

    public static void main(String[] args) {

        // overlapping array
        int a1[] = {1, 2, 3, 4, 5, 7, 9};
        int a2[] = {1, 2, 3, 4, 5, 6, 8, 10};
        findUnionWhenSetsAreUnique(a1, a2); 
        System.out.println();
     //   findUnionCondideringDuplicates(a1, a2); // output as expected.

        System.out.println("\n----------------------------------------------------");

        // distinct
        int a3[] = {1, 2, 3, 4, 5};
        int a4[] = {6, 7, 8, 9, 10};
        findUnionWhenSetsAreUnique(a3, a4);
        System.out.println();
      //  findUnionCondideringDuplicates(a3, a4); // output as expected.

        System.out.println("\n----------------------------------------------------");

        // last element overlap
        int a5[] = {1, 2, 3, 4, 5};
        int a6[] = {5, 6, 7, 8, 9, 10};
        findUnionWhenSetsAreUnique(a5, a6);
        System.out.println();
     //   findUnionCondideringDuplicates(a5, a6);  // output as expected.

        System.out.println("\n----------------------------------------------------");

        // empty array
        int a7[] = { };
        int a8[] = {1, 2, 3};
        findUnionWhenSetsAreUnique(a7, a8);
        System.out.println();
     //   findUnionCondideringDuplicates(a7, a8);

        System.out.println("\n----------------------------------------------------");

        // testing -ve integers
        int a9[] = {-3, -2, -1};
        int a10[] = {-2, -1, 0, 1, 2};
        findUnionWhenSetsAreUnique(a9, a10);
        System.out.println();
    //    findUnionCondideringDuplicates(a9, a10);

        System.out.println("\n----------------------------------------------------");
        // repeating or warmup.duplicate numbers
        /**
         * Mathematically a set cannot have warmup.duplicate, elements, but an array can have.
         * Ask the interviewer what his definition of union is and tune the answer accordingly,
         * At moment of writting I believe keeping warmup.duplicate is the right was as an
         * a[] = {1, 2, 2} union with a2[] = null should not truncate the first array.
         */
        int a11[] = {1, 1, 2, 2 };
        int a12[] = {2, 2, 3, 3 };
        findUnionWhenSetsAreUnique(a11, a12);
        System.out.println();
     //   findUnionCondideringDuplicates(a11, a12);

        System.out.println("\n----------------------------------------------------");
        // common numbers repeat with different frequency
        int a13[] = {1, 2, 3, 3};
        int a14[] = {3, 3, 3, 4, 5 };
        findUnionWhenSetsAreUnique(a13, a14);
        System.out.println("\nNote the difference");
      //  findUnionCondideringDuplicates(a13, a14);
    }
}
