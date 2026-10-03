package code.union_find;

import java.util.ArrayList;
import java.util.List;

public class NoOfProvince {
    public static void main(String[] args) {
        int[][] isConnected = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
        NoOfProvince province = new NoOfProvince();
        int numberOfProvince = province.findCircleNum(isConnected);
        System.out.println("Number of province are: " + numberOfProvince);
    }

    public int findCircleNum(int[][] isConnected) {
        int V = isConnected.length;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }


        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (i != j && isConnected[i][j] == 1) {
                    adj.get(i).add(j);
                    // adj.get(j).add(i);
                }
            }
        }

        int[] vis = new int[V];
        int cnt = 0;
        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                cnt++;
                dfs(i, vis, adj);
            }
        }
//
//        for (int i = 0; i < n; i++) {
//            System.out.println(i + " -> " + adj.get(i));
//        }

        return cnt;
    }

    private void dfs(int node, int[] vis, List<List<Integer>> adj) {
        vis[node] = 1;
        for (int it : adj.get(node)) {
            if (vis[it] == 0) {
                dfs(it, vis, adj);
            }
        }
    }
}
