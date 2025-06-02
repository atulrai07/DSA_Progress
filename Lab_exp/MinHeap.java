import java.util.Arrays;

public class MinHeap {
     public static void main(String[] args) {
        int[] array = {10, 40, 20, 5, 60, 15, 25};
        System.out.println("Original Array: " + Arrays.toString(array));
        buildMinHeap(array);
        System.out.println("Min-Heap Array: " + Arrays.toString(array));
        displayHeap(array);
    }

    static void buildMinHeap(int[] arr) {
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapifyMin(arr, n, i);
        }
    }

    static void heapifyMin(int[] arr, int n, int i) {
        int smallest = i;
        int left = 2*i + 1;
        int right = 2*i + 2;

        if (left < n && arr[left] < arr[smallest])
            smallest = left;

        if (right < n && arr[right] < arr[smallest])
            smallest = right;

        if (smallest != i) {
            int temp = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = temp;

            heapifyMin(arr, n, smallest);
        }
    }

    static void displayHeap(int[] arr) {
        int level = 0;
        int i = 0;
        int n = arr.length;

        while (i < n) {
            int count = (int)Math.pow(2, level);
            for (int j = 0; j < count && i < n; j++) {
                System.out.print(arr[i++] + " ");
            }
            System.out.println();
            level++;
        }
    }
}
