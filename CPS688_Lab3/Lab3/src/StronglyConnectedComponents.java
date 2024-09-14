//Author Redwan Khalifa 501------
import java.util.*;

public class StronglyConnectedComponents {

    static class Graph {
        int vertex;
        int edge;
        List<List<Integer>> graph; 

        public Graph(int n, int e) {
            vertex = n;
            edge = e;
            graph = new ArrayList<>(vertex);
            for (int i = 0; i < vertex; i++) {
                graph.add(new ArrayList<>());
            }
        }

        public void newEdge(int s, int t) {
            graph.get(s).add(t);
        }

        public Graph reverseGraph() {
            Graph temp = new Graph(vertex, edge);
            for (int i = 0; i < vertex; i++) {
                for(int next:graph.get(i)) {
                    temp.newEdge(next, i);
                }
            }
            return temp;
        }

        public void traversalDFS(int k, boolean[] visit) {
            visit[k] = true;
            for (int next:graph.get(k)) {
                if (!visit[next]) {
                    traversalDFS(next, visit);
                }
            }
        }

        public boolean verifySC() {
            boolean[] visit = new boolean[vertex];
            traversalDFS(0, visit);

            for (boolean visited:visit) {
                if(!visited) {
                    return false;
                }
            }

            Graph transpose = reverseGraph();
            Arrays.fill(visit, false);
            transpose.traversalDFS(0,visit);
            for (boolean visited:visit) {
                if (!visited) {
                    return false;
                }
            }
            return true;
        }

        public void stronglyConnected() {
            if (verifySC()) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
    public static void main (String[] args) {
        Graph example = new Graph(6, 7); //Inputting number of nodes and verticies

        example.newEdge(0, 1); //Adding edges
        example.newEdge(0, 2);
        example.newEdge(2, 4);
        example.newEdge(3, 1);
        example.newEdge(3, 5);
        example.newEdge(4, 5);
        example.newEdge(5, 0);

        example.stronglyConnected();
    }
}
