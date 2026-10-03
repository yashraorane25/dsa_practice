package code.dynamic_programming.two_dp;

import java.util.Arrays;

public class UniquePathsTwo {

    public static void main(String[] args) {
        int[][] obstacleGrid = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        UniquePathsTwo uniquePathsTwo = new UniquePathsTwo();
        int res = uniquePathsTwo.uniquePathsWithObstacles(obstacleGrid);
        System.out.println("The number of unique paths are: " + res);
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;
        int[][] dp = new int[rows][cols];
        for (int[] r : dp) {
            Arrays.fill(r, -1);
        }
        return solve(rows - 1, cols - 1, obstacleGrid, dp);

    }

//    public int solve(int i, int j, int[][] obstacleGrid) {
//        //if there is an obstacle
//        if (i >= 0 && j >= 0 && obstacleGrid[i][j] == 1) {
//            return 0;
//        }
//        //if we reach the first cell
//        if (i == 0 && j == 0) return 1;
//        if (i < 0 || j < 0) return 0;
//
//        int up = solve(i - 1, j, obstacleGrid);
//        int left = solve(i, j - 1, obstacleGrid);
//        return up + left;
//    }


    public int solve(int i, int j, int[][] obstacleGrid, int[][] dp) {
        //if there is an obstacle
        if (i >= 0 && j >= 0 && obstacleGrid[i][j] == 1) {
            return 0;
        }
        //if we reach the first cell
        if (i == 0 && j == 0) return 1;
        if (i < 0 || j < 0) return 0;
        if (dp[i][j] != -1) return dp[i][j];

        int up = solve(i - 1, j, obstacleGrid, dp);
        int left = solve(i, j - 1, obstacleGrid, dp);
        return dp[i][j] = up + left;
    }
}
