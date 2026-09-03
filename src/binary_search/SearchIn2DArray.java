package binary_search;

public class SearchIn2DArray {
    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        SearchIn2DArray search = new SearchIn2DArray();
        int target = 16;
        boolean isElementPresent = search.searchMatrix(matrix, target);
        System.out.println("Is element present: " + isElementPresent);


    }

    public boolean searchMatrix(int[][] matrix, int target) {
        //search row
        int row = searchRow(matrix, target);
        //System.out.println("The row number is : " + row);
        //search column
        return searchColumn(matrix, row, target);
        //return false;
    }

    private boolean searchColumn(int[][] matrix, int row, int target) {
        if (row == -1) return false;
        int n = matrix[0].length;
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (matrix[row][mid] == target) return true;
            else if (target < matrix[row][mid]) {
                high = mid - 1;
            } else low = mid + 1;
        }
        return false;
    }

    private int searchRow(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int low = 0;
        int high = matrix.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (target >= matrix[mid][0] && target <= matrix[mid][n - 1]) {
                return mid;
            } else if (target < matrix[mid][0]) {
                high = mid - 1;
            } else low = mid + 1;
        }
        return -1;
    }
}
