package dynamic_programming.two_dp;

import java.util.LinkedList;
import java.util.Queue;

public class LongestIncreasingPathOptimized {
    public static void main(String[] args) {
        int[][] matrix = {{9, 9, 4}, {6, 6, 8}, {2, 1, 1}};
        LongestIncreasingPathOptimized lipOptimized = new LongestIncreasingPathOptimized();
        int longestPathLength = lipOptimized.longestIncreasingPath(matrix);
        System.out.println("Longest Increasing Path length is : " + longestPathLength);
    }

    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        //computer in-degree for each cell
        int[][] inDegree = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int[] d : dirs) {
                    int ni = i + d[0];
                    int nj = j + d[1];
                    if (ni >= 0 && ni < m && nj >= 0 && nj < n && matrix[ni][nj] < matrix[i][j]) {
                        inDegree[i][j]++;
                    }
                }
            }
        }

        //start bfs from all cells with in-degree 0
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (inDegree[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        int levels = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            levels++;
            for (int k = 0; k < size; k++) {
                int[] cell = queue.poll();
                int i = cell[0];
                int j = cell[1];
                for (int[] d : dirs) {
                    int ni = i + d[0];
                    int nj = j + d[1];
                    if (ni >= 0 && ni < m && nj >= 0 && nj < n && matrix[ni][nj] > matrix[i][j]) {
                        inDegree[ni][nj]--;
                        if (inDegree[ni][nj] == 0) {
                            queue.offer(new int[]{ni, nj});
                        }
                    }
                }
            }
        }
        return levels;
    }
}
