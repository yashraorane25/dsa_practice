package dynamic_programming.unbounded_knapsack;

import java.util.Arrays;

/**
 * Problem: LeetCode 518 - Coin Change II
 * Pattern: Unbounded Knapsack (Count Combinations)
 * <p>
 * Goal:
 * Return the number of combinations that make up a given amount using an infinite
 * supply of each coin denomination.
 * <p>
 * Complexity:
 * - Time Complexity: O(N * amount), where N = coins.length
 * - Space Complexity: O(N * amount), 2D DP table (can be optimized to O(amount) using 1D array)
 */
public class CoinChangeTwo {

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int target = 5;
        CoinChangeTwo coinChangeTwo = new CoinChangeTwo();
        int noOfWays = coinChangeTwo.change(target, coins);
        System.out.println("No of combinations that make up the amount: " + noOfWays);
        // Expected output: 4 (5, 2+2+1, 2+1+1+1, 1+1+1+1+1)
    }

    /**
     * Tabulation (Bottom-Up 2D DP Approach)
     * <p>
     * DP State:
     * dp[idx][T] = number of combinations to form amount T using a subset
     * of coins from index 0 to idx.
     * <p>
     * Base Case (Row 0):
     * With only coins[0], we can form target T if and only if T is evenly
     * divisible by coins[0] (taking T / coins[0] coins).
     * Hence: dp[0][T] = (T % coins[0] == 0) ? 1 : 0
     * <p>
     * State Transition:
     * For each coin at index 'idx' and each target amount 'T':
     * 1. notTake: Exclude coins[idx], carry forward ways from dp[idx - 1][T]
     * 2. take:    Include coins[idx]. Because coin supply is unlimited (unbounded knapsack),
     * we stay at the same index: dp[idx][T - coins[idx]]
     * Total ways: dp[idx][T] = notTake + take
     */
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];

        // Base case: initialize for the first coin (idx = 0)
        for (int T = 0; T <= amount; T++) {
            dp[0][T] = (T % coins[0] == 0 ? 1 : 0);
        }

        // Fill table for remaining coins
        for (int idx = 1; idx < n; idx++) {
            for (int T = 0; T <= amount; T++) {
                int notTake = dp[idx - 1][T];
                int take = 0;
                if (coins[idx] <= T) {
                    take = dp[idx][T - coins[idx]]; // Stay at idx for unbounded knapsack
                }
                dp[idx][T] = take + notTake;
            }
        }
        return dp[n - 1][amount];
    }

    /*
     * Memoization (Top-Down Approach) - Note on previous TLE:
     * ----------------------------------------------------
     * The previous implementation timed out because it was missing the memoization lookup:
     *     if (dp[idx][target] != -1) return dp[idx][target];
     *
     * Without that lookup, storing `dp[idx][target] = take + notTake` was wasted, and the
     * recursion branched exponentially O(2^amount) like a brute force search.
     *
     * Below is the corrected memoization function with O(N * amount) complexity:
     *
     * public int changeMemo(int amount, int[] coins) {
     *     int n = coins.length;
     *     int[][] dp = new int[n][amount + 1];
     *     for (int[] row : dp) {
     *         Arrays.fill(row, -1);
     *     }
     *     return solve(n - 1, coins, amount, dp);
     * }
     *
     * public int solve(int idx, int[] coins, int target, int[][] dp) {
     *     if (idx == 0) {
     *         return (target % coins[0] == 0 ? 1 : 0);
     *     }
     *     // Essential check to avoid TLE:
     *     if (dp[idx][target] != -1) {
     *         return dp[idx][target];
     *     }
     *
     *     int notTake = solve(idx - 1, coins, target, dp);
     *     int take = 0;
     *     if (coins[idx] <= target) {
     *         take = solve(idx, coins, target - coins[idx], dp);
     *     }
     *     return dp[idx][target] = take + notTake;
     * }
     */

}
