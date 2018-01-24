package warmup.duplicate;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Diagram:
 * https://bitbucket.org/ameyapatil/all-images/commits/a3cb6544120010dd6ddf309bed42ef1aa44f8b37
 * 
 * 
 * BB:
 * 47
 * 
 */
public final class EliminateDupplicates {

    private EliminateDupplicates() {
        
    }
    
    private static Set<Integer> orderNotMaintained(int[] arr) {
        Set<Integer> unique = new LinkedHashSet<Integer>();
        Set<Integer> visited = new LinkedHashSet<Integer>();
        
        for (int i : arr) {  
            if (!visited.contains(i)) {
                if (!unique.contains(i)) {
                    unique.add(i);
                } else {
                    visited.add(i);
                    unique.remove(i); 
                }
            }
        }
        return unique;
    }
    
//    // NO NEED TO DO THIS METHOD FOR UNSORTED INPUT
//    private static Set<Integer> orderMaintainedArray(int[] arr) {
//        
//    }
//    
//    // NO NEED TO DO THIS METHOD FOR UNSORTED INPUT
//    private static Set<Integer> orderNotMaintainedArray(int[] arr) {
//       
//    }
    
    
    public static void main(String[] args) {
        int[] a1 = {1, 1, 2, 2, 3, 3};
        assertEquals(Collections.EMPTY_SET, orderNotMaintained(a1));
          
        int[] a2 = {1, 2, 2, 3, 4, 4, 5};
        assertEquals(new HashSet<>(Arrays.asList(1, 3, 5)), orderNotMaintained(a2));
        
    }
}
