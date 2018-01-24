package Arrays;

/**
 * http://www.geeksforgeeks.org/replace-every-array-element-by-multiplication-of-previous-and-next/
 */
public class MultiplyPreviousAndNextIndex {

    //    Input: arr[] = {2, 3, 4, 5, 6}
    //    Output: arr[] = {6, 8, 15, 24, 30}
    public static void change(int[] arr) {
        int prev = arr[0];
        for (int i = 0; i < arr.length - 1; i++) {
            int temp = prev * arr[i + 1];
            prev = arr[i];
            arr[i] = temp;
        }
        arr[arr.length - 1] = prev * arr[arr.length - 1];

//        for (int i : arr) {
//            System.out.println("---------: " + i);
//        }
    }


    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 5, 6};
        change(arr);
    }
}
