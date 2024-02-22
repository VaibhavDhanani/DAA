package lab9_10;

import java.util.Arrays;
import java.util.List;

public class JCBB {
    int a,k;
    private Boolean[] completed;
    private int[][] mat;

    @SuppressWarnings("removal")
    public JCBB(int[][] mat) {
        this.mat = mat;
        a = mat.length;
        k=0;
        completed = new Boolean[a];
        Arrays.fill(completed, false);
    }

    void tranpose()
    {
        for(int i=0;i<a;i++)
        {
            for(int j=0;j<a;j++)
            {
                mat[i][j] = mat[j][i];
            }
        }
        Arrays.fill(completed, false);
    }

    int cost() {
        List<Integer> list = new List();
        for(int i=0;i<a-1;i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < a; j++) {
                if (min > mat[i+1][j] && completed[j] == false) {
                    min = mat[i+1][j];
                    k = j;
                }
            }
        } 
        return 0;
    }

    public static void main(String args[]) {
        int[][] arr = { { 5, 8, 1, 8 },{ 6, 4, 3, 7 }, { 9, 2, 7, 8 }, { 7, 6, 9, 4 } };
        JCBB j = new JCBB(arr);
        int first = j.cost(0);
        System.out.println(first);
        j.tranpose();
        int second = j.cost(0);
        System.out.println(second);
        System.out.println("Final is: " + Math.min(first,second));
    }
}
