package code.dynamic_programming.two_dp;

import java.util.Arrays;

public class MinimumPathSum {

    public static void main(String[] args) {
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        MinimumPathSum obj = new MinimumPathSum();
        int res = obj.minPathSum(grid);
        System.out.println("The minimum path sum is : " + res);
    }

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int[] rows : dp) {
            Arrays.fill(rows, -1);
        }
        return solve(m - 1, n - 1, grid, dp);
    }

    public int solve(int i, int j, int[][] grid, int[][] dp) {
        if (i == 0 && j == 0) return grid[0][0];
        if (i < 0 || j < 0) return Integer.MAX_VALUE;
        if (dp[i][j] != -1) return dp[i][j];
        int up = solve(i - 1, j, grid, dp);
        int left = solve(i, j - 1, grid, dp);
        return dp[i][j] = grid[i][j] + Math.min(left, up);
    }
}
