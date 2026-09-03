package sliding_window;

import java.util.Arrays;

public class PermutationInString {
    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eibdaooo";
        PermutationInString ps = new PermutationInString();
        boolean isPermutationPresent = ps.checkInclusion(s1, s2);
        System.out.println("Is Permutation Present: " + isPermutationPresent);

    }

    public boolean checkInclusion(String s1, String s2) {
        int[] freqArr1 = new int[26];
        int[] freqArr2 = new int[26];
        for (char c : s1.toCharArray()) {
            freqArr1[c - 'a']++;
        }
        for (int i = 0; i < s2.length(); i++) {
            freqArr2[s2.charAt(i) - 'a']++;
            if (i >= s1.length()) {
                freqArr2[s2.charAt(i - s1.length()) - 'a']--;
            }
            if (Arrays.equals(freqArr1, freqArr2)) {
                return true;
            }
        }
        return false;
    }
}
