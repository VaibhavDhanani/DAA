package lab7;

import java.util.*;

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

public class DepthFirstSearch {
    
    static public void dfsSearch(int s,int n, Graph g,boolean visited[])
    {
        visited[s]=true;
        System.out.print(s + " ");
        for (int i=0;i<n;i++) {
            if(g.checkEdge(s, i) && visited[i]==false)
            {
                dfsSearch(i, n, g, visited);
            }
        }
    }

    static public void DFS(int n,Graph g) 
    {
        System.out.println("DFS Serach: ");
        boolean visited[] = new boolean[n+1];
        Arrays.fill(visited, false);
        dfsSearch(0,n,g,visited);
        System.out.println();
    }
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

        DFS(n,g);
        
    }
}
