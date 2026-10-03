package code.sliding_window;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        MinimumWindowSubstring minimumWindowSubstring = new MinimumWindowSubstring();
        String s = "ADOBECODEBANC";
        String t = "ABC";
        String res = minimumWindowSubstring.minWindow(s, t);
        System.out.println("Minimum window substring is " + res);
    }

    public String minWindow(String s, String t) {
        int[] mapS = new int[256];
        int[] mapT = new int[256];
        for (char c : t.toCharArray()) {
            mapT[c]++;
        }
        int left = 0;

        int minLen = Integer.MAX_VALUE;
        int minStart = 0;
        for (int right = 0; right < s.length(); right++) {
            mapS[s.charAt(right)]++;
            while (compareMaps(mapT, mapS)) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    minStart = left;
                }
                mapS[s.charAt(left++)]--;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }

    private boolean compareMaps(int[] mapT, int[] mapS) {
        for (int i = 0; i < 256; i++) {
            if (mapT[i] > mapS[i]) {
                return false;
            }
        }
        return true;
    }
}
