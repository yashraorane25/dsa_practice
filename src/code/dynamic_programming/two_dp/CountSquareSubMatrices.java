package code.dynamic_programming.two_dp;

public class CountSquareSubMatrices {
    public static void main(String[] args) {
        int[][] matrix = {{1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}};
        CountSquareSubMatrices countSquareSubMatrices = new CountSquareSubMatrices();
        int countSquareWithOnes = countSquareSubMatrices.countSquares(matrix);
        System.out.println("The number of squares which contains 1s is: " + countSquareWithOnes);
    }

    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = matrix[i][0];
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = matrix[0][j];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 1) {
                    dp[i][j] = 1 + Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]);
                } else {
                    dp[i][j] = 0;
                }
            }

        }
        int sum = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sum += dp[i][j];
            }
        }
        return sum;

    }

    public void printMatrix(int[][] arr) {
        for (int[] ints : arr) {
            System.out.print("[");
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(ints[j] + "\t");
            }
            System.out.print("]");
        }
    }
}
