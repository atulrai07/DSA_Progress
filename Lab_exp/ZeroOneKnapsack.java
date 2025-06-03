public class ZeroOneKnapsack {

    public static void main(String[] args) {
        // Test case:
        int[] weights = {0, 10, 20, 30}; // 0th index unused for clarity
        int[] values = {0, 60, 100, 120}; // corresponding values
        int n = weights.length - 1; // number of items
        int W = 50; // capacity of knapsack

        int[][] dp = new int[n + 1][W + 1];

        // Fill the DP table
        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= W; w++) {
                if (weights[i] <= w) {
                    dp[i][w] = Math.max(
                        values[i] + dp[i - 1][w - weights[i]],
                        dp[i - 1][w]
                    );
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        // Print the DP table
        System.out.println("DP Table:");
        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= W; w++) {
                System.out.printf("%4d", dp[i][w]);
            }
            System.out.println();
        }

        System.out.println("\nMaximum Profit: " + dp[n][W]);
    }
}
