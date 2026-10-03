package code.minimum_spanning_tree;


import java.util.PriorityQueue;

public class MinCostToConnectAllPoints {

    static class Pair {
        int first;  // cost (Manhattan distance) to reach this point
        int second; // point index

        Pair(int _first, int _second) {
            first = _first;
            second = _second;
        }
    }

    public static void main(String[] args) {
        MinCostToConnectAllPoints minCostToConnectAllPoints = new MinCostToConnectAllPoints();
        int[][] points = {{0, 0}, {2, 2}, {3, 10}, {5, 2}, {7, 0}};
        int minCost = minCostToConnectAllPoints.minCostConnectPoints(points);
        System.out.println(minCost);
    }

    private int manDis(int[][] points, int p1, int p2) {
        //mod(x1-x2)+ mod(y2-y1)
        return Math.abs(points[p1][0] - points[p2][0]) + Math.abs(points[p1][1] - points[p2][1]);
    }

    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
//        Set<Boolean> mstSet = new HashSet<>();
        int[] visited = new int[n];
        //min-heap ordered by cost (Pair.first), so the cheapest edge is always polled first
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.first, b.first));
        int mstCost = 0;
        pq.add(new Pair(0, 0));
        while (!pq.isEmpty()) {
            Pair pair = pq.peek();
            int weight = pair.first;
            int node = pair.second;
            pq.poll();
            if (visited[node] == 1) continue;
            visited[node] = 1;
            mstCost += weight;
            for (int i = 0; i < n; i++) {
                if (visited[i] == 0) {
                    int edgeWeight = manDis(points, node, i);
                    pq.add(new Pair(edgeWeight, i));
                }
            }

        }

        return mstCost;


    }
}
