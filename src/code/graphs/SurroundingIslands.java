package code.graphs;

public class SurroundingIslands {
    public static void main(String[] args) {
        SurroundingIslands si = new SurroundingIslands();
        char[][] board = {{'X', 'X', 'X', 'X' }, {'X', 'O', 'O', 'X' }, {'X', 'X', 'O', 'X' }, {'X', 'O', 'X', 'X' }};
        si.solve(board);
        printBoard(board);
    }

    private static void printBoard(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            System.out.print("[");
            for (int j = 0; j < n; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.print("]");
        }
    }

    public void solve(char[][] board) {
        int[] rowsDir = {-1, 0, 1, 0};
        int[] colDirs = {0, 1, 0, -1};
        int m = board.length;
        int n = board[0].length;
        int[][] vis = new int[m][n];

        //traverse first row and last row
        for (int j = 0; j < n; j++) {
            // first row
            if (vis[0][j] == 0 && board[0][j] == 'O') {
                dfs(0, j, vis, board, rowsDir, colDirs);
            }

            //last row
            if (vis[m - 1][j] == 0 && board[m - 1][j] == 'O') {
                dfs(m - 1, j, vis, board, rowsDir, colDirs);
            }
        }

        //traverse the first col and last col
        for (int i = 0; i < m; i++) {
            //first col
            if (vis[i][0] == 0 && board[i][0] == 'O') {
                dfs(i, 0, vis, board, rowsDir, colDirs);
            }

            //last col
            if (vis[i][n - 1] == 0 && board[i][n - 1] == 'O') {
                dfs(i, n - 1, vis, board, rowsDir, colDirs);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (vis[i][j] == 0 && board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(int row, int col, int[][] vis, char[][] board, int[] rowDir, int[] colDir) {
        //check for top, right, bottom, left
        vis[row][col] = 1;
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < 4; i++) {
            int nRow = row + rowDir[i];
            int nCol = col + colDir[i];
            if (nRow >= 0 && nRow < m && nCol >= 0 && nCol < n && vis[nRow][nCol] == 0 && board[nRow][nCol] == 'O') {
                dfs(nRow, nCol, vis, board, rowDir, colDir);
            }
        }
    }


}
