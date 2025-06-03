import java.util.Arrays;

public class PairOfSum {
     public static void main(String[] args) {
        int[] sortedArray = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int targetSum = 10;

        System.out.println("Array: " + Arrays.toString(sortedArray));
        System.out.println("Target Sum: " + targetSum);
        System.out.println("Unique Pairs:");

        printUniquePairs(sortedArray, targetSum);
    }

    static void printUniquePairs(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int sum = arr[left] + arr[right];

            if (sum == target) {
                System.out.println("(" + arr[left] + ", " + arr[right] + ")");
                
                // Move both pointers and skip duplicates
                int currentLeft = arr[left];
                int currentRight = arr[right];

                while (left < right && arr[left] == currentLeft)
                    left++;
                while (left < right && arr[right] == currentRight)
                    right--;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
    }
}
