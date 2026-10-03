package code.prefix_sum;

import java.util.HashMap;
import java.util.Map;

public class ContiguosArray {
    public static void main(String[] args) {
        ContiguosArray ca = new ContiguosArray();
        //int[] nums = {0, 1, 1, 1, 1, 1, 0, 0, 0};
        int[] nums={0,1};
        int maxLength = ca.findMaxLength(nums);
        System.out.println("Max Length: " + maxLength);
    }

    public int findMaxLength(int[] nums) {
        int n = nums.length;
        int[] prefixSum = new int[n];
        int maxLeng = 0;
        Map<Integer, Integer> mpp = new HashMap<>();
        mpp.put(0, -1);
        prefixSum[0] = nums[0] == 0 ? -1 : 1;

        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + (nums[i] == 0 ? -1 : 1);

        }
        for (int i = 0; i < n; i++) {
            if (!mpp.containsKey(prefixSum[i])) {
                mpp.put(prefixSum[i], i);
            } else {
                int val = mpp.get(prefixSum[i]);
                int range = i - val;
                maxLeng = Math.max(maxLeng, range);
            }
        }

        return maxLeng;
    }
}
