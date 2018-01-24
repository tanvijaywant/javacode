

/**
 * http://www.geeksforgeeks.org/equilibrium-index-of-an-array/
 * http://codereview.stackexchange.com/questions/47114/find-the-sum-and-multiply-equilibrium
 * 
 * BB:
 * 24
 * 
 * Complexity:
 * O(n)
 */
public final class EquilibriumIndex {

    private EquilibriumIndex() {}

    /**
     * Returns index, if equilibrium is found, else returns 0.
     * If multiple equilibrium exists then, the first equilibrium is returned.
     * Note: end of array is also treated as an equilibrium.
     * 
     * Eg - 1:
     * [-7, 8, -2, 8, -7, 0]
     * has 2 equilibrium
     * a[2] = -2;
     * a[5]  = 0;
     * in such case position 2 is returned
     * 
     * Eg -2:
     * [0, -7, 8, -2, 8, -7]
     * has 2 equilibrium
     * a[0] = 0;
     * a[3]  = -2;
     * in such case position 0 is returned
     * 
     * @param a     the int array
     * @returns     the index if found, else returns -1.
     */
    public static int getSumEquilibrium(int[] a) {
        int rightSum  = 0;       // the sum of all contents
        int leftSum = 0;    // the sum which starts from the left side.

        for (int i : a) { 
            rightSum += i;
        }
       
        for (int i = 0; i < a.length; i++)  {
            rightSum -= a[i];  
            if (rightSum == leftSum) {
                return i;
            }
            leftSum += a[i]; 
        }

        return -1;
    }
  
//  TODO: post checkpoint.   
//    
//    private static int processZero (int[] a, int i) {
//        // if index i is the first element of the array.
//        if (i == 0) {
//            for (int j = i + 1; j  < a.length; j++) {
//                // eg: [0, 1, 2, 0, 5],  equilibrium is the first element.
//                if (a[j] == 0) {
//                    return 0;
//                }
//            }
//            //eg: [0, 1, 2, 3], equilibrium is the last element.
//            return a.length - 1;
//        } else {
//            // if 0 is not the first element of the array then the first element of array is smallest equilibrium
//            // eg: [1, 0, 2, 3]
//            return 0;
//        }
//    }
//    
//    
//    /**
//     * Returns index, if equilibrium is found, else returns 0.
//     * If multiple equilibrium exists then, the first equilibrium is returned.
//     * Note: end of array is also treated as an equilibrium.
//     * 
//     * Eg - 1:
//     * [0, 8, -2, 0]
//     * has 2 equilibrium
//     * a[0] =  0;
//     * a[1] =  8;
//     * a[2] = -2;
//     * in such case position 0 is returned
//     * 
//     * @param a     the int array
//     * @returns     the index if found, else returns -1.
//     */
//    public static double getMultEquilibrium(int[] a) {
//        /*
//         * double chosen to prevent int-overflow.
//         * http://programmers.stackexchange.com/questions/188721/when-do-you-use-float-and-when-do-you-use-double
//         */
//        double rightProduct1 = 1;
//        double leftProduct = 1;
//
//        for (int i = 0; i < a.length; i++) {
//            if (a[i] == 0) {
//                return processZero(a, i);
//            }
//            rightProduct1 = rightProduct1 * a[i];
//        }
//
//        for (int i = 0; i < a.length; i++) {
//            rightProduct1 = rightProduct1 / a[i];
//            if (rightProduct1 == leftProduct) return i;
//            leftProduct = leftProduct * a[i];
//        }
//
//        return -1;
//    }
//    

    public static void main(String[] args) {

//         // testing sum
//        int[] a1 =  {0, -7, 8, -2, 8, -7};
//        assertEquals(0, EquilibriumIndex.getSumEquilibrium(a1));
//        int[] a2 = {-7, 8, -2, 8, -7, 0};
//        assertEquals(2, EquilibriumIndex.getSumEquilibrium(a2));
//        int[] a3 =  {-7, 1, 5, 2, -4, 3, 0};
//        assertEquals(3, EquilibriumIndex.getSumEquilibrium(a3));
//        // edge case.
//        int[] a4 = {-7, 1, 5, 2, -4, 3, 10};
//        assertEquals(6, EquilibriumIndex.getSumEquilibrium(a4));
//        // no-equilibrioum
//        int[] a5 = {-7, 15, 5, 2, -4, 3, 10};
//        assertEquals(-1, EquilibriumIndex.getSumEquilibrium(a5));
//        int[] a6 = {10, 4, -20, 30};
//        assertEquals(1, EquilibriumIndex.getSumEquilibrium(a6));
//
//        // testing mult
//        int[] a7 = {0, 1, 2, 3, 4};
//        assertEquals(4, EquilibriumIndex.getMultEquilibrium(a7), 0);
//        int[] a8 = {0, 0, 1, 2, 3, 4};
//        assertEquals(0, EquilibriumIndex.getMultEquilibrium(a8), 0);
//        int[] a9 = {0, 0, 2, 3, 0, 4};
//        assertEquals(0, EquilibriumIndex.getMultEquilibrium(a9), 0);
//        int[] a10 = {0, 1, 2, 3, 0};
//        assertEquals(0, EquilibriumIndex.getMultEquilibrium(a10), 0);
//        int[] a11 = {1, 2, 0, 4, 5};
//        assertEquals(0, EquilibriumIndex.getMultEquilibrium(a11), 0);
//        int[] a12 = {1, 2, 4, 5, 0};
//        assertEquals(0, EquilibriumIndex.getMultEquilibrium(a12), 0);
//
//        int[] a13 = {2, 20, 5, 10, 4};
//        assertEquals(2, EquilibriumIndex.getMultEquilibrium(a13), 0);
//        int[] a14 = {2, 10, 5, 4, 5, 1};
//        assertEquals(2, EquilibriumIndex.getMultEquilibrium(a14), 0);
//
//        int[] a15 = {1, 2, 3, 4, 5};
//        assertEquals(-1, EquilibriumIndex.getMultEquilibrium(a15), 0);
//
    }
}
