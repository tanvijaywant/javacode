/**
 * leetcode.
 */
public class ContainerWithMostWaterHistogram {


    public static int maxWaterIsHere(int[] arr) {

        int low = 0;
        int high = arr.length - 1;

        int leftMax = Integer.MIN_VALUE;
        int rightMax = Integer.MIN_VALUE;
        int result = 0;

        while (low < high) {
            if (arr[low] < arr[high]) {

                if (arr[low] > leftMax) {
                    leftMax = arr[low];
                } else {
                    result  = result + (leftMax - arr[low]);
                }
                low++;

            } else {

                if (arr[high] > rightMax) {
                    rightMax = arr[high];
                } else {
                    result = result + (rightMax - arr[high]);
                }
                high--;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {10, 5, 2, 15, 3 , 2, 11};
        System.out.println(maxWaterIsHere(arr));
    }
}
