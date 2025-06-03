public class BinarySearchTrace {

    public static void main(String[] args) {
        // Sorted array for binary search
        int[] arr = {2, 4, 7, 10, 13, 18, 21, 25, 30};
        int target = 13;

        System.out.println("Binary Search Trace:");
        int index = binarySearch(arr, target);

        if (index != -1) {
            System.out.println("Element " + target + " found at index " + index);
        } else {
            System.out.println("Element " + target + " not found.");
        }
    }

    static int binarySearch(int[] arr, int target) {
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Print mid value trace
            System.out.println("Checking mid index " + mid + " with value " + arr[mid]);

            if (arr[mid] == target) {
                return mid; // target found
            } else if (arr[mid] < target) {
                low = mid + 1; // search right half
            } else {
                high = mid - 1; // search left half
            }
        }

        return -1; // target not found
    }
}
