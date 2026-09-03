package hashtables;

import java.util.HashMap;
import java.util.Map;

public class TwoSumII {
    public static void main(String[] args) {
        TwoSumII twoSumII = new TwoSumII();
        int[] nums = {2, 3, 4};
        int target = 6;
        int[] res = twoSumII.twoSum(nums, target);
        System.out.println(res[0] + "," + res[1]);
    }

    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> mpp = new HashMap<>();
        int[] res = new int[2];
        int n = numbers.length;
        for (int i = 0; i < n; i++) {
            mpp.put(numbers[i], i);
        }
        for (int i = 0; i < n; i++) {
            int diff = target - numbers[i];
            if (mpp.containsKey(diff) && i < mpp.get(diff)) {
                return new int[]{i + 1, mpp.get(diff) + 1};
            }
        }
        return res;

    }
}
