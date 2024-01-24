package lab6;

// import java.util.Scanner;

class MakingChange {

    static public int MakingChangeofCoin(int [] deno, int amount)
    {
        int size = deno.length;
        int dp[][] = new int[size][amount+1];
        for(int j=0;j<=amount;j++)
        {
            if(j%deno[0]==0)
            {
                dp[0][j]=j/deno[0];
            }
            else{
                dp[0][j]=Integer.MAX_VALUE;
            }
        }
        for(int i=1;i<size;i++)
        {
            for(int j=1;j<=amount;j++)
            {
                if(j-deno[i] < 0)
                    dp[i][j]=dp[i-1][j];
                else
                    dp[i][j]=Math.min(1 + dp[i][j-deno[i]], dp[i-1][j]);
            }
        }
        int i=size-1;
        int j=amount;
        while(i>1)
        {
            if(dp[i][j]==dp[i-1][j])
                i--;
            else {
                System.out.println(deno[i]);
                j=j-deno[i];
            }
        }
        return dp[size-1][amount];
    }
    public static void main(String[] args) {
        // System.out.println("Enter the amount");
        // Scanner s = new Scanner(System.in);
        // int amount= s.nextInt();
        int amount=8;
        // System.out.println("Enter the denomination size");
        // int size = s.nextInt();
        int size=3;
        int deno[] = new int[size];
        // for(int i=0;i<size;i++)
        // {
        //     deno[i]=s.nextInt();
        // }
        deno[0]=1;deno[1]=4;deno[2]=6;
        int noofCoine=MakingChangeofCoin(deno,amount);
        System.out.println("the number of coins is: " + noofCoine);
        // s.close();

    }
}