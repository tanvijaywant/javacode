package subsequence;


/**
 * http://www.geeksforgeeks.org/find-the-minimum-distance-between-two-numbers/
 * 
 * 
 * Complexity:
 * O(n)
 * 
 * BB:
 * 33
 *
 */
public final class DistanceBetween {

    private DistanceBetween() {
        // TODO Auto-generated constructor stub
    }

    /*
     * http://www.geeksforgeeks.org/find-the-minimum-distance-between-two-numbers/
     */
    public static int minDistance(int[] arr, int x, int y) {
        int i = 0;
        int min_dist = Integer.MAX_VALUE;
        int prev = 0;
      
        // Find the first occurence of any of the two numbers (x or y)
        // and store the index of this occurence in prev
        for (i = 0; i < arr.length; i++) {
          if (arr[i] == x || arr[i] == y) {
            prev = i;
            break;
          }
        }
      
        // Traverse after the first occurence
        i++;
        for ( ; i < arr.length; i++) {
    
            if (arr[i] == x || arr[i] == y) {

                if (arr[prev] != arr[i]) {
                   // If the current element matches with any of the two then
                   // check if current element and prev element are different
                   // Also check if this value is smaller than minimm distance so far
                   if ((i - prev) < min_dist) {
                      min_dist = i - prev;
                   }
                }
                
               prev = i;
           }
        }
      
        return min_dist;
    }
    
    


    public static void main(String[] args) {
        int[] a1 = {1, 2};
        System.out.println(minDistance(a1, 1, 2)); // returns 1
        
        int[] a2 = {3, 4, 5};
        System.out.println(minDistance(a2, 3, 5)); // returns 2
     
        int[] a3 = {3, 5, 4, 2, 6, 5, 6, 6, 5, 4, 8, 3};
        System.out.println(minDistance(a3, 3, 6)); // returns 4
        
        int[] a4 = {2, 5, 3, 5, 4, 4, 2, 3};
        System.out.println(minDistance(a4, 3, 2)); // returns 1
    }
}
