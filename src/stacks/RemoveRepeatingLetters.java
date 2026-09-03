package stacks;

import java.util.HashMap;
import java.util.Stack;

public class RemoveRepeatingLetters {
    public static void main(String[] args) {
        RemoveRepeatingLetters rl = new RemoveRepeatingLetters();
        String s = "cbacdcbc";

        String res = rl.removeDuplicateLetters(s);
        System.out.println("The string after removing duplicates is: " + res);
    }

    public String removeDuplicateLetters(String s) {
        Stack<Character> st = new Stack();
        int[] lastIndex = new int[26];
        boolean[] seen = new boolean[26];
        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }
        for (int i = 0; i < s.length(); i++) {
            int curr = s.charAt(i) - 'a';
            if (seen[curr]) continue;
            while (!st.isEmpty() && st.peek() > s.charAt(i) && i < lastIndex[st.peek() - 'a']) {
                seen[st.peek() - 'a'] = false;
                st.pop();
            }
            st.push(s.charAt(i));
            seen[curr] = true;

        }
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.append(st.peek());
            st.pop();
        }

        return sb.reverse().toString();
    }


}
