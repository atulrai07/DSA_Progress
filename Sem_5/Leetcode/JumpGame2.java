package Leetcode;

public class JumpGame2 {
    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int MAX = 10001; 
        
        java.util.Arrays.fill(dp, MAX);
        dp[n - 1] = 0;

        for (int i = n - 2; i >= 0; i--) {
            int maxJump = Math.min(i + nums[i], n - 1);
            for (int j = i + 1; j <= maxJump; j++) {
                dp[i] = Math.min(dp[i], 1 + dp[j]);
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        JumpGame2 solution = new JumpGame2();
        int[] nums = {2, 3, 1, 1, 4};
        int result = solution.jump(nums);
        System.out.println("Minimum number of jumps to reach the last index: " + result);
    }
}
