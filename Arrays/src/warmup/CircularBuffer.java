package warmup;

/**
 * http://www.mathcs.emory.edu/~cheung/Courses/171/Syllabus/8-List/array-queue2.html
 *
 */
public class CircularBuffer {
    
    int[] buffer;
    int size;
    int front;
    int rear;
    
    public CircularBuffer(int size) {
        buffer = new int[size];
        this.size = size;
        this.front = 0;
        this.rear = 0;
    }

    /**
     * 
     */
    public void add(int item) {
        if (front == ((rear + 1) % size)) {
            throw new IllegalArgumentException("Dude i am stoned.");
        }
        
        buffer[rear] = item;
        rear = (rear + 1) % size;
    }
    
    public int get() {
        if (front == rear) {
            throw new IllegalArgumentException("Dude i am stoned.");
        }
       
        int x = buffer[front];
        front = (front + 1) % (size);
        return x;
    }

    public static void main(String[] args) {
        
        
    }
}
