package code.arrays;

public class RemoveDuplicateFromSortedArray {
    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        RemoveDuplicateFromSortedArray obj = new RemoveDuplicateFromSortedArray();
        int res = obj.removeDuplicates(nums);
        System.out.println("The number of elements are: " + res);
    }

    public int removeDuplicates(int[] nums) {
        int i = 0;
        int n = nums.length;
        for (int j = 0; j < n; j++) {
            if (nums[i] != nums[j]) {
                nums[i + 1] = nums[j];
                i++;
            }
        }
        return i + 1;
    }

}
