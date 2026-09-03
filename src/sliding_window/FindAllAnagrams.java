package sliding_window;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllAnagrams {

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        FindAllAnagrams findObj = new FindAllAnagrams();
        List<Integer> res = findObj.findAnagrams(s, p);
        System.out.println(res);
    }

    public List<Integer> findAnagrams(String s, String p) {
        int[] sFreq = new int[26];
        int[] pFreq = new int[26];
        List<Integer> res = new ArrayList<>();
        // populate the freq array for p
        for (char c : p.toCharArray()) {
            pFreq[c - 'a']++;
        }

        //check for anangram
        for (int i = 0; i < s.length(); i++) {
            sFreq[s.charAt(i) - 'a']++;
            if (i >= p.length()) {
                sFreq[s.charAt(i - p.length()) - 'a']--;
            }
            if (Arrays.equals(sFreq, pFreq)) {
                res.add(i - p.length() + 1);
            }
        }
        return res;
    }
}
