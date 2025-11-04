public class HeapPractice {
    private int[] heap;
    private int size;     
    private int capacity;

    public HeapPractice(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.heap = new int[capacity];
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }

    private int leftChild(int i) {
        return 2 * i + 1;
    }

    private int rightChild(int i) {
        return 2 * i + 2;
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public void insert(int val) {
        if (size == capacity) {
            System.out.println("Heap is full!");
            return;
        }

        heap[size] = val;
        int current = size;
        size++;

        while (current > 0 && heap[current] > heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    public void printHeap() {
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        HeapPractice heap = new HeapPractice(10);

        heap.insert(20);
        heap.insert(15);
        heap.insert(30);
        heap.insert(40);
        heap.insert(10);

        System.out.print("Heap elements: ");
        heap.printHeap();

        //System.out.println("Max element: " + heap.getMax());
        //System.out.println("Extracted max: " + heap.extractMax());

        System.out.print("Heap after extraction: ");
        heap.printHeap();
    }
}