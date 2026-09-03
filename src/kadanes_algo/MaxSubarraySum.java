package kadanes_algo;

public class MaxSubarraySum {
    public static void main(String[] args) {
        MaxSubarraySum max = new MaxSubarraySum();
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int sum = max.maxSubArray(nums);
        System.out.println(sum);
    }

    public int maxSubArray(int[] nums) {
        int currSum = nums[0];
        int maxSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currSum = Math.max(nums[i], currSum + nums[i]);
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }
}
