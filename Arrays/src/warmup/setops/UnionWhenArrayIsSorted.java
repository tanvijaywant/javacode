package warmup.setops;

import java.util.ArrayList;
import java.util.List;
 
/**
 * Ignoring the case of duplicates since no such answers were found on the internet. following the most standard answer.
 * 
 * Reference: 
 * http://www.geeksforgeeks.org/union-and-intersection-of-two-sorted-arrays-2/
 * http://leetcode.com/2010/03/here-is-phone-screening-question-from.html
 * 
 * Complexity 0(n)
 * 
 * References::
 * Software Design: http://stackoverflow.com/questions/16954952/software-design-how-to-design-a-function-with-two-responsibilities
 * Software Design: http://stackoverflow.com/questions/16976939/is-assert-in-privation-function-redundant-if-check-has-already-been-made-by-the
 * Effective java:Page: 182, chapter 7, Item 138
 * 
 * BB
 * 9
 */
public class UnionWhenArrayIsSorted {

   
    public static List<Integer> findUnion(int[] a1, int[] a2) {
   
        List<Integer> union = new ArrayList<>();

        int i = 0;
        int j = 0;
       
        while (i < a1.length && j < a2.length) {
            if (a1[i] < a2[j]) {
                System.out.print(a1[i] + " ");
                union.add(a1[i]);
                i++;
            } else  if (a1[i] > a2[j]) {
                System.out.print(a2[j] + " ");
                union.add(a2[j]);
                j++;
            } else {
                System.out.print(a2[j] + " "); 
                union.add(a2[j]);
                i++;
                j++;
            }
        }
      
        for (int x = i; x < a1.length; x++) {
            union.add(a1[x]);
        }
      
        for (int x = j; x < a2.length; x++) {
            union.add(a2[x]);
        }
        
        return union;
    }
    

    public static void main(String[] args) {
        // overlapping array
        int[] a1 = {1, 2, 3, 4, 5, 7, 9};
        int[] a2 = {1, 2, 3, 4, 5, 6, 8, 10};
        findUnion(a1, a2); // output as expected.

        System.out.println();

        // distinct
        int[] a3 = {1, 2, 3, 4, 5};
        int[] a4 = {6, 7, 8, 9, 10};
        findUnion(a3, a4); // output as expected.

        System.out.println();

        // last element overlap
        int[] a5 = {1, 2, 3, 4, 5};
        int[] a6 = {5, 6, 7, 8, 9, 10};
        findUnion(a5, a6);  // output as expected.

        System.out.println();

        // empty array
        int[] a7 = { };
        int[] a8 = {1, 2, 3};
        findUnion(a7, a8);

        System.out.println();

        // testing -ve integers
        int[] a9 = {-3, -2, -1};
        int[] a10 = {-2, -1, 0, 1, 2};
        findUnion(a9, a10);

        System.out.println();
        // repeating or warmup.duplicate numbers
        /**
         * Mathematically a set cannot have warmup.duplicate, elements, but an array can have.
         * Ask the interviewer what his definition of union is and tune the answer accordingly,
         * At moment of writting I believe keeping warmup.duplicate is the right was as an
         * a[] = {1, 2, 2} union with a2[] = null should not truncate the first array.
         */
        int[] a11 = {1, 1, 2, 2 };
        int[] a12 = {2, 2, 3, 3 };
        findUnion(a11, a12);

        System.out.println();
        // common numbers repeat with different frequency
        int[] a13 = {1, 2, 3, 3};
        int[] a14 = {3, 3, 3, 4, 5 };
        findUnion(a13, a14);
    }
}
