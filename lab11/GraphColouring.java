package lab11;

import java.util.Arrays;

class Graph {
    private int[][] adjMatrix;
    private int numVertices;
    private int[] x;
    private int m;

    public Graph(int numVertices) {
        this.numVertices = numVertices;
        adjMatrix = new int[numVertices][numVertices];
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                adjMatrix[i][j] = 0;
            }
        }
        x = new int[numVertices];
        for (int i = 0; i < numVertices; i++) {
            x[i] = 0;
        }
        m = 3;
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

    void next_value(int n) {
        n %= numVertices;
        do {
            x[n] = (x[n] + 1) % (m + 1);
            if (x[n] == 0)
                return;
            int i;
            for (i = 0; i < numVertices; i++) {
                if (checkEdge(i, n) && x[i] == x[n])
                    break;
            }
            if (i == numVertices)
                return;
        } while (true);
    }

    void m_colouring(int n) {
        do {
            // n %= numVertices;

            next_value(n);
            if (x[n] == 0)
                return;
            if (n == numVertices-1) {
                System.out.print("[ ");
                for (int i = 0; i < numVertices; i++) {
                    System.out.print(x[i] + " ");
                }
                System.out.print("]");
                System.out.println();
            } else
                m_colouring(n + 1);

        } while (true);
    }

    @Override
    public String toString() {
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                System.out.println(adjMatrix[i][j]);
            }
        }
        return "Graph [adjMatrix=" + Arrays.toString(adjMatrix) + ", numVertices=" + numVertices + ", x="
                + Arrays.toString(x) + ", m=" + m + "]";
    }
}

class Test {

    public static void main(String[] args) {
        Graph g = new Graph(3);
        g.addEdge(0, 1);
        g.addEdge(2, 1);
        g.addEdge(2, 0);
        g.m_colouring(0);
        // System.out.println(g);

    }

}