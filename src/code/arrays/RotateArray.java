package code.arrays;

public class RotateArray {
    public static void main(String[] args) {
        int[] nums = {-1, -100, 3, 99};
        int k = 2;
        RotateArray rotateArray = new RotateArray();
        rotateArray.rotate(nums, k);
        printArray(nums);
    }

    public void rotate(int[] nums, int k) {
        int n = nums.length;
        reverse(0, n - 1, nums);
        reverse(0, k - 1, nums);
        reverse(k, n - 1, nums);
    }

    public static void printArray(int[] nums) {
        for (int val : nums) {
            System.out.println(val);
        }
    }

    public void reverse(int start, int end, int[] nums) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;

        }
    }
}
