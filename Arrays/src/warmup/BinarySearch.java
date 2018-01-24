package warmup;


/**
 * Complexity :
 * O(logn)
 * 
 * BB: 15
 * 
 * @author SERVICE-NOW\ameya.patil
 */
public class BinarySearch {

    public static int binarySearchRecursive (int[] a, int x) {
        return binarySearchRecursiveHelper(a, 0, a.length - 1, x);
    }

    /**
     * Following Arrays.java && wiki we get the index of the key.
     */
    private static int binarySearchRecursiveHelper(int[] a, int lb, int hb, int x) {
        if (lb > hb)  return -1;

        int mid  = (lb + hb) / 2;
        
        if (x == a[mid]) return mid;
        
        if (x < a[mid]) {
            return binarySearchRecursiveHelper(a, lb, mid - 1,  x);
        } else {
            return binarySearchRecursiveHelper(a, mid + 1, hb,  x);
        }
    }
    
    public static int binarySearch (int[] a, int x) {
        return binarySearchHelper(a, 0, a.length - 1, x);
    }
    
    /**
     * Following Arrays.java && wiki we get the index of the key.
     */
    private static int binarySearchHelper(int[] a, int lb, int hb, int x) {
        while (lb <= hb) {
            int mid = (lb + hb) / 2;
            
            if (x == a[mid]) return mid;
            
            if (x < a[mid]) {
                hb = mid - 1;
            } else {
                lb = mid + 1;
            }
        }
        return -1;
    }
    
    
    public static void main(String[] args) {
        // even length
        int[] even  = {0, 1, 2, 3, 4, 5};
        for (int i : even) {
            System.out.print(binarySearchRecursive (even, i) + " ");
        }
        System.out.println();
        for (int i : even) {
            System.out.print(binarySearch (even, i) + " ");
        }
        System.out.println();
        int[] odd  = {0, 1, 2, 3, 4};
        for (int i : odd) {
            System.out.print(binarySearchRecursive (odd, i) + " ");
        }
        System.out.println();
        for (int i : odd) {
            System.out.print(binarySearch (odd, i) + " ");
        }
        
        System.out.println(" \n=========== failure case ==============");
        
        System.out.println(binarySearchRecursive(even,10));
        System.out.println(binarySearch(even,10));

        System.out.println(binarySearchRecursive(odd,10));
        System.out.println(binarySearch(odd,10));
    }
}
