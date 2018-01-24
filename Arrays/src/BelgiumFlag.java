

/**
 * https://www.careercup.com/question?id=18824667
 *
 */
public class BelgiumFlag {
    
    private static void swap(int[] a, int lb, int hb) {
        int temp = a[lb];
        a[lb] = a[hb];
        a[hb] = temp;
    }
        
    public static void belgianFlagProblem(int[] a) {
        int low = 0;
        int mid = 0;
        int high = a.length - 1;
        int temp = 0;
        
        while (mid < high) {
            
            switch (a[mid]) {
                
            			// 0 1 2 1 0 1 
                case 0: swap(a, low++, mid++);
                        break;
                        
                      // 1 0 1 2 1 0 1
                      // 0 1 1 1 {0} 2 
                case 1: mid++;
                        break;
                    
                     // 0 1 {1} 1 {0} 2 
                case 2: swap(a, mid, high--);
            }
        }
    }
    
    public static void main(String[] args) {
        int[] a = {0, 1, 2, 0, 1, 2, 0, 1, 2};
        belgianFlagProblem(a);
        for (int i : a) {
            System.out.print(i + "");
        }
    }
    

}
