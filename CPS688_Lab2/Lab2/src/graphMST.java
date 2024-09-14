//Author Redwan Khalifa 501------
import java.util.*;

public class graphMST {

    int n, e; //Initilize variables
    List<List<Edge>> graph;

    public graphMST(int vertex, int edge) { //Initilize new graph
        n = vertex;
        e = edge;
        graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
    }

    public void newEdge(int edge1, int edge2, int weight) { //Create new undirected edges with respective weight
        Edge e1 = new Edge(edge1, edge2, weight);
        Edge e2 = new Edge(edge2, edge1, weight);
        graph.get(edge1).add(e1);
        graph.get(edge2).add(e2);
    }

    public void primAlgo() { //Runs prims Algorithum
        PriorityQueue<Edge> queue = new PriorityQueue<>(); //Initilize variables
        List<Edge> output = new ArrayList<>();
        boolean[] mstNode = new boolean[n];
        int mstWeight = 0;

        mstNode[0] = true;
        queue.addAll(graph.get(0));

        while (!queue.isEmpty()) {
            Edge edges = queue.poll();
            if (mstNode[edges.e2]) {
                continue;
            }

            mstNode[edges.e2] = true;
            output.add(edges);
            mstWeight += edges.w;

            for (Edge next : graph.get(edges.e2)) {
                if(!mstNode[next.e2]) {
                    queue.add(next);
                }
            }
        }

        for (Edge total : output) {
            System.out.println(total);
        }

        System.out.println("MST = " + mstWeight);
    }

    static class Edge implements Comparable<Edge> { //Edge subclass
        int e1, e2, w;

        public Edge(int edge1, int edge2, int weight) { //Create Edge
            this.e1 = edge1;
            this.e2 = edge2;
            this.w = weight;
        }

        public int compareTo(Edge compareEdge) {
            return this.w - compareEdge.w;
        }

        @Override
        public String toString() {
            return "Edge " + e1 + "-" + e2 + " has a weight of " + w;
        }
    }

    public static void main (String[] args) {

        graphMST example = new graphMST(4, 5);

        example.newEdge(0,1,10);
        example.newEdge(0,2,6);
        example.newEdge(0,3,5);
        example.newEdge(1,3,15);
        example.newEdge(2,3,4);

        example.primAlgo();
    }
}