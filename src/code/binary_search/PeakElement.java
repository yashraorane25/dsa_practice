package code.binary_search;

public class PeakElement {
    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 3, 5, 6, 4};
        PeakElement peak = new PeakElement();
        int idx = peak.findPeakElement(nums);
        System.out.println("The index of peak eleemnt is : " + idx);
    }

    public int findPeakElement(int[] nums) {
        int n = nums.length;
        if (n == 1) return 0;
        if (nums[0] > nums[1]) return 0;
        if (nums[n - 1] > nums[n - 2]) return n - 1;

        int low = 1;
        int high = n-2;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > nums[mid + 1] && nums[mid] > nums[mid - 1]) {
                return mid;
            } else if (nums[mid] > nums[mid -1]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }


}
