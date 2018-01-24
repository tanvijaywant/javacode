/**
 * http://www.programcreek.com/2014/02/find-min-max-in-an-array-using-minimum-comparisons/
 * http://www.geeksforgeeks.org/maximum-and-minimum-in-an-array/
 * 
 * BB:
 * 36
 * 
 * Complexity:
  * O(n)
 *
 */
public final class MinMaxWithMinComparisons {

    private MinMaxWithMinComparisons() {}
    
    public static MaxMinPair minmax(int[] arr) {
        if (arr.length == 0) { throw new IllegalArgumentException("The array cannot be null."); }
        
        int max = 0;
        int min = -1;
        int startIndex = 0;
        if (arr.length % 2 == 0) {
            min = Math.min(arr[0], arr[1]);
            max = Math.max(arr[0], arr[1]);
            startIndex = 2;
        } else {
            // odd
            min = arr[0];
            max = arr[0];
            startIndex = 1;
        }
        
        
        /*
         * for loop constitutes n/2
         * 
         * The 3 comparisons make it : 3n/2
         * 
         */
        for (int i = startIndex; i < arr.length - 1; i = i + 2) {
            if (arr[i] < arr[i + 1]) {              // <---- 1st comparison
                min = Math.min(min, arr[i]);        // <---- 2nd comparison
                max = Math.max(max, arr[i + 1]);    // <---- 3rd comparison
            } else {
                min = Math.min(min, arr[i + 1]);
                max = Math.max(max, arr[i]);
            }
        }
        
        return new MaxMinPair(min, max);
        
    }
    
    
    
    
    public static void main(String[] args) {
        // odd length
        int[] arr1 = {5, 4, 3, 2, 1};
        MaxMinPair minMaxPair = minmax(arr1);
        System.out.println(minMaxPair.getMin() + " : " + minMaxPair.getMax());
        
        // even length
        int[] arr2 = {1, 2, 3, 4};
        minMaxPair = minmax(arr2);
        System.out.println(minMaxPair.getMin() + " : " + minMaxPair.getMax());
        
        
        // ascending
        
        
        // desceding
        
    }
    
}

