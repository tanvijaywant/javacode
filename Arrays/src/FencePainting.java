/**
 * https://www.geeksforgeeks.org/painting-fence-algorithm/
 */
public class FencePainting {

    // Returns count of ways to color n posts
    // using k colors
    public static long countWays(int n, int k)
    {
        // There are k ways to color first post
        long total = k;

        // There are 0 ways for single post to
        // violate (same color_ and k ways to
        // not violate (different color)
        long same = 0, diff = k;

        // Fill for 2 posts onwards
        for (int i = 2; i <= n; i++)
        {
            // Current same is same as previous diff
            same = diff;

            // We always have k-1 choices for next post
            diff = total * (k-1);

            // Total choices till i.
            total = (same + diff);
        }

        return total;
    }


    public static void main(String[] args) {
        int n = 3, k = 2;
        System.out.println(countWays(n, k));

    }
}
