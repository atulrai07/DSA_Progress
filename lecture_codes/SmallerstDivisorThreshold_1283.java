public class SmallerstDivisorThreshold_1283{
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1;
        int high = 0;
        for (int num : nums) {
            high = Math.max(high, num);
        }
        while (low < high) {
            int mid = (low + high) / 2;
            if (check(nums, mid, threshold)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public boolean check(int[] nums, int divisor, int threshold) {
        long sum = 0;
        for (int num : nums) {
            sum += (num + divisor - 1) / divisor; // equivalent to Math.ceil((double)num / divisor)
            if (sum > threshold) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        SmallerstDivisorThreshold_1283 obj = new SmallerstDivisorThreshold_1283();
        int[] nums = {1, 2, 5, 9};
        int threshold = 6;
        int result = obj.smallestDivisor(nums, threshold);
        System.out.println("Smallest Divisor: " + result);
    }
}