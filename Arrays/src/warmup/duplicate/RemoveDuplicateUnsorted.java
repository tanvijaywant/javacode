package warmup.duplicate;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;



/**
 * http://stackoverflow.com/questions/1532819/algorithm-efficient-way-to-remove-duplicate-integers-from-an-array
 * 
 * Eliminate duplicates:
 * 
 * - Using Hashtables. // so easy that not even coding it.
 *  - Order is always maintained eg: [4 3 3 2 2 1] => [4 3 2 1] 
 * 
 * - Without using hashtables.
 *  - maintain order, its n2 eg: [4 3 3 2 2 1] => [4 3 2 1] 
 *  - dont maintain order, its nlogn eg: [4 3 3 2 2 1] => [4 3 2 1]
 * 
 * Eliminate duplicates: geek => gk
 * remove warmup.duplicate    : geek => gek
 * 
 * Diagram:
 * https://bitbucket.org/ameyapatil/all-images/commits/a3cb6544120010dd6ddf309bed42ef1aa44f8b37
 * 
 * BB: No: 14
 * 
 */
public class RemoveDuplicateUnsorted {

    private RemoveDuplicateUnsorted() { }
    
    public static Set<Integer> orderNotMaintained(int[] a) {
        Set<Integer> set = new HashSet<Integer>();
     
        for (int i = 0; i < a.length; i++) {
            if (!set.contains(a[i])) {
                set.add(a[i]);
            } 
        }
      
        return set;
    } 
    
    
    public static Set<Integer> orderMaintained(int[] a) {
        Set<Integer> set = new LinkedHashSet<Integer>();
        
        for (int i = 0; i < a.length; i++) {
            if (!set.contains(a[i])) {
                set.add(a[i]);
            } 
        }
      
        return set;
    }
    
//    // NO NEED TO DO THIS METHOD FOR UNSORTED INPUT
//    public static int orderMaintainedArray(int[] a) {
//      
//    }
//     
//    // NO NEED TO DO THIS METHOD FOR UNSORTED INPUT
//    public static int orderNotMaintainedArray(int[] a) {
//       
//    }
    
    
    public static void main(String[] args) {
          // TESTING IS TOO BASIC THUS SKIPPED.
    }
}
