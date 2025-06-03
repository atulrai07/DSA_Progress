import java.util.Random;

public class QuickSelectKthSmallest {

    public static void main(String[] args) {
        int[] arr = {7, 10, 4, 3, 20, 15};
        int k = 3;  // Find the 3rd smallest element

        int kthSmallest = quickSelect(arr, 0, arr.length - 1, k - 1);
        System.out.println("The " + k + "rd smallest element is: " + kthSmallest);
    }

    static int quickSelect(int[] arr, int low, int high, int k) {
        if (low == high)
            return arr[low];

        int pivotIndex = partition(arr, low, high);

        if (k == pivotIndex)
            return arr[k];
        else if (k < pivotIndex)
            return quickSelect(arr, low, pivotIndex - 1, k);
        else
            return quickSelect(arr, pivotIndex + 1, high, k);
    }

    static int partition(int[] arr, int low, int high) {
        int pivotIndex = new Random().nextInt(high - low + 1) + low;
        int pivotValue = arr[pivotIndex];
        swap(arr, pivotIndex, high);  // Move pivot to end

        int storeIndex = low;
        for (int i = low; i < high; i++) {
            if (arr[i] < pivotValue) {
                swap(arr, i, storeIndex);
                storeIndex++;
            }
        }

        swap(arr, storeIndex, high);  // Move pivot to its final place
        return storeIndex;
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
