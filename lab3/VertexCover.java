import java.util.HashSet;

class Graph {
    private int[][] adjMatrix;
    private int numVertices;

    public Graph(int numVertices) {
        this.numVertices = numVertices;
        adjMatrix = new int[numVertices][numVertices];
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                adjMatrix[i][j] = 0;
            }
        }
    }

    public void addEdge(int i, int j) {
        adjMatrix[i][j] = 1;
        adjMatrix[j][i] = 1;
    }

    public void removeEdge(int i, int j) {
        adjMatrix[i][j] = 0;
        adjMatrix[j][i] = 0;
    }

    public boolean checkEdge(int i, int j) {
        return adjMatrix[i][j] == 1;
    }

    public int[][] getAdjMatrix() {
        return adjMatrix;
    }

    public int getNumVertices() {
        return numVertices;
    }
}

public class VertexCover {
    public static void main(String[] args) {
        int n = 9;
        Graph g = new Graph(n);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 4);
        g.addEdge(4, 3);
        g.addEdge(4, 5);
        g.addEdge(5, 6);
        g.addEdge(6, 7);
        g.addEdge(7, 8);
        g.addEdge(4, 8);
        g.addEdge(5, 8);
        g.addEdge(6, 8);

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (g.checkEdge(i, j)) {
                    arr[i]++;
                }
            }
        }

        HashSet<Integer> v = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int maxEle = getMax(arr, n);
            if (maxEle != -1) {
                v.add(maxEle);
                for (int j = 0; j < n; j++) {
                    if (g.checkEdge(maxEle, j)) {
                        arr[j]--;
                    }
                }
            }
        }

        for (int i : v) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static int getMax(int[] arr, int n) {
        int temp = 0;
        int ind = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] > temp) {
                temp = arr[i];
                ind = i;
            }
        }
        arr[ind] = 0;
        return ind;
    }
}
