package warmup.duplicate;

/**
 * http://discuss.leetcode.com/questions/207/remove-duplicates-from-sorted-array
 * http://stackoverflow.com/questions/1532819/algorithm-efficient-way-to-remove-duplicate-integers-from-an-array
 * http://stackoverflow.com/questions/18552420/avoiding-exceptions-by-short-circuiting?noredirect=1#comment27291627_18552420
 * http://codereview.stackexchange.com/questions/30592/code-review-request
 * 
 * Complexity: O(n)
 * 
 * Diagram:
 * https://bitbucket.org/ameyapatil/all-images/commits/a3cb6544120010dd6ddf309bed42ef1aa44f8b37
 * 
 * 
 * Eliminate duplicates: geek => gk
 * remove warmup.duplicate    : geek => gek
 * 
 * BB : 13
 *
 */
public final class RemoveDuplicateSorted {
    
    private RemoveDuplicateSorted () { }
    
//    /*
//     * NOTE - Since, input is sorted, we ignore the case of 'order NOT maintained'.
//     */
//    public static Set<Integer> orderMaintained(int[] a) {
//        if (a == null) {
//            throw new NullPointerException();
//        }
//        Set<Integer> items = new LinkedHashSet<Integer>();
//         
//        for (int i = 0; i < a.length; i++) {
//            // or you can simply do items.add all the time.
//            // or you can simply do new linkedhashset<>(Arrays.aslist(a));
//            if (!items.contains(a[i])) {
//                items.add(a[i]);
//            }
//        }
//
//        return items;
//    }
    
    /*
     * NOTE - Since, input is sorted, we ignore the case of 'order NOT maintained-same array'.
     */
    public static int orderMaintainedSameArray(int[] a) {
        if (a == null) {
            throw new NullPointerException();
        } 

        int ctr = 0;
        
        for (int i = 0; i < a.length; i++) {
            // include last element by default, if not the last element, do the check for duplication.
            if (i == a.length - 1 || a[i] != a[i + 1]) {
                a[ctr] = a[i];
                ctr++;
            }
        } 
        
        /**
         * Since collection sort does not return an array we too, will not
         * return an array.
         */
        return ctr;
    }
    
    public static void main(String[] args) {
           int[] a1 = {1, 2, 4, 4, 5, 6, 7, 7, 8};
           System.out.print("Expected: 1 2 4 5 6 7 8, Actual: ");
           for (int i : orderMaintained(a1)) {
               System.out.print(i + " ");
           }
           System.out.println();
           
           int[] a2 = {1};
           System.out.print("Expected: 1, Actual: ");
           for (int i : orderMaintained(a2)) {
               System.out.println(i + " ");
           }
           
           int[] a3 = {1, 1, 1, 1, 1};
           System.out.print("Expected: 1, Actual: ");
           for (int i : orderMaintained(a3)) {
               System.out.println(i + " ");
           }
           
           /**
            * ********************************************************
            */
           
           int[] a4 = {1, 2, 4, 4, 5, 6, 7, 7, 8};
           System.out.print("Expected: 1 2 4 5 6 7 8, Actual: ");
           int n4 = orderMaintainedSameArray(a4);
           for (int i = 0; i < n4; i++) {
               System.out.print(a4[i] + " ");
           }
           
           System.out.println();
           
           int[] a5 = {1};
           System.out.print("Expected: 1, Actual: ");
           int n5 = orderMaintainedSameArray(a5);
           for (int i = 0; i < n5; i++) {
               System.out.print(a5[i] + " ");
           }
           
           System.out.println();
           
           int[] a6 = {1, 1, 1, 1, 1};
           System.out.print("Expected: 1, Actual: ");
           int n6 = orderMaintainedSameArray(a6);
           for (int i = 0; i < n6; i++) {
               System.out.print(a6[i] + " ");
           }
    }
}
