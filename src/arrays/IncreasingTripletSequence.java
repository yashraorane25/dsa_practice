package arrays;

public class IncreasingTripletSequence {
    public static void main(String[] args) {
        int[] nums = {20, 100, 10, 12, 5, 13};
        IncreasingTripletSequence its = new IncreasingTripletSequence();
        boolean isIncreasing = its.increasingTriplet(nums);
        System.out.println("Is Increasing found: " + isIncreasing);
    }

    public boolean increasingTriplet(int[] nums) {
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;
        for (int val : nums) {
            if (val <= first) first = val;
            else if (val <= second)
                second = val;
            else {
                return true;
            }

        }
        return false;
    }

//    public boolean increasingTriplet(int[] nums) {
//        int n = nums.length;
//        int[] leftMin = new int[n];
//        int[] rightMax = new int[n];
//        leftMin[0] = nums[0];
//        for (int i = 1; i < n; i++) {
//            leftMin[i] = Math.min(leftMin[i - 1], nums[i]);
//        }

//        rightMax[n - 1] = nums[n - 1];
//        for (int i = n - 2; i >= 0; i--) {
//            rightMax[i] = Math.max(rightMax[i + 1], nums[i]);
//        }

//        for (int i = 0; i < n; i++) {
//            if (leftMin[i] < nums[i] && rightMax[i] > nums[i]) return true;
//        }
//        return false;
//    }
}
