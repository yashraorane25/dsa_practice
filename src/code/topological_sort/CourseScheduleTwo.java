package code.topological_sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// LeetCode 210 - Course Schedule II
//
// Problem: given `numCourses` courses (0..numCourses-1) and a list of
// prerequisite pairs [course, prereq] (meaning `prereq` must be taken
// before `course`), return ONE valid order to take all courses.
// If it's impossible (the prerequisites form a cycle), return an empty array.
//
// Algorithm: DFS-based topological sort with cycle detection.
//   1. Build an adjacency list: edge goes prereq -> course, since
//      finishing `prereq` unlocks `course`.
//   2. Run DFS from every unvisited node. Each node has 3 states:
//        0 = unvisited
//        1 = visiting   (currently on the recursion stack / active DFS path)
//        2 = done        (fully explored, safe to place in the ordering)
//      If DFS ever reaches a neighbour that is still "visiting" (state 1),
//      that's a back-edge, i.e. a cycle -> no valid ordering exists.
//   3. When a node finishes exploring all of its neighbours (state -> done),
//      push it onto a stack. This is the classic "post-order DFS" trick:
//      a node is only pushed after everything it depends on has already
//      been pushed, so popping the stack yields a valid topological order.
//
// Time complexity: O(V + E) - each node and edge visited once.
// Space complexity: O(V + E) for the adjacency list + O(V) for the stack/vis array.
public class CourseScheduleTwo {
    public static void main(String[] args) {
        CourseScheduleTwo courseScheduleTwo = new CourseScheduleTwo();
        int numCourses = 4;
        int[][] prerequisites = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        int[] res = courseScheduleTwo.findOrder(numCourses, prerequisites);
        System.out.println("Correct order: " + java.util.Arrays.toString(res));

    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // adj.get(prereq) = list of courses that become available once `prereq` is done
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        //pair = [course, prereq]; course depends on prereq, so the edge goes prereq -> course
        for (int[] pair : prerequisites) {
            adj.get(pair[1]).add(pair[0]);
        }

        int[] vis = new int[numCourses]; // 0 = unvisited, 1 = visiting, 2 = done
        Stack<Integer> st = new Stack<>(); // accumulates nodes in post-order (reverse topological order)
        for (int i = 0; i < numCourses; i++) {
            // graph may be disconnected, so kick off a DFS from every
            // not-yet-visited node to make sure every course gets ordered
            if (vis[i] == 0) {
                if (!dfs(i, vis, adj, st)) {
                    return new int[0]; // cycle detected, no valid order exists
                }
            }
        }

        // stack was filled in post-order (a node is pushed only after all of
        // its prerequisites' subtrees are fully explored), so popping it
        // top-to-bottom naturally yields prerequisites before dependents
        int[] ans = new int[numCourses];
        int i = 0;
        while (!st.isEmpty()) {
            ans[i++] = st.pop();
        }
        return ans;

    }

    // Explores `node` and everything reachable from it.
    // Returns false as soon as a cycle is detected (propagated back up
    // through every caller on the current recursion path), true otherwise.
    private boolean dfs(int node, int[] vis, List<List<Integer>> adj, Stack<Integer> st) {
        vis[node] = 1; // mark as visiting (on the current recursion path)
        for (int it : adj.get(node)) {
            if (vis[it] == 1) {
                // `it` is an ancestor of `node` in the current DFS path ->
                // we've looped back to something we're still in the middle
                // of processing, i.e. a cycle. No valid course order exists.
                return false;
            }
            if (vis[it] == 0 && !dfs(it, vis, adj, st)) {
                return false; // cycle found deeper in the recursion, bubble it up
            }
        }
        // every neighbour of `node` is fully explored (or already done),
        // so it's now safe to place `node` in the ordering
        vis[node] = 2;
        st.push(node);
        return true;
    }
}
