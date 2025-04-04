public class firstAndLastIndexInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int first = findFirst(nums, target);
        int last = findLast(nums, target);
        return new int[]{first, last};
    }

    private int findFirst(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        int result = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                result = mid;
                high = mid - 1; // Keep searching on the left
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return result;
    }

    private int findLast(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        int result = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                result = mid;
                low = mid + 1; // Keep searching on the right
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        firstAndLastIndexInSortedArray obj = new firstAndLastIndexInSortedArray();
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;

        int[] result = obj.searchRange(nums, target);
        System.out.println("First and Last Index of target " + target + ": [" + result[0] + ", " + result[1] + "]");
    }
}