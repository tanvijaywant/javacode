package subsequence;


/**
 * Reference:
 * http://www.geeksforgeeks.org/maximum-difference-between-two-elements/
 * 
 * FB interview question:
 * https://www.careercup.com/question?id=6207499378098176
 * 
 * Maximum difference between two elements such that larger element appears after the smaller number - 
 * stock buy and sell only once.
 * 
 * BB:
 * 34
 * 
 * Complexity:
 * O(n)
 */
public final class MaxDifferenceBetweenArrayIndexes {
    
    private MaxDifferenceBetweenArrayIndexes()  {}
    
    public static int getMaxDiff(int[] arr) { 
        if (arr.length < 2) {
            throw new IllegalArgumentException("Not possible!");
        }
        
        int maxDiff = Integer.MIN_VALUE; // in case of stocks: maxDiff = 0
        
        int minVal = arr[0];
//        int currBuyDay = 0;
//        int buyDay = 0;
//        int sellDay = 0;

        for (int i =  1; i < arr.length; i++) {
            if ((arr[i] - minVal) > maxDiff) {
                maxDiff = arr[i] - minVal;
//                buyDay = currBuyDay;
//                sellDay = i;
            
            } 
            if (arr[i] < minVal) {
                minVal = arr[i];
//                currBuyDay = i; 
            }
        }
        
//        System.out.println("startDay: " + buyDay + " end Day: " + sellDay);
        
        return maxDiff;
    }
    
    
    public static void main (String args[]) {
        int[] arr1 = {2, 3, 10, 6, 4, 8, 1};
        int[] arr2 = { 7, 9, 5, 6, 30, 2};
       
        System.out.println(getMaxDiff(arr1)); // should be 8
        System.out.println(getMaxDiff(arr2)); // should be 25
    }    
}
