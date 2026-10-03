package code.dynamic_programming.one_dp;

public class HouseRobberTwo {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 1, 2, 3, 4, 5};
        HouseRobberTwo houseRobberTwo = new HouseRobberTwo();
        int maxAmount = houseRobberTwo.rob(nums);
        System.out.println("Max amount is : " + maxAmount);
    }

    public int rob(int[] nums) {
        int n = nums.length;
        int[] temp1 = new int[n];
        int[] temp2 = new int[n];
        for (int i = 0; i < n; i++) {
            if (i != 0) temp1[i] = nums[i];
            if (i != n - 1) temp2[i] = nums[i];
        }
        return Math.max(maxNonAdjacent(temp1), maxNonAdjacent(temp2));
    }

    /**
     * Finds the maximum sum of a subsequence such that no two elements are adjacent (House Robber I).
     * Uses Space-Optimized Dynamic Programming:
     * - Time Complexity: O(n) - Single pass through the array.
     * - Space Complexity: O(1) - Only two variables are maintained instead of a DP array.
     *
     * @param nums array containing money/values at each house
     * @return maximum amount of money that can be robbed
     */
    public int maxNonAdjacent(int[] nums) {
        int n = nums.length;

        // DP State Space Optimization:
        // 'prev' tracks dp[i - 1]: max loot possible up to the previous house.
        // Base case: For the first house (i = 0), max loot is nums[0].
        int prev = nums[0];

        // 'prev2' tracks dp[i - 2]: max loot possible up to the house before previous.
        // Base case: For house before the start, loot is 0.
        int prev2 = 0;

        for (int i = 0; i < n; i++) {
            // Choice 1: "Take/Pick" the current house nums[i]
            int take = nums[i];

            if (i > 1) {
                // If past index 1, we can add the loot from house (i - 2) since it's non-adjacent
                take += prev2;

                // Choice 2: "Not Take/Skip" the current house
                // Inherit the maximum loot up to house (i - 1)
                int notTake = 0 + prev;

                // Current best loot at index i is max of taking or not taking house i
                int curi = Math.max(take, notTake);

                // Update state variables for the next iteration (i + 1):
                // dp[i - 2] becomes dp[i - 1]
                prev2 = prev;
                // dp[i - 1] becomes dp[i]
                prev = curi;
            }
        }

        // 'prev' stores the maximum loot achievable across all houses (dp[n - 1])
        return prev;
    }
}
