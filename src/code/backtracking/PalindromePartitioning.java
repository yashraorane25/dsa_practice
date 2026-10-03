package code.backtracking;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public static void main(String[] args) {
        String s = "abba";
        PalindromePartitioning pp = new PalindromePartitioning();
        List<List<String>> res = pp.partition(s);
        for (List<String> list : res) {
            System.out.print("[");
            for (String val : list) {
                System.out.print(val);
            }
            System.out.print("]");
            System.out.println();
        }
    }

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        gap(s, new ArrayList<>(), res);
        return res;
    }

    private void gap(String s, List<String> partitions, List<List<String>> res) {
        if (s.isEmpty()) {
            res.add(new ArrayList<>(partitions));
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            String part = s.substring(0, i + 1);
            if (isPalindrome(part)) {
                partitions.add(part);
                gap(s.substring(i + 1), partitions, res);
                partitions.remove(partitions.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String part) {
        int left = 0;
        int right = part.length() - 1;
        while (left <= right) {
            if (part.charAt(left++) != part.charAt(right--)) {
                return false;
            }
        }
        return true;
    }
}
