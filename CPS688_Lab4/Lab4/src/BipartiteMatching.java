//Author Redwan Khalifa 501------
import java.util.*;

public class BipartiteMatching {

    static int persons, jobs, sink, source = 0;

    public static int[][] setPara(int[][] matrix) {
        persons = matrix.length; //Initialize variables
        jobs = matrix[0].length;
        int total = persons + jobs + 2;
        sink = total - 1;
        int[][] caseEx = new int[total][total];
        
        for (int i = 1; i <= persons; i++) { //Vertex is connected to each applicant
            caseEx[source][i] = 1;
        }

        for (int i = 1; i <= persons; i++) { //Transfers over applicants with there respective job interests
            for (int j = 1; j <= jobs; j++) {
                if (matrix[i-1][j-1] == 1) {
                    caseEx[i][persons + j] = 1;
                }
            }
        }

        for (int i = 1; i <= jobs; i++) { //Each job is connected to the sink
            caseEx[persons + i][sink] = 1;
        }

        return caseEx;
    }

    public static boolean flowNetwork(int[][] resGraph, int[] array) { //BFS is used to find pathways from the source to the sink
        boolean[] visit = new boolean[resGraph.length];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        visit[source] = true;
        array[source] = -1;

        while (!queue.isEmpty()) {
            int i = queue.poll();

            for (int j = 0; j < resGraph.length; j++) {
                if (!visit[j] && resGraph[i][j] > 0) {
                    if (j == sink) {
                        array[j] = i;
                        return true;
                    }
                    queue.add(j);
                    array[j] = i;
                    visit[j] = true;
                }
            }
        }
        return false;
    }

    public static int fordFulkersonAlgo(int[][] caseEx) { //Finds maximum flow
        int i, j, max = 0;
        int[] array = new int[caseEx.length];
        int[][] resGraph = new int [caseEx.length][caseEx.length];

        for (i = 0; i < caseEx.length; i++) { //verify capacities
            for (j = 0; j < caseEx.length; j++) {
                resGraph[i][j] = caseEx[i][j];
            }
        }

        while (flowNetwork(resGraph, array)) {
            int flow = Integer.MAX_VALUE;

            for (j = sink; j != source; j = array[j]) { //Finds max flow for a given path
                i = array[j];
                flow = Math.min(flow, resGraph[i][j]);
            }

            for (j = sink; j != source; j = array[j]) { //Update edges
                i = array[j];
                resGraph[i][j] -= flow;
                resGraph[j][i] += flow;
            }
            max += flow;
        }
        return max;
    }

    public static void main(String[] args) {
        
        int[][] matrix = new int[][] { //Input data set
            { 0, 1, 1, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 },
            { 1, 0, 0, 1, 0, 0 },  { 0, 0, 1, 0, 0, 0 },
            { 0, 0, 1, 1, 0, 0 },   { 0, 0, 0, 0, 0, 1 }   
        };
        
        System.out.println("The maximum number of applicants matching for the jobs is " + fordFulkersonAlgo(setPara(matrix)));
    }
}
