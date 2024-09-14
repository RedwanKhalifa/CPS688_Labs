//Author Redwan Khalifa 501------
import java.util.*;

public class AcyclicGraph {

    List<List<Integer>> graph;
    int n, e;

    public AcyclicGraph(int x, int y) {
        graph = new ArrayList<>();
        n = x;
        e = y;
    }

    public void newEdge(int x, int y) {
        graph.add(new ArrayList<>());
        graph.add(new ArrayList<>());
        graph.get(x).add(y);
        graph.get(y).add(x);
    }

    public boolean graphCheck() { //Does the graph have a cycle
        boolean[] visit = new boolean[n]; //Store visited
        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                if (cycleDFS( visit, i, -1)) { //Look for cycle
                    return true;
                }
            }
        }
        return false; // If no cycle is found, return false
    }

    public boolean cycleDFS(boolean[] visit, int v, int parent) { //Using DFS check for cycle
        visit[v] = true; 
        for (Integer i : graph.get(v)) { // Check all adjacent vertices
            if (!visit[i]) {
                if (cycleDFS(visit, i, v)) {
                    return true; //Return true if cycle is found
                }
            }
            else if (i != parent) {
                return true; //Return true if cycle is found
            }
        }
        return false; //No cycle is found
    }

    public static void main (String[] args) {

        AcyclicGraph example = new AcyclicGraph(6, 6);
        example.newEdge(0, 1);
        example.newEdge(0, 3);
        example.newEdge(1, 2);
        example.newEdge(2, 4);
        example.newEdge(3, 4);
        example.newEdge(3, 5);

        if (example.graphCheck()) {
            System.out.println("no");
        } else {
            System.out.println("yes");
        }
    }
}