package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllPathsFromSourceToTarget {
    public static void main(String[] args) {
        AllPathsFromSourceToTarget paths = new AllPathsFromSourceToTarget();
        int[][] graphs = {{1, 2}, {3}, {3}, {}};
        List<List<Integer>> res = paths.allPathsSourceTarget(graphs);
        for (List<Integer> ls : res) {
            for (Integer val : ls) {
                System.out.println(val);
            }
        }
    }

    // graph[i] = list of nodes reachable directly from node i (a DAG).
    // Goal: return every path from node 0 to node (graph.length - 1).
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        // --- Approach 1: plain backtracking DFS (kept for reference, see dfs() below) ---
//        List<List<Integer>> ans = new ArrayList<>();
//        List<Integer> path = new ArrayList<>();
//        path.add(0);
//        dfs(graph, path, ans, 0);
//        return ans;

        // --- Approach 2 (active): memoized DFS, see allPaths() below ---
        // memo maps a node -> "all paths from that node to the target".
        // Since it's a DAG, this result never depends on how we arrived at
        // the node, so it's safe to compute it once and reuse it.
        Map<Integer, List<List<Integer>>> memo = new HashMap<>();
        return allPaths(graph, 0, memo);

    }

    // Classic backtracking DFS: walk the graph while building up `path`.
    // On reaching the target node, snapshot the path into `ans`.
    // After exploring a neighbour, undo the last add ("backtrack") so the
    // same `path` list can be reused for the next branch.
//    public void dfs(int[][] graph, List<Integer> path, List<List<Integer>> ans, int node) {
//        //if we reach the target node, save a copy of the current path
//        if (node == graph.length - 1) {
//            ans.add(new ArrayList<>(path));
//        }
//        //explore each neighbour
//        for (int neighbour : graph[node]) {
//            path.add(neighbour);
//            dfs(graph, path, ans, neighbour);
//            path.remove(path.size() - 1);
//        }
//    }


    // Returns every path from `node` to the target (last node in graph),
    // where each returned path is a list starting with `node` itself.
    private List<List<Integer>> allPaths(int[][] graph, int node, Map<Integer, List<List<Integer>>> memo) {
        // Already solved this node's paths-to-target before (via a different
        // route in the graph) — reuse the cached result instead of recomputing.
        if (memo.containsKey(node)) {
            return memo.get(node);
        }

        List<List<Integer>> paths = new ArrayList<>();
        //base case: node itself is the target, so the only path is [node]
        if (node == graph.length - 1) {
            paths.add(new ArrayList<>(List.of(node)));
            memo.put(node, paths);
            return paths;
        }

        //for each neighbour get all paths from neighbour to target and prepend current node
        for (int neighbour : graph[node]) {
            for (List<Integer> subPath : allPaths(graph, neighbour, memo)) {
                // build [node, ...subPath] without mutating the cached subPath
                List<Integer> fullpath = new ArrayList<>();
                fullpath.add(node);
                fullpath.addAll(subPath);
                paths.add(fullpath);
            }
        }
        memo.put(node, paths);
        return paths;
    }
}
