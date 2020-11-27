import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static class Graph {
        //key = node. value = list of neighbors.
       Map<Integer, List<Integer>> nodes;

        public Graph(int size) {
            nodes = new HashMap<Integer, List<Integer>>();
            for(int i = 0; i<size; i++){
                nodes.put(i, new ArrayList<Integer>());
            }
        }

        public void addEdge(int first, int second) {
            if(first != second){
               if(!(nodes.get(first).contains(second))){
                    nodes.get(first).add(second);
                }
                if(!(nodes.get(second).contains(first))){
                    nodes.get(second).add(first);
                } 
            }
        }

        public int[] shortestReach(int startId) { // 0 indexed
            int[] distances = new int[nodes.keySet().size()];
            Arrays.fill(distances, -1);
            distances[startId] = 0;
            visitNeighbors(startId, distances);
            return distances;
        }

            private void visitNeighbors(int startId, int[] distances){
        List<Integer> nodesToVisit = new ArrayList<Integer>();

        nodesToVisit.add(startId);
        distances[startId] = 0;
        while (!nodesToVisit.isEmpty()) {
            int current = nodesToVisit.get(0);
            nodesToVisit.remove(0);
            for (int i : nodes.get(current)) {
                if (distances[i] == -1) {
                    distances[i] = distances[current] + 6;
                    nodesToVisit.add(i);
                }
                //dont recurse right here, otherwise it will become depth-first and we will not get shortest path.
            }
        }
    }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int queries = scanner.nextInt();

        for (int t = 0; t < queries; t++) {

            // Create a graph of size n where each edge weight is 6:
            Graph graph = new Graph(scanner.nextInt());
            int m = scanner.nextInt();

            // read and set edges
            for (int i = 0; i < m; i++) {
                int u = scanner.nextInt() - 1;
                int v = scanner.nextInt() - 1;

                // add each edge to the graph
                graph.addEdge(u, v);
            }

            // Find shortest reach from node s
            int startId = scanner.nextInt() - 1;
            int[] distances = graph.shortestReach(startId);

            for (int i = 0; i < distances.length; i++) {
                if (i != startId) {
                    System.out.print(distances[i]);
                    System.out.print(" ");
                }
            }
            System.out.println();            
        }

        scanner.close();
    }
}
