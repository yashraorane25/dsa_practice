package hashtables;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class IsomorphicStrings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter string s");
        String s = sc.next();
        System.out.println("Enter string t");
        String t = sc.next();

        IsomorphicStrings is = new IsomorphicStrings();
        boolean result = is.isIsomorphic(s, t);
        System.out.println("Is isomorphic: " + result);
    }

    //paper
    //title
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> mpp1 = new HashMap<>();
        Map<Character, Character> mpp2 = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);

            // Check s -> t mapping
            if (mpp1.containsKey(charS) && mpp1.get(charS) != charT) {
                return false;
            }
            // Check t -> s mapping
            if (mpp2.containsKey(charT) && mpp2.get(charT) != charS) {
                return false;
            }

            mpp1.put(charS, charT);
            mpp2.put(charT, charS);
        }
//        int n = s.length();
//        for (int i = 0; i < n; i++) {
//            if (!mpp1.containsKey(s.charAt(i))) {
//                mpp1.put(s.charAt(i), t.charAt(i));
//            }
//            if (!mpp2.containsKey(t.charAt(i))) {
//                mpp2.put(t.charAt(i), s.charAt(i));
//            } else if (mpp1.get(s.charAt(i)) != t.charAt(i) && mpp2.get(t.charAt(i)) != s.charAt(i)) {
//                return false;
//            }
//        }
        return true;
    }
}
