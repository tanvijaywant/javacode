package sum;

/**
 * https://www.careercup.com/question?id=5727804001878016
 *
 */
public class PairKDiff {

    
    public static void kDiff(int[] a, int k) {
        
        for (int i = 0, j = 1; j < a.length;) {
            
            if ((a[j] - a[i]) == k) {
                System.out.println(a[i] + "," + a[j]);
                i++;
                j++;
            } else if ((a[j]  - a[i]) > k) {
                i++;
            } else {
                j++;
            }
        }
    }
    
    
    public static void main(String[] args) {
      //  int[] arr = {100, 200, 202};
        
        int[] arr = {1, 2, 3, 5, 6, 8, 9, 11, 12, 13};
        kDiff(arr, 2);
    }
}
