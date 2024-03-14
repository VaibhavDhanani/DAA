package lab12;

public class NQueen {
    private int[] x;
    private int n;

    public NQueen(int n) {
        this.n = n;
        x = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = 0;
        }
    }

    public void printSolution() {
        for (int i = 0; i < n; i++) {
            System.out.print((x[i]+1) + " ");
        }
        System.out.println();
    }

    public void nQueen(int k) {
        for (int i = 0; i < n; i++) {
            if (place(k,i)) {
                if (k == n - 1) {
                    printSolution();
                    return;
                } else {
                    nQueen(k + 1);
                }
            }
        }
    }

    public boolean place(int k,int j) {
        for (int i = 0; i < k; i++) { 
            if (x[i] == j || Math.abs(x[i] - j) == Math.abs(i - k)) {
                return false;
            }
        }
        x[k]=j;
        return true;
    }

    public static void main(String[] args) {
        NQueen nQueen = new NQueen(4);
        nQueen.nQueen(0);
    }
}
