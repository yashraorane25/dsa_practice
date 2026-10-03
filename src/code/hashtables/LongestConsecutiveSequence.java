package code.hashtables;

import java.util.HashSet;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        LongestConsecutiveSequence lcs = new LongestConsecutiveSequence();
        int[] nums = {100, 4, 200, 1, 3, 2};
        int lengthOfLongest = lcs.longestConsecutive(nums);
        System.out.println(lengthOfLongest);
    }

    /**
     *  Algorithm
     * @param nums Insert all numbers into a hash set.
     *             Initialize longestStreak = 0.
     *             For each number num in the set:
     *             If num - 1 is NOT in the set, this is the start of a sequence.
     *             Count forward: check num + 1, num + 2, etc., incrementing a counter.
     *             Update longestStreak with the counter.
     *             Return longestStreak.
     */
    public int longestConsecutive(int[] nums) {

        int n = nums.length;
        HashSet<Integer> hs = new HashSet<>();
        for (int i = 0; i < n; i++) {
            hs.add(nums[i]);
        }
        int longest = 1;
        for (int num : nums) {
            if (!hs.contains(num - 1)) {
                int currNum = num;
                int currStreak = 1;
                while (hs.contains(currNum + 1)) {
                    currNum++;
                    currStreak++;
                }
                longest = Math.max(longest, currStreak);

            }
        }
        return longest;
    }


}
