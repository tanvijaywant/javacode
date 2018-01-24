package sum;


/**
 * http://shashank7s.blogspot.com/2011/07/find-three-numbers-in-array-which-forms.html
 * 
 * find 3 max
 * fine 2 min
 * 
 * Complexity:
 * O(n)
 * 
 * BB:
 * 42
 */
public final class MaxProductOfThreeNumbers {
    
    private MaxProductOfThreeNumbers() { }
    
    public static double maxProduct(int[] a) {
        if (a.length < 3) { throw new IllegalArgumentException("The length of array is empty."); }

        // note: max > secondmax > thirdmax
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        int thirdMax = Integer.MIN_VALUE;
        
        // note: min < secondmin
        int min = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;
        
        for (int i = 0; i < a.length ;i++) {
            if (a[i] > max) {
                thirdMax = secondMax;
                secondMax = max;
                max = a[i];
            } else if (a[i] > secondMax) {
                thirdMax = secondMax;
                secondMax = a[i];
            } else if (a[i] > thirdMax) {
                thirdMax = a[i];
            }
            
            if (a[i] < min) {
                secondMin = min;
                min = a[i];
            } else  if (a[i] < secondMin) {
                secondMin = a[i];
            }
        }
        
        double product1 = max * secondMax * thirdMax;
        double product2 = max * min * secondMin;
        
        if (product1 > product2) {
            return product1;
        } else {
            return product2;
        }
    }
    
    /**
     * - All positive.                  [1,   2,  3,  4]    ans: 4*3*2
     * - All negative.                  [-4, -3, -2, -1]    ans: 1*2*3
     * - 3 positive, 2 negative         [-3, -2, 1, 2, 3]   ans: 3* -3 * -2
     * 
     */
    public static void main(String[] args) {
        int[] a1 = {1, 2, 3, 4};
        int[] a2 = {-4, -3, -2, -1};
        int[] a3 = {-3, -2, 1, 2, 3};
        
        System.out.println(maxProduct(a1));
        System.out.println(maxProduct(a2));
        System.out.println(maxProduct(a3));
    }
}
