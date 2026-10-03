package code.dynamic_programming.bitmask_dp;

public class FairDistributionOfCookies {
    public static void main(String[] args) {
        int[] cookies = {8, 15, 10, 20, 8};
        int k = 2;
        FairDistributionOfCookies fairDistributionOfCookies = new FairDistributionOfCookies();
        int minUnfairnessValue = fairDistributionOfCookies.distributeCookies(cookies, k);
        System.out.println("Min unfairness value: " + minUnfairnessValue);

    }

    public int distributeCookies(int[] cookies, int k) {
        int[] ans = new int[]{Integer.MAX_VALUE};
        int[] children = new int[k];
        backtrack(cookies, k, children, ans, 0);
        return ans[0];


    }

    public void backtrack(int[] cookies, int k, int[] children, int[] ans, int idx) {
        //base case
        if (idx == cookies.length) {
            int maxVal = 0;
            for (int val : children) {
                maxVal = Math.max(maxVal, val);
            }
            ans[0] = Math.min(maxVal, ans[0]);
            return;

        }

        //try all the combinations
        for (int j = 0; j < k; j++) {
            //prune branch if unfairness would exceed current best
            if (children[j] + cookies[idx] >= ans[0]) {
                continue;
            }

            children[j] += cookies[idx];
            backtrack(cookies, k, children, ans, idx + 1);
            children[j] -= cookies[idx];

            //symmetery breadking for empty children
            if (children[j] == 0) {
                break;

            }
        }
    }
}
