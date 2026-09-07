package dynamic_programming.lis;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] nums = {3, 4, -1, 0, 6, 2, 3};
        LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
        int lengthOfSubsequence = lis.lengthOfLIS(nums);
        System.out.println("Length of longest subsequence: " + lengthOfSubsequence);
    }

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                    }
                }
            }
        }

        int maxIdx = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i] > dp[maxIdx]) {
                maxIdx = i;
            }
        }
        return dp[maxIdx] + 1;
    }
}
