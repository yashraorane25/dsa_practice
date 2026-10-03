package code.dynamic_programming.one_dp.zero_one_knapsack;

import java.util.HashMap;
import java.util.Map;

public class TargetSum {
    public static void main(String[] args) {
        int[] nums = {
                1, 1, 1, 1, 1
        };
        int target = 3;
        TargetSum targetSum = new TargetSum();
        int noOfWaysPossible = targetSum.findTargetSumWays(nums, target);
        System.out.println("No of possible ways: " + noOfWaysPossible);
    }

    public int findTargetSumWays(int[] nums, int target) {
        Map<Integer, Integer> dp = new HashMap<>();
        //only one ways possible for sum 0
        dp.put(0, 1);

        for (int num : nums) {
            //create temp map for current iteration
            Map<Integer, Integer> nextDp = new HashMap<>();
            //for every possible sum in dp, add and subtract the current number
            for (int sum : dp.keySet()) {
                int count = dp.get(sum);

                //add the current number to sum
                nextDp.put(sum + num, nextDp.getOrDefault(sum + num, 0) + count);
                //subtract the current number from sum
                nextDp.put(sum - num, nextDp.getOrDefault(sum - num, 0) + count);
            }
            dp = nextDp;
        }
        return dp.getOrDefault(target, 0);
    }
}
