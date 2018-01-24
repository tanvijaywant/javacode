//import static org.junit.Assert.assertEquals;

/**
 * Reference:
 * http://www.geeksforgeeks.org/majority-element/
 * http://codereview.stackexchange.com/questions/45766/voting-algorithm
 * 
 * Complexity:
 * O(n)
 * 
 * BB:
 * 23
 * 
 */
public final class VotingAlgorithm {

    // non-instantiable.
    private VotingAlgorithm() {} 

    /**
     * Function to find candidate for majority.
     * 
     * @param a     the input array
     * @return      the number occuring more than n/2 times.
     */
    private static int findElement(int[] a) {
        int maxRepeatingElementIndex = 0;
        int counter = 1;
        
        for (int i = 1; i < a.length; i++) {
            if (a[maxRepeatingElementIndex] == a[i]) {
                counter++;
            } else {
                counter--;
            }
            if (counter == 0) {
                maxRepeatingElementIndex = i;
                counter++;
            }
        }
        return a[maxRepeatingElementIndex];
    }
    
    
    private static boolean checkIfElementOccursMaximumTimes(int[] arr, int x) {
        int count = 0;
        for (int i : arr) {
            if (i == x) {
                count++;
            }
        }
        return count > arr.length/2;
    }
    
    public static int maxElementCompute(int[] a) {
        int x = findElement(a);
        return checkIfElementOccursMaximumTimes(a, x) ? x : -1;
    }
    
    
    
    public static void main(String[] args) {
//        int[] a1 = {1, 2, 3, 1, 1, 1};
//        assertEquals(1, maxElementCompute(a1));
//
//        int[] a2 = {2, 3, 1, 1, 1, 1};
//        assertEquals(1, maxElementCompute(a2));
//
//        int[] a3 = {1, 1, 1, 1, 2, 3};
//        assertEquals(1, maxElementCompute(a3));
//
//        int[] a4 = {1, 2, 1, 3, 1, 1};
//        assertEquals(1, maxElementCompute(a4));
//
//        int[] a5 = {1, 2, 3, 4, 1, 1, 1};
//        assertEquals(1, maxElementCompute(a5));
//
//        int[] a6 = {2, 3, 4, 1, 1, 1, 1};
//        assertEquals(1, maxElementCompute(a6));
//
//        int[] a7 = {1, 1, 1, 1, 2, 3, 4};
//        assertEquals(1, maxElementCompute(a7));
//
//        int[] a8 = {1, 2, 1, 3, 1, 4, 1};
//        assertEquals(1, maxElementCompute(a8));
    }
}
