package code.heaps;

public class FurthestBuildingReach {

    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        return dfs(heights, 0, bricks, ladders);
    }

    private int dfs(int[] heights, int idx, int bricks, int ladders) {
        if (idx == heights.length - 1) {
            return idx;
        }

        int diff = heights[idx + 1] - heights[idx];
        if (diff <= 0) {
            //no clim needed
            return dfs(heights, idx + 1, bricks, ladders);
        }
        int best = idx;
        //try using bricks
        if (bricks >= diff) {
            best = Math.max(best, dfs(heights, idx + 1, bricks - diff, ladders));
        }

        //try using ladders
        if (ladders > 0) {
            best = Math.max(best, dfs(heights, idx + 1, bricks, ladders - 1));
        }
        return best;

    }

    public static void main(String[] args) {
        int[] heights = {4, 12, 2, 7, 3, 18, 20, 3, 19};
        int bricks = 10;
        int ladders = 2;
        FurthestBuildingReach furthestBuildingReach = new FurthestBuildingReach();
        int furthestBuilding = furthestBuildingReach.furthestBuilding(heights, bricks, ladders);
        System.out.println(furthestBuilding);
    }
}
