package subsequence;



/**
 * 
 * If we are allowed to buy and sell only once, then we can use "MaxDifferenceBetweenArrayIndexes". 
 * Maximum difference between two elements. Here we are allowed to buy and sell multiple times. Following is algorithm for this problem.
 * 
 * http://www.geeksforgeeks.org/stock-buy-sell/
 * 
 * Complexity:
 * ------------
 * O(n) - time.
 * space - none
 * 
 * BB:
 * ----
 * 45
 * 
 */
public class StockBuyOrSell {
    
    /*
     * check for edge cases.
     */
   public static void getMax (int[] stocks) {
       int i = -1;
       int min = 0;
        
       for (i = 0; i < stocks.length - 1; i++) {
              
           // if min has been found, then max must exist. its impossible to fund a min and not have a corresoonding max.
           if (stocks[i] < stocks[i + 1]) {
               min = stocks[i];
            
               for (i = i + 1; i < stocks.length -1; i++) {
                   if (stocks[i] > stocks[i + 1]) {
                       System.out.println("- the min is: " + min + " max is: " + stocks[i]);
                       break;
                   }
               }
               
               if (i == (stocks.length -1)) {
                   System.out.println("- the min is: " + min + " max is: " + stocks[i]);
               }
           }
       }
   }
    
    public static void main(String[] args) {
        int[] stocks1 = {10, 20, 30, 40, 1, 2, 3, 4};
        getMax (stocks1);
        
        int[] stocks2 = {10, 20, 30, 40, 1, 2, 3, 4, -1};
        getMax (stocks2);
    }
}
