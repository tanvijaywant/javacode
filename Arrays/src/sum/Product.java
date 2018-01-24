package sum;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * http://stackoverflow.com/questions/3757393/given-a-number-p-find-two-elements-in-array-whose-product-p
 *
 * BB:
 * 31
 * 
 * Complexity:
 * O(n) 
 * 
 */
public final class Product {

    private Product() { }

    /**
     * The input array is sorted
     * 
     * NOTE NOTE NOTE:
     * This method returns "ALL" pairs only iff, all numbers are positive.
     * int[] a = {-2, -3, 0, 1, 2, 3, 6};
     * for such an input, we do not have 
     * 
     */
    public static List<ProductFactors> productSorted(int[] a, int product) {
        if (a.length < 2) throw new IllegalArgumentException("The array size should not be less than 2");
        
        final List<ProductFactors> productFactors = new ArrayList<>();
        
        int i = 0;
        int j = a.length - 1;
        
        while (i < j) {
            int currProduct = a[i] * a[j];
            
            if (currProduct < product) {
                i++;
            } else if (currProduct > product) {
                j--;
            } else {
                productFactors.add(new ProductFactors(a[i], a[j]));
                i++;
                j--;
            }
        }
        
        return productFactors;
    }
    

    
    public static void main(String[] args) {
        /**
         * - negative values
         * - 0
         */
        int[] a = {-2, -3, 0, 1, 2, 3, 6};
        
//        for (ProductFactors pf : Product.product(a, 6)) {
//            System.out.println(pf.getA() +  "."  +  pf.getB());
//        }
        
        System.out.println("-------------------");

        // product sorted does not work for negative numbers.
        for (ProductFactors pf : Product.productSorted(a, 6)) {
            System.out.println(pf.getA() +  "."  +  pf.getB() + ":");
        }
    }
}



