package dynamic_programming.one_dp.zero_one_knapsack;

import java.util.HashSet;
import java.util.Set;

public class PartitionEqualSubsetSum {
    public static void main(String[] args) {
        int[] nums = {3, 3, 3, 4, 5};
        PartitionEqualSubsetSum partitionEqualSubsetSum = new PartitionEqualSubsetSum();
        boolean isPartitionPossible = partitionEqualSubsetSum.canPartition(nums);
        System.out.println("Is Partition Possible: " + isPartitionPossible);
    }

    //Can we find any subset of nums that sums up to target?
    /*
      • Time Complexity: O(n × target) — In the worst case, the number of unique sums in dp is bounded by target.
        • Space Complexity: O(target) — Space used by the hash sets to store achievable sums.
    * */
    public boolean canPartition(int[] nums) {
        int sum = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        //for odd sum we cannot get the partition target value
        if (sum % 2 == 1) return false;
        // dp is a HashSet representing all possible subset sums formed so far.
        Set<Integer> dp = new HashSet<>();
        dp.add(0);
        int target = sum / 2;
        for (int i = n - 1; i >= 0; i--) {
            Set<Integer> nextDp = new HashSet<>();
            for (Integer t : dp) {
                if (t + nums[i] == target) return true;
                nextDp.add(t + nums[i]);
                nextDp.add(t);
            }
            dp = nextDp;
        }
        return dp.contains(target);

    }
}
