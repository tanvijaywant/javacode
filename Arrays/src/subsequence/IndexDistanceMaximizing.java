package subsequence;

/**
 * http://leetcode.com/2011/05/a-distance-maximizing-problem.html
 * http://www.geeksforgeeks.org/given-an-array-arr-find-the-maximum-j-i-such-that-arrj-arri/
 * 
 * BB:
 * 35
 * 
 * Complexity:
 * O(n)  - time
 * O(2n) - space
 * 
 */
public final class IndexDistanceMaximizing {
    
    private IndexDistanceMaximizing() {}
    
    
    public static int maxIndexDiff(int[] arr) {
        if (arr.length < 2) throw new IllegalArgumentException("Array should atleast contain 2 elements");
        
        int[] min = new int[arr.length];
        int[] max = new int[arr.length];
        
        min[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            min[i] = Math.min(min[i - 1], arr[i]);
        }
        
        max[arr.length - 1] = arr[arr.length - 1];
        for (int i = arr.length - 2; i >= 0; i--) {
            max[i] = Math.max(max[i + 1], arr[i]);
        }
        
        int i = 0;
        int j = 0;
        int maxDiff = -1;
        while (i < arr.length && j < arr.length) {
            if (min[i] <  max[j]) {
                maxDiff = Math.max(maxDiff, j - i); // i cannot construct a good example so just mugged it up.
                j++;
            } else {
                i++;
            }
        }
        return maxDiff;
    }
    
    
    
    public static void main(String[] args) {
        // 1: ascending
        
        // 2: descending
        
        // 3. exception condition 
        
        // 4. normal case.
        
        int arr[] = {9, 2, 3, 4, 5, 6, 7, 8, 18, 0};
        System.out.println(maxIndexDiff(arr));
    }
    
}


