package lab6;

public class Knapsack {

    public static int knapsackdp(int[] weights, int[] values, int capacity) {
        int n = weights.length;
        int[][] dp = new int[n + 1][capacity + 1];
        for (int i = 1; i <= n; i++) {
            for (int w = 0; w <= capacity; w++) {
                if (weights[i - 1] <= w) {
                    dp[i][w] = Math.max(dp[i - 1][w], values[i - 1] + dp[i - 1][w - weights[i - 1]]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        return dp[n][capacity];
    }

    public static void main(String[] args) {
        int[] weights = {5, 4, 3, 2};
        int[] values = {6, 5, 4, 3};
        int capacity = 5;

        int maxValue = knapsackdp(weights, values, capacity);
        System.out.println("Maximum value: " + maxValue);
    }
}

