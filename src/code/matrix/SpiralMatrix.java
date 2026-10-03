package code.matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        SpiralMatrix sp = new SpiralMatrix();
        List<Integer> res = sp.spiralOrder(matrix);
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }


    }

    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] vis = new boolean[m][n];
        List<Integer> res = new ArrayList<>();
        int dir = 0;
        int[] rowDirs = {0, 1, 0, -1};
        int[] colDirs = {1, 0, -1, 0};
        // int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int row = 0;
        int col = 0;
        for (int i = 0; i < m * n; i++) {
            res.add(matrix[row][col]);
            vis[row][col] = true;
            int nextRow = row + rowDirs[dir];
            int nextCol = col + colDirs[dir];
            if (nextRow >= m || nextRow < 0 || nextCol >= n || nextCol < 0 || vis[nextRow][nextCol]) {
                dir = (dir + 1) % 4;
                nextRow = row + rowDirs[dir];
                nextCol = col + colDirs[dir];
            }
            row = nextRow;
            col = nextCol;
        }
        return res;

    }
}
