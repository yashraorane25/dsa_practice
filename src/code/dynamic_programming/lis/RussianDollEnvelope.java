package code.dynamic_programming.lis;

import java.util.Arrays;

public class RussianDollEnvelope {
    public static void main(String[] args) {
        int[][] envolopes = {{5, 4}, {6, 4}, {6, 7}, {2, 3}};
        RussianDollEnvelope russianDollEnvelope = new RussianDollEnvelope();
        int res = russianDollEnvelope.maxEnvelopes(envolopes);
        System.out.println("Max envelopes are: " + res);
    }

    /**
     * Finds the maximum number of envelopes that can be Russian-dolled (nested).
     * <p>
     * Core Strategy (Reduction to 1D LIS):
     * ------------------------------------
     * An envelope (w1, h1) fits inside (w2, h2) iff w1 < w2 AND h1 < h2 (strictly greater).
     * This is a 2D problem, but we can reduce it to a 1D Longest Increasing Subsequence (LIS):
     * <p>
     * 1. Sorting Strategy:
     * - Sort WIDTH in ASCENDING order (a[0] - b[0]).
     * - For EQUAL widths, sort HEIGHT in DESCENDING order (b[1] - a[1]).
     * <p>
     * Why sort height descending for equal widths?
     * Two envelopes with the same width cannot fit into each other (strict inequality required).
     * If we sorted heights ascending, e.g., [3, 4] and [3, 5], both heights (4 then 5)
     * could be picked in the increasing subsequence, which is invalid since both have width 3.
     * By sorting heights descending, e.g., [3, 5] then [3, 4], the LIS can never pick both
     * because 4 is not strictly greater than 5. This guarantees at most ONE envelope
     * of any given width is ever chosen!
     * <p>
     * 2. 1D LIS on Heights (Patience Sorting):
     * - Once sorted, the width condition is inherently respected.
     * - We only need to find the LIS of the HEIGHTS in O(N log N) time.
     * - dp[k] stores the minimum tail (height) of an increasing subsequence of length (k + 1).
     * - For each height:
     * - Binary search finds the first element in dp >= height (lower bound).
     * - If height is larger than all elements in dp, index == maxLen, so we extend the LIS.
     * - Otherwise, we overwrite dp[index] with this smaller/equal height, keeping tails as
     * small as possible to maximize chances of future extensions.
     * <p>
     * Complexity:
     * - Time Complexity: O(N log N) — O(N log N) for sorting + N * O(log N) for binary searches.
     * - Space Complexity: O(N) — for the dp array.
     */
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;

        // Step 1: Sort width ascending, and height descending for ties
        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);

        // dp[k] will store the smallest tail of all increasing subsequences of length k + 1
        int[] dp = new int[n];
        int maxLen = 0;

        // Step 2: Find LIS of heights using patience sorting
        for (int i = 0; i < dp.length; i++) {
            int height = envelopes[i][1];

            // Find insertion point (lower bound: first element >= height)
            int index = binarySearch(dp, 0, maxLen, height);

            dp[index] = height;

            // If inserted at the end, we extended the longest increasing subsequence
            if (index == maxLen) {
                maxLen++;
            }
        }
        return maxLen;
    }

    /**
     * Binary search to find the lower bound index:
     * Returns the index of the first element in arr[start...end-1] that is >= target.
     * If all elements are < target, returns end.
     */
    public int binarySearch(int[] arr, int start, int end, int target) {
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                end = mid;
            } else {
                start = mid + 1;
            }

        }
        return start;
    }


}
