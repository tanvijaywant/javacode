import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * FB:
 * https://www.careercup.com/question?id=5670502550994944
 * 
 * Software Design: Using static functions as its been used in Impact Interview.
 * 
 * Complexity: O ( 2 ^ n) both space and time
 * 
 * Diagram:
 * https://bitbucket.org/ameyapatil/all-images/commits/987cd13d6cf37b31d39583f21969a788413705d8
 * 
 * BB:
 * 3
 * 
 * Reference: Impact Interview
 * 
 */


/**
 * 
 * {}
 * {} {1}
 * {} {2} {1} {1,2}
 * {} {3} {1} {1,3} {2} {2,3} {1,2} {1,2,3}
 * 
 * @author ameya.patil
 *
 */
public class PowerSet {
     
    public static List<List<Integer>> computeSubsets(List<Integer> input) {

        // https://bitbucket.org/ameyapatil/all-images/commits/987cd13d6cf37b31d39583f21969a788413705d8
        List<List<Integer>> prevSubsets = new ArrayList<List<Integer>>();
        prevSubsets.add(Collections.<Integer> emptyList()); 
        
        for (int i : input) {
            
            List<List<Integer>> newSubsets = new ArrayList<>();
                       
            for (List<Integer> subset : prevSubsets) { 
                // copy directly
                newSubsets.add(subset);

                // append.
                List<Integer> two = new ArrayList<>(subset);
                two.add(i);
               
                newSubsets.add(two);
            }
            prevSubsets = newSubsets;
        }
        
        return prevSubsets;
    }
    
    public static void main(String args[]) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        
        
        List<List<Integer>> powerSet2 =  computeSubsets(arrayList);
        
        System.out.print("{");
        for (List<Integer> list : powerSet2) {
            System.out.print("{");
            for (Integer i : list) {
                System.out.print(i + ",");
            }
            System.out.print("}");
            System.out.print(",");
        }
        System.out.print("}");
    }
}
