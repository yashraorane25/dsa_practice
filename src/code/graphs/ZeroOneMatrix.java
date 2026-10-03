package code.graphs;

import code.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

public class ZeroOneMatrix {
    public static void main(String[] args) {
        int[][] mat = {{1, 1, 1}, {1, 1, 1,}, {1, 1, 0}};
        ZeroOneMatrix zeroOneMatrix = new ZeroOneMatrix();
        int[][] res = zeroOneMatrix.updateMatrix(mat);
        printMat(res);
    }

    private static void printMat(int[][] res) {
        int rows = res.length;
        int cols = res[0].length;
        System.out.println("[");
        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
        System.out.print("]");

    }

    public int[][] updateMatrix(int[][] mat) {

        int m = mat.length;
        int n = mat[0].length;
        int[][] res = new int[m][n];
        Queue<Pair> q = new LinkedList<>();

        //seed the BFS with every 0 cell (distance 0) and mark non-zero cells unvisited
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    res[i][j] = 0;
                    q.add(new Pair(i, j));
                } else {
                    res[i][j] = -1;
                }
            }
        }

        while (!q.isEmpty()) {
            Pair cell = q.poll();
            int row = cell.getFirst();
            int col = cell.getSecond();

            if (row + 1 < m && res[row + 1][col] == -1) {
                res[row + 1][col] = res[row][col] + 1;
                q.add(new Pair(row + 1, col));
            }

            if (row - 1 >= 0 && res[row - 1][col] == -1) {
                res[row - 1][col] = res[row][col] + 1;
                q.add(new Pair(row - 1, col));
            }

            if (col + 1 < n && res[row][col + 1] == -1) {
                res[row][col + 1] = res[row][col] + 1;
                q.add(new Pair(row, col + 1));
            }

            if (col - 1 >= 0 && res[row][col - 1] == -1) {
                res[row][col - 1] = res[row][col] + 1;
                q.add(new Pair(row, col - 1));
            }
        }

        return res;
    }

}
