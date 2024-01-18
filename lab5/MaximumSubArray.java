import java.util.Scanner;

class MaximumSubArray {
    private int n;
    public int arr[];

    public MaximumSubArray(int x)
    {
        n=x;
        arr=new int[n];
    }
    public int MaxSum()
    {
        int cur=0,max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
        {
            cur+=arr[i];
            if(max < cur)
            {
                max=cur;
            }
            if(cur < 0) cur=0;
        }
        return max;
    }

    public static void main(String a[])
    {
        int n;
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the value of n ");
        n=s.nextInt();
        MaximumSubArray b1 = new MaximumSubArray(n);
        for(int i=0;i<n;i++)
        {
            b1.arr[i]=s.nextInt();
        }
        System.out.println("Maximum Sum of Subarr  is: " + b1.MaxSum());
    }
}