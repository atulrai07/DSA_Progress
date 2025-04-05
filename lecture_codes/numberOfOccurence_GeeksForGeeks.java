public class numberOfOccurence_GeeksForGeeks {
    int countFreq(int[] arr, int target) {
        int first = findFirst(arr, target);
        if (first == -1) {
            return 0; // Target not found
        }
        int last = findLast(arr, target);
        return last - first + 1;
    }
    
    private int findFirst(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        int result = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == target) {
                result = mid;
                high = mid - 1; // Keep searching on the left
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return result;
    }

    private int findLast(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        int result = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == target) {
                result = mid;
                low = mid + 1; // Keep searching on the right
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        numberOfOccurence_GeeksForGeeks obj = new numberOfOccurence_GeeksForGeeks();
        int[] arr = {1, 2, 2, 2, 3, 4, 5};
        int target = 2;
        int count = obj.countFreq(arr, target);
        System.out.println("Count of " + target + " in the array: " + count);
        // Output: Count of 2 in the array: 3
    }
}
