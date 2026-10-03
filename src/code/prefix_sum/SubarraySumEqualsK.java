package code.prefix_sum;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {
    public static void main(String[] args) {
        SubarraySumEqualsK subarraySumEqualsK = new SubarraySumEqualsK();
        int[] nums = {3, 4, 7, 2, -3, 1, 4, 2};
        int k = 7;
        int res = subarraySumEqualsK.subarraySum(nums, k);
        System.out.println("No of subarrays: " + res);
    }

    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        int[] prefixSum = new int[n];
        prefixSum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }
        Map<Integer, Integer> mpp = new HashMap<>();
        for (int j = 0; j < n; j++) {
            if (prefixSum[j] == k) count++;
            if (mpp.containsKey(prefixSum[j] - k)) {
                count += mpp.get(prefixSum[j] - k);
            }
            mpp.put(prefixSum[j], mpp.getOrDefault(prefixSum[j], 0) + 1);
        }
        return count;
    }
}
