package code.binary_search;

public class FindTargetPositions {
    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        //int[] nums = {1, 2, 3, 4, 5};
        int target = 8;
        FindTargetPositions findTargetPositions = new FindTargetPositions();
        int[] ans = findTargetPositions.searchRange(nums, target);
        System.out.println("[" + ans[0] + "," + ans[1] + "]");
    }

    public int[] searchRange(int[] nums, int target) {
        return new int[]{findFirst(nums, target), findLast(nums, target)};
    }


    private int findFirst(int[] nums, int target) {
        int low = 0, high = nums.length - 1, result = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                result = mid;
                high = mid - 1; // keep searching left
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return result;
    }

    private int findLast(int[] nums, int target) {
        int low = 0, high = nums.length - 1, result = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                result = mid;
                low = mid + 1; // keep searching right
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return result;
    }


//    public int[] searchRange(int[] nums, int target) {
//        int[] ans = new int[2];
//        ans[0] = -1;
//        ans[1] = -1;
//        boolean isStartFound = false;
//        int lastIdx = -1;
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] == target && !isStartFound) {
//                ans[0] = i;
//                isStartFound = true;
//            }
//            if (nums[i] == target && isStartFound) {
//                lastIdx = i;
//            }
//
//        }
//        if (isStartFound && lastIdx != -1) {
//            ans[1] = lastIdx;
//        }
//        return ans;
//    }
}
