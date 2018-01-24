[package setops;
import java.util.ArrayList;
import java.util.List;


/**
 * 
 * BB:
 * 7
 * 
 * Complexity: 0(nlogn)
 * 
 * References:
 * http://stackoverflow.com/questions/4182241/best-practice-if-logic-control
 * 
 */
public class DifferenceWhenArrayIsSorted {
    
    private DifferenceWhenArrayIsSorted() {};

    public static List<Integer> findDifference(int[] a1, int[] a2) {
        final List<Integer> list = new ArrayList<>();
        
        int i = 0;
        int j = 0;

        while (i < a1.length && j < a2.length) {
            if (a1[i] < a2[j]) {
                System.out.print(a1[i] + ",");
                list.add(a1[i]);
                i++;
            } else if (a1[i] > a2[j]) {
                System.out.print(a2[j] + ",");
                list.add(a2[j]);
                j++;
            } else {
                i++;
                j++;
            }
        }

        for (int x = i; x < a1.length; x++) {
            System.out.print(a1[x] + ",");
            list.add(a1[x]);
        }
        
        for (int x = j; x < a2.length; x++) {
            System.out.print(a2[x] + ",");
            list.add(a2[x]);
        }
        
        return list;
    }

    public static void main(String[] args) {
        // happy test case.
        int[] a1 = {1, 2, 3, 4, 5};
        int[] a2 =          {4, 5, 12, 14};
        findDifference(a1, a2);

        System.out.println();

        // no intersection between 2 arrays.
        int[] a3 = {1, 2, 3};
        int[] a4 =         {4, 5, 6};
        findDifference(a3, a4);

        System.out.println();

        // testing null array
        int[] a5 = {};
        int[] a6 = {1, 2, 3};
        findDifference(a5, a6);

        System.out.println();

        // same arrays
        int[] a7 = {1, 2, 3};
        int[] a8 = {1, 2, 3};
        findDifference(a7, a8);

        System.out.println();

        // negative integers
        int[] a9 = {-3, -2, -1};
        int[] a10 =        {-1, 1, 2 };
        findDifference(a9, a10);

        System.out.println();

        // repeating or warmup.duplicate numbers
        int[] a11 = {1, 1, 2, 2 };
        int[] a12 =        {2, 2, 3, 3 };
        findDifference(a11, a12);

        System.out.println();
        // common numbers repeat with different frequency
        int[] a13 = {1, 2, 3, 3};
        int[] a14 =        {3, 3, 3, 4, 5 };
        findDifference(a13, a14);
    }
}
