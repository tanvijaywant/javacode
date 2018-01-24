
import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;


/**
 * How will you merge two sorted arrays. The first array has enough empty spaces to accomodate the second array.
 * 
 * Reference:
 * http://discuss.leetcode.com/questions/263/merge-sorted-array
 * http://codereview.stackexchange.com/questions/33243/merge-2-arrays-when-one-is-larger-and-can-accomodate-smaller
 * http://www.geeksforgeeks.org/merge-one-array-of-size-n-into-another-one-of-size-mn/
 * 
 * 
 * Complexity:
 * O (n) where n is the size of the biggest array. 
 * 
 * BB: 10
 * 
 */
public final class MergeArrays {
    
    private MergeArrays() {}
    
    public static void mergeSortedArrays(Integer[] big, Integer[] small) {
        if (big.length < small.length) {
            throw new IllegalArgumentException("This is bad length");
        }
        
        int limit = big.length - small.length -1; 
        mergeSortedArrays(big, limit, small);
    }
    
    // bigarry: [1, 3, -, - ]  small array:[2, 4] => [1, 2, 3, 4]
    private static void mergeSortedArrays(Integer[] big, int limit, Integer[] small) {
        int limitIndex = limit;
        int bigIndex = big.length - 1;
        int smallIndex = small.length - 1; 
        
        while (smallIndex >= 0) {
            /*
             * limitIndex < 0 can occur in once such scenario's in which the big array 
             * always had 'all elements' bigger than 'all elements' in the small array.
             */
            // for merge sort: if (pos2 > high || pos1 <= mid && a[pos1] <= a[pos2]) 
            if (limitIndex < 0 || big[limitIndex] <= small[smallIndex]) {
                big[bigIndex--] = small[smallIndex--];
            } else {
                big[bigIndex--] = big[limitIndex--];
            }
        }
    }
    
    
    public static void main(String args[]) {
        
        // endofA > small size 
        Integer[] big1 = {2, 4, 6, null, null}; 
        Integer[] small1 = {3, 5};
        Integer[] expected1 = {2, 3, 4, 5, 6};
        mergeSortedArrays(big1, small1);
        assertArrayEquals(big1, expected1);
        
        // endofa < smallsize
        Integer[] big2 = {2, 4, null, null, null}; 
        Integer[] small2 = {3, 5, 7};
        Integer[] expected2 = {2, 3, 4, 5, 7};
        mergeSortedArrays(big2, small2);
        assertArrayEquals(big2, expected2);
        
        // small constains the small elem +  endofA > small size 
        Integer[] big3 = {2, 4, 6, null, null}; 
        Integer[] small3 = {1, 3};
        Integer[] expected3 = {1, 2, 3, 4, 6};
        mergeSortedArrays(big3, small3);
        assertArrayEquals(big3, expected3);
        
        // small constains the small elem +  endofA < small size 
        Integer[] big4 = {2, 4, null, null, null}; 
        Integer[] small4 = {1, 3, 5};
        Integer[] expected4 = {1, 2, 3, 4, 5};
        mergeSortedArrays(big4, small4);
        assertArrayEquals(big4, expected4);
        
        // A is empty:
        Integer[] big5 = {null, null, null}; 
        Integer[] small5 = {1, 3, 5};
        Integer[] expected5 = {1, 3, 5};
        mergeSortedArrays(big5, small5);
        assertArrayEquals(big5, expected5);
    }
}
