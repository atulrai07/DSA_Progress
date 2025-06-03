import java.util.Arrays;

public class HeapSortStepByStep {

    public static void main(String[] args) {
        int[] array = {15, 3, 17, 10, 84, 19, 6, 22, 9};

        System.out.println("Original Array: " + Arrays.toString(array));

        // Step 1: Build Max-Heap
        buildMaxHeap(array);
        System.out.println("After building Max-Heap: " + Arrays.toString(array));

        // Step 2: Perform Heap Sort
        heapSort(array);
        System.out.println("Sorted Array (Ascending): " + Arrays.toString(array));
    }

    static void buildMaxHeap(int[] arr) {
        int n = arr.length;
        System.out.println("\nBuilding Max-Heap:");
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
            System.out.println("Heap after heapify at index " + i + ": " + Arrays.toString(arr));
        }
    }

    static void heapSort(int[] arr) {
        int n = arr.length;

        for (int i = n - 1; i >= 1; i--) {
            // Swap max element (root) with last element
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            System.out.println("\nAfter swapping root with index " + i + ": " + Arrays.toString(arr));

            // Heapify root to rebuild heap
            heapify(arr, i, 0);
            System.out.println("Heap after heapify with size " + i + ": " + Arrays.toString(arr));
        }
    }

    static void heapify(int[] arr, int size, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < size && arr[left] > arr[largest])
            largest = left;

        if (right < size && arr[right] > arr[largest])
            largest = right;

        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            heapify(arr, size, largest);
        }
    }
}
