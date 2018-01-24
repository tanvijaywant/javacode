

final class TripletPoints {
    
    private final int firstPoint;
    private final int secondPoint;
    private final int thirdPoint;
    
    public TripletPoints(int firstPoint, int secondPoint, int thirdPoint) {
        this.firstPoint = firstPoint;
        this.secondPoint = secondPoint;
        this.thirdPoint = thirdPoint;
    }
    
    
    public int getFirstPoint() {
        return firstPoint;
    }
    
    
    public int getSecondPoint() {
        return secondPoint;
    }
    
    public int getThirdPoint() {
        return thirdPoint;
    }
}

/**
 * http://www.geeksforgeeks.org/find-a-sorted-subsequence-of-size-3-in-linear-time/
 * 
 * BB:
 * 39
 * 
 * Complexity:
 * O(n) - time and space both
 */
public final class SortedTriplet {
    
    private SortedTriplet() { }
    
    
    public static TripletPoints increasingTriplets(int[] arr) { 
        
        if (arr.length < 3) { throw new IllegalArgumentException("Please enter array of size greater or than 3"); }
         
        int[] smaller = new int[arr.length]; // store index of previous minumum value.
        int minIndex = 0;
        smaller[0] = -1;                    
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[minIndex]) {
                smaller[i] = -1;
                minIndex = i;
            } else {
                smaller[i] = minIndex; 
            }
        }
        
        int[] greater = new int[arr.length];        // stores index of previous maximum value.
        int maxIndex = arr.length - 1;
        greater[maxIndex] = -1;
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] > arr[maxIndex]) {
                greater[i] = -1;
                maxIndex = i;
            } else {
                greater[i] = maxIndex;
            }
        }
        
        for (int i = 1; i < arr.length - 1; i++) {
            if (smaller[i] != -1 && greater[i] != -1) {
                return new TripletPoints(arr[smaller[i]], arr[i], arr[greater[i]]);
            }
        }
        
        return null;
    }
 
    
    
    public static void main(String[] args) {
        int arr[] = {12, 11, 10, 5, 6, 2, 30};
         // Output: 5, 6, 30
        TripletPoints tp = increasingTriplets(arr);
        System.out.println(tp.getFirstPoint() + ":" + tp.getSecondPoint() + ":" + tp.getThirdPoint());
        
        int arr1[] = {1, 2, 3, 4};
        // Output: 1, 2, 3 OR 1, 2, 4 OR 2, 3, 4
        tp = increasingTriplets(arr1);
        System.out.println(tp.getFirstPoint() + ":" + tp.getSecondPoint() + ":" + tp.getThirdPoint());

        int arr2[] = {4, 3, 2, 1};
        // Output: No such triplet
        tp = increasingTriplets(arr2);
        System.out.println(tp);
    }
}
