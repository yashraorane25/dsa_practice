package code.graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CheckBipartite {
    public static void main(String[] args) {
        int[][] graph = {{1, 2, 3}, {0, 2}, {0, 1, 3}, {0, 2}};
        CheckBipartite checkBP = new CheckBipartite();
        boolean res = checkBP.isBipartite(graph);
        System.out.println(res);
    }

    public boolean isBipartite(int[][] graph) {
        int nodes = graph.length;
        int[] color = new int[nodes];
        Arrays.fill(color, -1);
        for (int i = 0; i < nodes; i++) {
            if (!checkBipartite(i, nodes, graph, color)) {
                return false;
            }
        }
        return true;
    }

    private boolean checkBipartite(int start, int nodes, int[][] graph, int[] color) {
        if (color[start] != -1) {
            return true; // already visited and validated in a previous BFS
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        color[start] = 0;
        while (!q.isEmpty()) {
            int node = q.peek();
            q.remove();
            for (int neighbour : graph[node]) {
                if (color[neighbour] == -1) {
                    color[neighbour] = 1 - color[node];
                    q.add(neighbour);
                } else {
                    if (color[neighbour] == color[node]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
