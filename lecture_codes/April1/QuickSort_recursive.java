import java.util.Arrays;

public class QuickSort_recursive {
    public static void main(String[] args) {
        int[] arr = {5, 8, 6, 7, 1, 3, 9, 4};
        quickSort(arr, 0, arr.length - 1);
        System.out.println("Sorted Array: " + Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int si, int ei) {
        if (si < ei) {
            int pivotIndex = partition(arr, si, ei);
            quickSort(arr, si, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, ei);
        }

    }

    private static int partition(int[] arr, int si, int ei) {
        int pivot = arr[ei];
        int i = si - 1;
        for (int j = si; j < ei; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[ei];
        arr[ei] = temp;
        return i + 1;
    }
    
}
