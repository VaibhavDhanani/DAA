class FiboDp{

    private int n;
    private int []dp;

    public FiboDp(int n)
    {
        this.n=n;
        this.dp=new int[n+1];
        dp[0]=0;
        dp[1]=1;
        for(int i=2;i<=n;i++)
        {
            dp[i]=dp[i-1]+dp[i-2];
        }
    }
    public int solve(int n)
    {
        return dp[n];
    }

    public static void main(String a[])
    {
        FiboDp f1 = new FiboDp(10000000);
        System.out.println("10th number: " + f1.solve(10));
        System.out.println("20th number: " + f1.solve(20));
    }
}