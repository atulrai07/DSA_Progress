import java.util.Arrays;

public class QuickSortPivotAnalysis {

    static int callsFirst = 0;
    static int callsLast = 0;
    static int callsMedian = 0;

    public static void main(String[] args) {
        int[] original = {29, 10, 14, 37, 13};

        System.out.println("Original Array: " + Arrays.toString(original));

        // First element as pivot
        int[] arr1 = Arrays.copyOf(original, original.length);
        quickSortFirst(arr1, 0, arr1.length - 1);
        System.out.println("Sorted (First Pivot): " + Arrays.toString(arr1));
        System.out.println("Recursive Calls (First Pivot): " + callsFirst + "\n");

        // Last element as pivot
        int[] arr2 = Arrays.copyOf(original, original.length);
        quickSortLast(arr2, 0, arr2.length - 1);
        System.out.println("Sorted (Last Pivot): " + Arrays.toString(arr2));
        System.out.println("Recursive Calls (Last Pivot): " + callsLast + "\n");

        // Median-of-three pivot
        int[] arr3 = Arrays.copyOf(original, original.length);
        quickSortMedian(arr3, 0, arr3.length - 1);
        System.out.println("Sorted (Median Pivot): " + Arrays.toString(arr3));
        System.out.println("Recursive Calls (Median Pivot): " + callsMedian);
    }

    // ----------- Pivot: First Element -----------
    static void quickSortFirst(int[] arr, int low, int high) {
        if (low < high) {
            callsFirst++;
            int pi = partitionFirst(arr, low, high);
            quickSortFirst(arr, low, pi - 1);
            quickSortFirst(arr, pi + 1, high);
        }
    }

    static int partitionFirst(int[] arr, int low, int high) {
        int pivot = arr[low];
        int i = low + 1, j = high;
        while (i <= j) {
            while (i <= high && arr[i] <= pivot) i++;
            while (j >= low && arr[j] > pivot) j--;
            if (i < j) swap(arr, i, j);
        }
        swap(arr, low, j);
        return j;
    }

    // ----------- Pivot: Last Element -----------
    static void quickSortLast(int[] arr, int low, int high) {
        if (low < high) {
            callsLast++;
            int pi = partitionLast(arr, low, high);
            quickSortLast(arr, low, pi - 1);
            quickSortLast(arr, pi + 1, high);
        }
    }

    static int partitionLast(int[] arr, int low, int high) {
        swap(arr, low, high); // Move pivot to start
        return partitionFirst(arr, low, high);
    }

    // ----------- Pivot: Median-of-Three -----------
    static void quickSortMedian(int[] arr, int low, int high) {
        if (low < high) {
            callsMedian++;
            int pi = partitionMedian(arr, low, high);
            quickSortMedian(arr, low, pi - 1);
            quickSortMedian(arr, pi + 1, high);
        }
    }

    static int partitionMedian(int[] arr, int low, int high) {
        int mid = (low + high) / 2;
        int medianIndex = medianOfThree(arr, low, mid, high);
        swap(arr, low, medianIndex); // Move pivot to start
        return partitionFirst(arr, low, high);
    }

    static int medianOfThree(int[] arr, int a, int b, int c) {
        int x = arr[a], y = arr[b], z = arr[c];
        if ((x > y) != (x > z)) return a;
        else if ((y > x) != (y > z)) return b;
        else return c;
    }

    // ----------- Swap Helper -----------
    static void swap(int[] arr, int i, int j) {
        if (i != j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}
