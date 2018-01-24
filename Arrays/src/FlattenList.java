import java.util.List;
import java.util.ArrayList;

/**
 * TODO: Need to much better understand java generics.
 * 
 * Flattens a list: eg:  < <1, 2>,   <<3, 4>, <5, 6>>  <a, b> <7, 8>>
 * The final answers should be: [1, 2, 3, 4, 5, 6, a, b, 7, 8]
 * 
 * Complexity:  O(n), n is sum of all elements in all the lists combined.
 * 
 * Reference:    
 * Code: http://rosettacode.org/wiki/Flatten_a_list#Java
 * Generic lists: https://bitbucket.org/ameyapatil/pointstonote/src/d77aaca7fd880afb4ab747d8fdc5d08a4e517bc6/src/GenericLists.java?at=master
 * 
 * Software Design: 
 * ----------------
 * 1. Although I don't like the static functions, just doing it as interviewer would be more familiar with static method.
 * 2. 'flattendlist' is not passed by the caller/client/user, as it is left to internal implementation.
 * 3. We have 2 functions - 
 *    -> non-recursive : flattenlist
 *    -> recursive : flatten.
 *    This is done, as the 'flattenlist' is passed recursively as a parameter to the flatten function.
 *    Thus we declare flattenlist in non-recursive function and, pass it as a parameter to recursive call.
 * 
 * @author SERVICE-NOW\ameya.patil
 */
public class FlattenList {

    public static List<?> flattenList (List list) {
        List flattendlist = new ArrayList();
        flatten(list, flattendlist);
        return flattendlist;
    }

    private static void flatten (List list, List flattendlist) {
        for (Object obj : list) {
            if (obj instanceof List) {
                flatten((List)obj, flattendlist);
            } else {
                flattendlist.add(obj);
            }
        }
    }

    public static void main(String args[]) {
        
        /**
         *  < <1, 2>, <"abc", "xyz">  <<1, 2>, <"abc", "xyz">> , a, 10 >
         */
        List genericList = new ArrayList();
        
        // integer list
        List<Integer> listInteger = new ArrayList<Integer>();
        listInteger.add(1);
        listInteger.add(2);
        
        // string list
        List<String> listString = new ArrayList<String>();
        listString.add("abc");
        listString.add("xyz");
        
        // nested lists.
        List nestedList = new ArrayList();
        nestedList.add(listInteger);
        nestedList.add(listString);
        
        genericList.add(listInteger);
        genericList.add(listString);
        genericList.add(nestedList);
        
        // adding an individual floating characters
        genericList.add('a');
        // adding  a number
        genericList.add(10);
       
        List flattendlist = flattenList(genericList);
        
        System.out.print("Expected 1 2 abc xyz 1 2 abc xyz a 10, Actual: ");
        for (Object o  : flattendlist) {
            System.out.print(o + " ");
        }
    }
}
