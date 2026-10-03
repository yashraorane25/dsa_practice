package code.dynamic_programming.two_dp;

public class LongestIncreasingPath {

    private static final int[][] DIRS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) {
        int[][] matrix = {{9, 9, 4}, {6, 6, 8}, {2, 1, 1}};
        LongestIncreasingPath lip = new LongestIncreasingPath();
        int longestPathLength = lip.longestIncreasingPath(matrix);
        System.out.println("Longest Increasing Path length is : " + longestPathLength);
    }

    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int maxi = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                maxi = Math.max(maxi, lis(i, j, matrix, dp, m, n));
            }
        }

        return maxi;
    }

    private int lis(int i, int j, int[][] matrix, int[][] dp, int m, int n) {

        if (i < 0 || j < 0 || i >= m || j >= n) {
            return 0;
        }
        int currMax = 1;
//        if (dp[i][j] > 0) return dp[i][j];
//        //down neighbour
//        if (i + 1 < m && i + 1 > 0 && matrix[i + 1][j] > matrix[i][j]) {
//            currMax = Math.max(currMax, lis(i + 1, j, matrix, dp, m, n));
//        }
//        //right neighbour
//
//        if (j + 1 < n && j + 1 > 0 && matrix[i][j + 1] > matrix[i][j]) {
//            currMax = Math.max(currMax, lis(i, j + 1, matrix, dp, m, n));
//        }
//
//        //left nighbour
//        if (j - 1 < n && j - 1 > 0 && matrix[i][j - 1] > matrix[i][j]) {
//            currMax = Math.max(currMax, lis(i, j - 1, matrix, dp, m, n));
//        }
//
//        //up neighbour
//        if (i - 1 < m && i - 1 > 0 && matrix[i - 1][j] > matrix[i][j]) {
//            currMax = Math.max(currMax, lis(i - 1, j, matrix, dp, m, n));
//        }


        for (int[] dir : DIRS) {
            int ni = i + dir[0];
            int nj = j + dir[1];
            if (ni >= 0 && ni < m && nj >= 0 && nj < n && matrix[ni][nj] > matrix[i][j]) {
                currMax = Math.max(currMax, 1 + lis(ni, nj, matrix, dp, m, n));
            }
        }


        dp[i][j] = currMax;
        return currMax;
    }


}
