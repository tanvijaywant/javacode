package backtracking;

/**
 * https://www.careercup.com/question?id=5741988412391424
 *
 * O(strLength ^ numberofstrings)
 */
public class FacebookShuffle {

    
    public static void shuffle(String[] strlist, int currStringIndex, int pos, char[] buff) {
        
        if (strlist.length == currStringIndex) {
            System.out.println(new String(buff));
            return;
        }
        
        String str = strlist[currStringIndex];
        
        for (int i = 0; i < str.length(); i++) {
            buff[pos] = str.charAt(i);
            shuffle(strlist, currStringIndex + 1, pos + 1, buff);
        }
    }
    
    public static void main(String[] args) {
        
        String[] strlist = {"red", "fox", "sup", "dip", "zyx"};
        char[] ch = new char[strlist.length];
        shuffle(strlist, 0, 0, ch);
        
    }
}
