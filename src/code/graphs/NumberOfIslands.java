package code.graphs;

public class NumberOfIslands {

    public static void main(String[] args) {
        NumberOfIslands islands = new NumberOfIslands();
        char[][] grid = {{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}};
        int noOfIslands = islands.numIslands(grid);
        System.out.println(noOfIslands);
    }


    public int numIslands(char[][] grid) {
        int noOfIslands = 0;
        int m = grid.length;
        int n = grid[0].length;
        if (grid[0].length == 0) return 0;
        int[][] visited = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && visited[i][j] != 1) {
                    dfs(grid, visited, i, j, m, n);
                    noOfIslands++;
                }
            }
        }
        return noOfIslands;


    }

    private void dfs(char[][] grid, int[][] visited, int i, int j, int m, int n) {

        visited[i][j] = 1;

        if (i + 1 < m && grid[i + 1][j] != '0' && visited[i + 1][j] != 1) {
            dfs(grid, visited, i + 1, j, m, n);
        }
        if (i - 1 >= 0 && grid[i - 1][j] != '0' && visited[i - 1][j] != 1) {
            dfs(grid, visited, i - 1, j, m, n);
        }
        if (j + 1 < n && grid[i][j + 1] != '0' && visited[i][j + 1] != 1) {
            dfs(grid, visited, i, j + 1, m, n);
        }
        if (j - 1 >= 0 && grid[i][j - 1] != '0' && visited[i][j - 1] != 1) {
            dfs(grid, visited, i, j - 1, m, n);
        }
    }
}
