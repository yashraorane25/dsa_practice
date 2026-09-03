package union_find;

public class RedundantConnections {

    public static void main(String[] args) {
        int[][] edges = {{1, 2}, {1, 3}, {1, 4}, {3, 4}, {4, 5}};
        RedundantConnections connections = new RedundantConnections();
        int[] res = connections.findRedundantConnection(edges);
        System.out.println("The redudant connection is: " + res[0] + "," + res[1]);
    }

    public int[] findRedundantConnection(int[][] edges) {
        //initilzie the parent array where parent[i] represent the parent of node i
        int[] parent = new int[edges.length + 1];
        for (int i = 1; i < edges.length; i++) {
            parent[i] = i; // initialzie each node as its won parent.
        }

        //iterate through edges to find the redundant ones
        for (int[] edge : edges) {
            int node1 = edge[0];
            int node2 = edge[1];
            // find the roots of node1 and node2
            int root1 = find(parent, node1);
            int root2 = find(parent, node2);

            //if the roots are same, a cycle is detected, return the edge
            if (root2 == root1) {

                return edge;
            }

//union the sets by making root1 as the parent of root2
            parent[root2] = root1;
        }
        //if no cycle is found(which should not happen in this problem). return an empty array
        return new int[0];
    }


    /*
    1. while (node != parent[node]) — keep climbing as long as node isn't already the root of its tree. The loop naturally terminates once it reaches a self-parenting node (a root).
    2. parent[node] = parent[parent[node]]; — this is the path-compression step. Before moving up, it rewires node's parent to point to its grandparent (parent[parent[node]]),
    skipping one level. This is called "path halving" — it doesn't fully flatten the path to the root in one pass (that'd require a second traversal after finding the root),
    but it roughly halves the tree's height with each find call, and does so cheaply in a single pass.
    3. node = parent[node]; — move node up to what is now its (possibly updated) parent, and re-check the loop condition.
    4. return node; — once the loop exits, node is the root, so that's returned.
    * */
    private int find(int[] parent, int node) {
        while (node != parent[node]) {
            parent[node] = parent[parent[node]]; // path compression for optimization
            node = parent[node];
        }
        return node;
    }

}
