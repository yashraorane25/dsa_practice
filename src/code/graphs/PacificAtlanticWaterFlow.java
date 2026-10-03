package code.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PacificAtlanticWaterFlow {
    public static void main(String[] args) {
        int[][] heights = {{1, 2, 2, 3, 5}, {
                3, 2, 3, 4, 4
        }, {
                2, 4, 5, 3, 1
        }, {
                6, 7, 1, 4, 5
        }, {
                5, 1, 1, 2, 4
        }
        };
        PacificAtlanticWaterFlow waterFlow = new PacificAtlanticWaterFlow();
        List<List<Integer>> res = waterFlow.pacificAtlantic(heights);
        printResult(res);

    }

    private static void printResult(List<List<Integer>> res) {
        for (List<Integer> ls : res) {
            for (Integer val : ls) {
                System.out.println(val);
            }
        }
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;
        int[][] visPacfic = new int[rows][cols];
        int[][] visAtlantic = new int[rows][cols];
        List<List<Integer>> ans = new ArrayList<>();


        for (int j = 0; j < cols; j++) {
            //for first row since it is close to pacific
            dfs(0, j, heights, visPacfic, heights[0][j]);
            //for last row since it is close to atlantic
            dfs(rows - 1, j, heights, visAtlantic, heights[rows - 1][j]);

        }

        for (int i = 0; i < rows; i++) {
            //for firt col as it is close to pacific
            dfs(i, 0, heights, visPacfic, heights[i][0]);
            //for last col as it is close to atlantic
            dfs(i, cols - 1, heights, visAtlantic, heights[i][cols - 1]);
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (visPacfic[i][j] == 1 && visAtlantic[i][j] == 1) {
                    ans.add(Arrays.asList(i, j));

                }
            }
        }
        return ans;


    }

    private void dfs(int row, int col, int[][] heights, int[][] vis, int prevHeight) {
        if (row < 0 || col < 0 || row == heights.length || col == heights[0].length || vis[row][col] == 1 || heights[row][col] < prevHeight) {
            return;
        }
        vis[row][col] = 1;
        dfs(row + 1, col, heights, vis, heights[row][col]);
        dfs(row - 1, col, heights, vis, heights[row][col]);
        dfs(row, col + 1, heights, vis, heights[row][col]);
        dfs(row, col - 1, heights, vis, heights[row][col]);
    }
}
