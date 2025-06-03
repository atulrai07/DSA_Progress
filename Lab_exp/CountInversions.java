import java.util.Arrays;

public class CountInversions {

    public static void main(String[] args) {
        int[] arr = {2, 4, 1, 3, 5};
        System.out.println("Original Array: " + Arrays.toString(arr));

        int inversionCount = countInversions(arr);
        System.out.println("Total Inversions: " + inversionCount);
    }

    static int countInversions(int[] arr) {
        int[] temp = new int[arr.length];
        return mergeSortAndCount(arr, temp, 0, arr.length - 1);
    }

    static int mergeSortAndCount(int[] arr, int[] temp, int left, int right) {
        int mid, count = 0;
        if (left < right) {
            mid = (left + right) / 2;

            count += mergeSortAndCount(arr, temp, left, mid);
            count += mergeSortAndCount(arr, temp, mid + 1, right);
            count += mergeAndCount(arr, temp, left, mid, right);
        }
        return count;
    }

    static int mergeAndCount(int[] arr, int[] temp, int left, int mid, int right) {
        int i = left;      // left subarray
        int j = mid + 1;   // right subarray
        int k = left;      // temp array index
        int invCount = 0;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
                invCount += (mid - i + 1);  // count inversions
            }
        }

        while (i <= mid)
            temp[k++] = arr[i++];

        while (j <= right)
            temp[k++] = arr[j++];

        // Copy back to original array
        for (i = left; i <= right; i++)
            arr[i] = temp[i];

        return invCount;
    }
}
