package subsequence;

/**
 * FB:
 * https://www.careercup.com/question?id=5681862682869760
 * 
 * Complexity:
 * O(n)
 * 
 */
public class SequenceSum {

    public static boolean containsSubarray(int[] numbers, int target) {
        //input numbers is all positive
        if(target < 0) return false;
        if(target == 0) return true;
        
        int startIndex = 0;
        int runningSum = 0;
        
        for(int i = 0; i < numbers.length; i++) {
          runningSum += numbers[i];
          
          while(runningSum > target && startIndex < i){
            runningSum -= numbers[startIndex];
            startIndex ++;
          }
          
          if(runningSum == target){
            return true;
          }
        }
        
        return false;
      }
      
      public static void main(String[] args) {
        int[] numbers = new int[]{1, 1, 3, 5, 7, 9};
        int target = 8;
        
        System.out.println( containsSubarray(numbers, target) );
      }
    
}
