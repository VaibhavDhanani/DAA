package lab8;

import java.util.Scanner;

public class LongestCommonSub {

    static int lcm(String s1, String s2)
    {
        int n = s1.length();
        int m = s2.length();
        int dp[][] = new int[n+1][m+1];
        for(int i=0;i<=n;i++)
        {
            for(int j=0;j<=m;j++)
            {
                if(i==0 || j==0)
                {
                    dp[i][j]=0;
                }
                else if(s1.charAt(i-1)==s2.charAt(j-1))
                {
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else
                {
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[n][m];  
    }
        public static void main(String[] args) 
        {
        Scanner s = new Scanner(System.in);
        String s1 = s.nextLine();
        String s2 = s.nextLine();

        int result = lcm(s1,s2);
        System.out.println("The length of common subsequence is " + result);
    }
}
