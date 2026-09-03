package graphs;

import util.Pair;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
    public static void main(String[] args) {
        int[][] grid = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        RottenOranges ro = new RottenOranges();
        int minutesRequired = ro.orangesRotting(grid);
        System.out.println(minutesRequired);
    }

    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int countMinutes = 0;

        Queue<Pair> q = new LinkedList<>();
        int freshOranges = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == 2) {
                    q.add(new Pair(i, j));
                }
                if (grid[i][j] == 1) {
                    freshOranges++;
                }
            }


        }


        while (!q.isEmpty()) {
            int levelSize = q.size();
            boolean rottenThisRound = false;

            for (int i = 0; i < levelSize; i++) {
                Pair cell = q.peek();
                q.remove();
                int row = cell.getFirst();
                int col = cell.getSecond();
                if (row + 1 < m && grid[row + 1][col] == 1) {
                    grid[row + 1][col] = 2;
                    freshOranges--;
                    q.add(new Pair(row + 1, col));
                    rottenThisRound = true;
                }
                if (row - 1 >= 0 && grid[row - 1][col] == 1) {
                    grid[row - 1][col] = 2;
                    freshOranges--;
                    q.add(new Pair(row - 1, col));
                    rottenThisRound = true;
                }
                if (col + 1 < n && grid[row][col + 1] == 1) {
                    grid[row][col + 1] = 2;
                    freshOranges--;
                    q.add(new Pair(row, col + 1));
                    rottenThisRound = true;
                }

                if (col - 1 >= 0 && grid[row][col - 1] == 1) {
                    grid[row][col - 1] = 2;
                    freshOranges--;
                    q.add(new Pair(row, col - 1));
                    rottenThisRound = true;
                }
            }

            if (rottenThisRound) {
                countMinutes++;
            }
        }

        return freshOranges > 0 ? -1 : countMinutes;
    }

    //   private int bfs(int row, int col, int[][] grid, int[][] vis) {
//        Queue<Integer> q= new LinkedList<>();
//        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || vis[row][col] == 1 || grid[row][col] == 0) {
//            return 0;
//        }
//        if (grid[row][col] == 1 && vis[row][col] == 0) {
//            grid[row][col] = 2;
//            vis[row][col] = 1;
//        }
//        dfs(row + 1, col, grid, vis);
//        dfs(row - 1, col, grid, vis);
//        dfs(row, col + 1, grid, vis);
//        dfs(row, col - 1, grid, vis);
    //  }
}
