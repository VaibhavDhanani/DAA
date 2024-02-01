package lab8;

import java.util.Scanner;

class MCM {

    public static int solve(int n, int[] dim) {
        int dp[][] = new int[n + 1][n + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                if (i == 0 || j == 0 || i == j)
                    dp[i][j] = 0;
                else
                    dp[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int l = 2; l <= n; l++) {
            for (int i = 1; i <= n - l + 1; i++) {
                int j = i + l - 1;
                for (int k = i; k < j; k++) {
                    int temp = dp[i][k] + dp[k + 1][j] + dim[i - 1] * dim[k] * dim[j];
                    if (dp[i][j] > temp) {
                        dp[i][j] = temp;
                    }
                }
            }
        }
        return dp[1][n];
    }

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        System.out.println("Enter the number of matrix");
        int n = s.nextInt();
        int[] dim = new int[n + 1];
        System.out.println("Enter the dimensions: ");
        for (int i = 0; i <= n; i++) {
            dim[i] = s.nextInt();
        }
        int result = solve(n, dim);
        System.out.println("Total mul: " + result);
        s.close();

    }
}