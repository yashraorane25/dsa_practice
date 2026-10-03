package code.hashtables;

import java.util.HashSet;

public class ContainsDuplicateTwo {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        int k = 3;
        ContainsDuplicateTwo cd2 = new ContainsDuplicateTwo();
        boolean isDuplicatePresent = cd2.containsNearbyDuplicate(nums, k);
        System.out.println(isDuplicatePresent);
    }

    //using sliding window
    /*
    Here's the idea: maintain a hash set that contains exactly the elements in a window of size k.
    As we move through the array, we add the current element to the set.
    If it's already there, we found a nearby duplicate. If the set grows beyond size k, we remove the oldest element (the one that just fell out of the window).
    This is a classic sliding window pattern.
    The window represents the "neighborhood" of size k around the current index, and the set gives us O(1) membership checks within that window.
    * */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> hs = new HashSet<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (hs.contains(nums[i])) {
                return true;
            }
            hs.add(nums[i]);
            if (hs.size() > k) {
                hs.remove(nums[i - k]);
            }
        }
        return false;
    }

    // Using hashmap
//    public boolean containsNearbyDuplicate(int[] nums, int k) {
//        Map<Integer, Integer> mpp = new HashMap<>();
//        int n = nums.length;
//        for (int i = 0; i < n; i++) {
//            if (mpp.containsKey(nums[i]) && i - mpp.get(nums[i]) <= k) {
//
//                return true;
//            }
//
//            mpp.put(nums[i], i);
//
//        }
//        return false;
//
//    }
}
