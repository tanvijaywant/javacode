package warmup.setops;


/**
 * Complexity: O(n)
 * 
 * http://stackoverflow.com/questions/15058133/find-intersection-of-two-sorted-arrays-how-to-simplify-my-code
 * 
 * BB:
 * 8
 * 
 */
public class IntersectionWhenArrayIsSorted {

    public static void printIntersection(int[] a1, int[] a2) {
        
        if (a1.length == 0 || a2.length == 0) {
            return;
        }

        if (a1[a1.length -1] < a2[0] || a2[a2.length - 1] < a1[0]) {
            return;
        }
        
        // declare variables, as close to its first use as possible.
        int  i = 0;
        int  j = 0;

        while (i <  a1.length && j < a2.length) {
            if (a1[i] < a2[j]) {
                i++;
            } else if (a1[i] > a2[j]) {
                j++;
            } else {
                System.out.print(a1[i] + ",");
                i++;
                j++;
            }
        }
    }

    public static void main(String args[]) {
        // the simplest test case:
        int a1[] = {1, 2, 3, 4, 5};
        int a2[] =       {3, 4, 5};
        printIntersection(a1, a2);

        System.out.println();

        //no intersection
        int a3[] = {1, 2, 3};
        int a4[] =          {4, 5, 6};
        printIntersection(a3, a4);

        System.out.println();

        // only the tail intersects.
        int a5[] = {1, 2, 3};
        int a6[] =        {3, 4, 5};
        printIntersection(a5, a6);

        System.out.println();

        // -ve numbers
        int a7[] = {-3, -2, -1};
        int a8[] =         {-1, 0, 1};
        printIntersection(a7, a8);

        System.out.println();

        // null array
        int a9[] = {};
        int a10[] = {1, 2, 3};
        printIntersection(a9, a10);

        // repeating or warmup.duplicate numbers
        int a11[] = {1, 1, 2, 2 };
        int a12[] =       {2, 2, 3, 3 };
        printIntersection(a11, a12);

        System.out.println();
        // common numbers repeat with different frequency
        int a13[] = {1, 2, 3, 3};
        int a14[] =        {3, 3, 3, 4, 5 };
        printIntersection(a13, a14);
    }
}
