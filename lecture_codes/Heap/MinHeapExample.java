import java.util.PriorityQueue;

public class MinHeapExample {
    public static void main(String[] args) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        minHeap.add(10);
        minHeap.add(5);
        minHeap.add(20);
        minHeap.add(15);
        minHeap.add(30);

        while (!minHeap.isEmpty()) {
            System.out.println(minHeap.poll());  // Output: 5, 10, 20, 15, 30
        }
    }
}
