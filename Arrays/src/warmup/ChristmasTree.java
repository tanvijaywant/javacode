

/**
 * 
 * BB:
 * 32
 * 
 * Complexity:
 * O(m*n)
 * 
 * 
 *
 */
public final class ChristmasTree {
    
    private ChristmasTree() {}
    
    
    public static void christmasTree(int height, int width) {
        
        if (height <= 0 || width <= 0) {
            throw new IllegalArgumentException();
        }
        
        
        int center = width/2;
        
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if ((center -i) <= j && j <= (center + i)) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
    
    
    
    
    public static void main(String[] args) {
        christmasTree(3, 5);  // perfect print.
        System.out.println();
        christmasTree(10, 5); // height is much greater then width
        System.out.println();
        christmasTree(3, 25); //  height much lesser than width
    }
}
