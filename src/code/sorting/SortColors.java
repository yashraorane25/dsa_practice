package code.sorting;

public class SortColors {
    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};
        SortColors sc = new SortColors();
        sc.sortColors(nums);
        for (int val : nums) {
            System.out.println(val);
        }
    }

    public void sortColors(int[] nums) {
        int n = nums.length;
        int start = 0;
        int mid = 0;
        int end = n - 1;
        int temp = 0;
        while (mid <= end) {
            switch (nums[mid]) {
                case 0:
                    temp = nums[mid];
                    nums[mid] = nums[start];
                    nums[start] = temp;
                    start++;
                    mid++;
                    break;

                case 1:
                    mid++;
                    break;

                case 2:
                    temp = nums[mid];
                    nums[mid] = nums[end];
                    nums[end] = temp;
                    end--;
                    break;
            }

        }
    }
}
