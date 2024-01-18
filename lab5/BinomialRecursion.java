import java.util.Scanner;

class BinomialRecursion {
    private int n;
    private int k;

    public BinomialRecursion(int x, int y)
    {
        n=x;
        k=y;
    }
    public int Cofficient(int n1,int k1)
    {
        if(k1==0 || k1 == n1)
            return 1;
        else 
            return Cofficient(n1 - 1, k1) + Cofficient(n1-1, k1-1);
    }

    public static void main(String a[])
    {
        int n,k;
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the value of n and k ");
        n=s.nextInt();
        k=s.nextInt();
        BinomialRecursion b1 = new BinomialRecursion(n,k);
        System.out.println("Your cofficient is: " + b1.Cofficient(n, k));
    }
}