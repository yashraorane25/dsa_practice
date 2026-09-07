package dynamic_programming.string_dp;

import java.util.Arrays;

public class LongestPalindromicSubsequence {
    public static void main(String[] args) {
        String s = "bbbab";
        LongestPalindromicSubsequence lps = new LongestPalindromicSubsequence();
        int res = lps.longestPalindromeSubseq(s);
        System.out.println("The length of longest palindromic subsequence is : " + res);
    }

    public int longestPalindromeSubseq(String s) {
        StringBuilder sb = new StringBuilder(s);
        String rev = sb.reverse().toString();
        return longestCommonSubsequence(s, rev);
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m][n];
        for (int[] rows : dp) {
            Arrays.fill(rows, -1);
        }
        return solve(m - 1, n - 1, dp, text1, text2);
    }

    public int solve(int idx1, int idx2, int[][] dp, String text1, String text2) {
        if (idx1 < 0 || idx2 < 0) {
            return 0;
        }
        if (dp[idx1][idx2] != -1) return dp[idx1][idx2];
        if (text1.charAt(idx1) == text2.charAt(idx2)) {
            return dp[idx1][idx2] = 1 + solve(idx1 - 1, idx2 - 1, dp, text1, text2);
        }
        return dp[idx1][idx2] = Math.max(solve(idx1 - 1, idx2, dp, text1, text2), solve(idx1, idx2 - 1, dp, text1, text2));
    }
}
