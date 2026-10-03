package code.matrix;

public class RotateImage {
    public static void main(String[] args) {
        RotateImage ri = new RotateImage();
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        ri.rotate(matrix);
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

    public void rotate(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

//        for (int col = 0; col < n / 2; col++) {
//            int row = 0;
//            while (row < m) {
//                int temp = matrix[row][col];
//                matrix[row][col] = matrix[row][n - col - 1];
//                matrix[row][n - col - 1] = temp;
//                row++;
//            }
//        }
        for (int i = 0; i < n; i++) {
            int left = 0, right = n - 1;
            while (left < right) {
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                left++;
                right--;
            }
        }
        //printMatrix(matrix);

    }
}
