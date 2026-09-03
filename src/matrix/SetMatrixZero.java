package matrix;

public class SetMatrixZero {
    public static void main(String[] args) {
        SetMatrixZero matrixZero = new SetMatrixZero();
        int[][] matrix = {{1, 1, 1}, {0, 0, 1}, {1, 1, 1}};
        matrixZero.setZeroes(matrix);
        printMatrix(matrix);
    }

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            System.out.println();
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
        }
    }

//    public void setZeroes(int[][] matrix) {
//        int idxOne = 1;
//        int m = matrix.length;
//        int n = matrix[0].length;
//        if (matrix[0][0] == 0) {
//            idxOne = 9;
//        }
//        for (int i = 1; i < m; i++) {
//            for (int j = 0; j < n - 1; j++) {
//                if (matrix[i][j] == 0) {
//                    matrix[0][j] = 9;
//                    matrix[i][n - 1] = 9;
//                }
//            }
//        }
//
//        for (int i = 0; i < m; i++) {
//            if (matrix[i][n - 1] == 0) {
//                matrix[i][n - 1] = 9;
//            }
//        }
//        for (int j = 1; j < n; j++) {
//            if (matrix[0][j] == 0) {
//                matrix[0][j] = 9;
//            }
//        }
//    }

    // Approach: Use first row and first column as markers. O(1) space, O(m*n) time.
    // A separate boolean tracks column 0 since matrix[0][0] already serves as the marker for row 0.
    // Zeroing is done bottom-to-top so markers in row 0 / col 0 aren't destroyed before they're read.
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean col0 = false; // tracks whether column 0 should be zeroed

        // Pass 1: scan for zeroes; mark their row (in col 0) and column (in row 0)
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) col0 = true; // column 0 has a zero — can't use matrix[0][0] for this
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0; // mark this row
                    matrix[0][j] = 0; // mark this column
                }
            }
        }

        // Pass 2: zero cells based on markers, iterating bottom-to-top to preserve row 0 markers
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 1; j--) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
            if (col0) matrix[i][0] = 0; // zero column 0 last, after its marker role is done
        }
    }
}
