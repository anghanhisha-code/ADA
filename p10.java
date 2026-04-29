public class KnapsackDP {

    // Function to solve 0/1 Knapsack
    public static int knapsack(int W, int[] wt, int[] val, int n) {

        int[][] dp = new int[n + 1][W + 1];

        // Build table dp[][] in bottom-up manner
        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= W; w++) {

                if (i == 0 || w == 0) {
                    dp[i][w] = 0;
                }
                else if (wt[i - 1] <= w) {
                    dp[i][w] = Math.max(
                            val[i - 1] + dp[i - 1][w - wt[i - 1]], // include item
                            dp[i - 1][w] // exclude item
                    );
                }
                else {
                    dp[i][w] = dp[i - 1][w]; // cannot include
                }
            }
        }

        return dp[n][W];
    }

    public static void main(String[] args) {

        int[] wt = {1, 3, 4, 5};
        int[] val = {1, 4, 5, 7};
        int W = 7;
        int n = wt.length;

        int maxValue = knapsack(W, wt, val, n);

        System.out.println("Maximum value in Knapsack = " + maxValue);
    }
}
