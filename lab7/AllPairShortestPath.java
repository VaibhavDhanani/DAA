package lab7;

import java.util.*;

class AllPairShorestPath {
    static class Edge {
        int source;
        int destination;
        int weight;

        public Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    static class Graph {
        int vertices;
        LinkedList<Edge> [] adjacencylist;
        int weightMatrix[][];
        Graph(int vertices) {
            weightMatrix= new int[vertices][vertices];
            this.vertices = vertices;
            adjacencylist = new LinkedList[vertices];
            for (int i = 0; i <vertices ; i++) {
                adjacencylist[i] = new LinkedList<>();
            }
            for (int[] row : weightMatrix)  
                Arrays.fill(row, Integer.MAX_VALUE - 1000); 
            for(int i=0;i<vertices;i++)
            {
                weightMatrix[i][i]=0;
            } 
        }

        public void addEgde(int source, int destination, int weight) {
            Edge edge = new Edge(source, destination, weight);
            adjacencylist[source].addFirst(edge);
            weightMatrix[source][destination]=weight; 
        }
        
        public void apspath() {
            apspathPrint();
            for(int k=0;k<vertices;k++)
            {
                for(int i=0;i<vertices;i++)
                {
                    for(int j=0;j<vertices;j++)
                    {
                        weightMatrix[i][j] = Math.min(weightMatrix[i][k] + weightMatrix[k][j],weightMatrix[i][j]);
                    }
                }
            }
            apspathPrint();
        }
        public void apspathPrint()
        {
            for(int i=0;i<vertices;i++)
            {
                for(int j=0;j<vertices;j++)
                {
                    System.out.print(weightMatrix[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
      public static void main(String[] args) {
            int vertices = 4;
            Graph graph = new Graph(vertices);
            graph.addEgde(0, 1, 3);
            graph.addEgde(0, 3, 7);
            graph.addEgde(1, 0, 8);
            graph.addEgde(1, 2, 2);
            graph.addEgde(2, 0, 5);
            graph.addEgde(2, 3, 1);
            graph.addEgde(3, 0, 2);
            graph.apspath();
            // graph.printGraph();
        }
}