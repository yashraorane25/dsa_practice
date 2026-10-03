package code.arrays;

public class FirstMissingPositive {
    public static void main(String[] args) {
        int[] nums = {3, -1, 7, 11, 1, 0, 2, 99, -3, 5};
        FirstMissingPositive fmp = new FirstMissingPositive();
        int missingPositive = fmp.firstMissingPositive(nums);
        System.out.println("First missing positive is: " + missingPositive);
    }

    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        //clean the array
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0 || nums[i] > nums.length) {
                nums[i] = nums.length + 1;
            }
        }

        //mark the presence
        for (int i = 0; i < n; i++) {
            int num = Math.abs(nums[i]);
            if (num > nums.length) continue;
            if (nums[num - 1] > 0) {
                nums[num - 1] = -nums[num - 1];
            }
        }
        //find the missing positive
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }
}
