import java.util.Scanner;

class BinomialDp {
    private int n;
    private int k;
    private int[][] dp;

    public BinomialDp(int x, int y)
    {
        n=x;
        k=y;
        dp = new int[n+1][k+1];
    }
    public int Cofficient(int n1,int k1)
    {
        for(int i=0;i<=n;i++)
        {
            for(int j=0;j<=Math.min(i,k);j++)
            {
                if(j==i || j==0)
                    dp[i][j]=1;
                else
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-1];

            }
        }
        return dp[n1][k1];
    }

    public static void main(String a[])
    {
        int n,k;
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the value of n and k ");
        n=s.nextInt();
        k=s.nextInt();
        BinomialDp b1 = new BinomialDp(n,k);
        System.out.println("Your cofficient is: " + b1.Cofficient(n, k));
    }
}