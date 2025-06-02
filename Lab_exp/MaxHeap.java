import java.util.Arrays;

public class MaxHeap {
    public static void main(String[] args) {
        int[] array = {10, 40, 20, 5, 60, 15, 25};
        System.out.println("Original Array: " + Arrays.toString(array));
        buildMaxHeap(array);
        System.out.println("Max-Heap Array: " + Arrays.toString(array));
        displayHeap(array);
    }

    static void buildMaxHeap(int[] arr) {
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapifyMax(arr, n, i);
        }
    }

    static void heapifyMax(int[] arr, int n, int i) {
        int largest = i;
        int left = 2*i + 1;
        int right = 2*i + 2;

        if (left < n && arr[left] > arr[largest])
            largest = left;

        if (right < n && arr[right] > arr[largest])
            largest = right;

        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            heapifyMax(arr, n, largest);
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
