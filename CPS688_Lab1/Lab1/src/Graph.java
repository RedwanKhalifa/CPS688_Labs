//Author Redwan Khalifa 501------
import java.util.*;

public class Graph {

    int num = 0;
    int edges;
    int vertices;
    int[][] adjacencyList;

    public Graph(int n, int e) { //New graph based on inputted data

        adjacencyList = new int[e][2];
        edges = e;
        vertices = n;
    }

    public void addEdge(int a, int b) { //Adding edge

        adjacencyList [num][0] = a;
        adjacencyList [num][1] = b;
        System.out.print(adjacencyList[num][0]);
        System.out.println(adjacencyList[num][1]);
        num++;
    }

    public int degreeVertex(int a) { //Finding the degree of a vertex

        int vertexCount = 0;

        for (int i = 0; i < edges; i++) {
            for (int j = 0; j < 2; j++) {
                if (adjacencyList[i][0] == a || adjacencyList[i][1] == a) { //Assuming self loops count as 2 edges
                    vertexCount++;
                }
            }
        }

        return vertexCount;
    }

    public int printAdjVertices(int a) { //Finding adjacent vertices

        int totalAdjVert = 0;

        for (int i = 0; i < edges; i++) {
            if (adjacencyList [i][0] == a && adjacencyList[i][1] == a) {
                System.out.print(adjacencyList [i][0]);
                totalAdjVert++;
            } 
            else if (adjacencyList [i][0] == a) {
                System.out.print(" " + adjacencyList [i][1]);
                totalAdjVert++;
            }
            else if (adjacencyList [i][1] == a) {
                System.out.print(" " + adjacencyList [i][0]);
                totalAdjVert++;
            }
        }
        System.out.println();
        System.out.print("Total Number of Adjacent vertices: ");
        return totalAdjVert;
    }

    public void breadthFirstSearch(int start) { //Using breadth-first search algorithum 
        boolean[] visited = new boolean[vertices];
        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.add(start);

        System.out.print("\nBreadth First Search (BFS): ");
        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            System.out.print(vertex + " ");

            for (int i = 0; i < edges; i++) {
                int neighbor = -1;
                if (adjacencyList[i][0] == vertex && !visited[adjacencyList[i][1]]) {
                    neighbor = adjacencyList[i][1];
                } else if (adjacencyList[i][1] == vertex && !visited[adjacencyList[i][0]]) {
                    neighbor = adjacencyList[i][0];
                }

                if (neighbor != -1 && !visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
        System.out.println();
    }

    public void depthFirstSearch(int start) {

        boolean[] visited = new boolean[vertices];
        System.out.print("\nDepth First Search (DFS): ");
        dfsUtil(start, visited);
        System.out.println();
    }

    public void dfsUtil(int vertex, boolean[] visited) {

        visited[vertex] = true;
        System.out.print(vertex + " ");

        for (int i = 0; i < edges; i++) {
            int neighbor = -1;
            if (adjacencyList[i][0] == vertex && !visited[adjacencyList[i][1]]) {
                neighbor = adjacencyList[i][1];
            } else if (adjacencyList[i][1] == vertex && !visited[adjacencyList[i][0]]) {
                neighbor = adjacencyList[i][0];
            }

            if (neighbor != -1 && !visited[neighbor]) {
                dfsUtil(neighbor, visited);
            }
        }
    }

    public static void main(String[] args) throws Exception {

        Graph example = new Graph(6, 6); //Creating new graph with vertices and edges

        example.addEdge(0, 1); //Inputting edges
        example.addEdge(0, 3);
        example.addEdge(1, 2);
        example.addEdge(2, 4);
        example.addEdge(3, 4);
        example.addEdge(3, 5);

        int vertexDeg = 3; //Finding the degree of vertex 3, can be change to another vertex
        System.out.println("\nDegree of vertex " + vertexDeg + ": " + example.degreeVertex(vertexDeg) + "\n");

        int vertexAdj = 0; //Finding the adjacent vertices of vertex 0, can be changed to antoher vertex
        System.out.print("Adjacent vertices of vertex " + vertexAdj + ":");
        System.out.println(example.printAdjVertices(vertexAdj));

        example.breadthFirstSearch(0);
        example.depthFirstSearch(0);

    }
}
