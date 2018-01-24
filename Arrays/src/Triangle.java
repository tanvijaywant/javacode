import java.util.Arrays;


/**
 * http://www.geeksforgeeks.org/find-number-of-triangles-possible/
 *
 */
public class Triangle {

    
    // Function to count all possible triangles with arr[]
    // elements
    public static int findNumberOfTriangles(int arr[]) {
        int n = arr.length;
        Arrays.sort(arr);
        int count = 0;

        for (int i = 0; i < n-2; i++) {
            for (int j = i + 1, k = i + 2; j < n - 1; j++) {
                /* Find the rightmost element which is smaller
                   than the sum of two fixed elements
                   The important thing to note here is, we use
                   the previous value of k. If value of arr[i] +
                   arr[j-1] was greater than arr[k], then arr[i] +
                   arr[j] must be greater than k, because the
                   array is sorted. */
                while (k < n && arr[i] + arr[j] > arr[k]) {
                    ++k;
                }
 
                count += k - j - 1;
            }
        }
        return count;
    }
 
    
    
    
}
