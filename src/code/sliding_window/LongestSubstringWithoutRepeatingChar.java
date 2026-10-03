package code.sliding_window;

import java.util.Arrays;

public class LongestSubstringWithoutRepeatingChar {
    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingChar ls = new LongestSubstringWithoutRepeatingChar();
        String s = "abcabcbb";
        int lengthOfSubstring = ls.lengthOfLongestSubstring(s);
        System.out.println("Longest substring length: " + lengthOfSubstring);
    }

//    public int lengthOfLongestSubstring(String s) {
//        int left = 0;
//        int right = 0;
//        int maxLen = 0;
//        int[] freq = new int[128];
//        while (right < s.length()) {
//            if (freq[s.charAt(right)] == 0) {
//                freq[s.charAt(right)]++;
//                right++;
//                maxLen = Math.max(maxLen, right - left);
//            } else {
//                freq[s.charAt(left)]--;
//                left++;
//            }
//        }
//        return maxLen;
//    }

    public int lengthOfLongestSubstring(String s) {
        int[] lastIndex = new int[128];
        Arrays.fill(lastIndex, -1);
        int left = 0;
        int maxLen = 0;
        for (int right = 0; right < s.length(); right++) {
            if (lastIndex[s.charAt(right)] >= left) {
                left = lastIndex[s.charAt(right)] + 1;
            }
            lastIndex[s.charAt(right)] = right;
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}
