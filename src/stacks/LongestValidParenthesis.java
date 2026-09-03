package stacks;

import java.util.Stack;

public class LongestValidParenthesis {
    public static void main(String[] args) {
        String s = ")()()(";
        LongestValidParenthesis vp = new LongestValidParenthesis();
        int sizeOfLongest = vp.longestValidParentheses(s);
        System.out.println("Size of longest: " + sizeOfLongest);

    }

    public int longestValidParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        int maxLen = 0;
        st.push(-1);
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                st.add(i);
            } else if (s.charAt(i) == ')') {
                st.pop();
                if (st.isEmpty()) {
                    st.push(i);
                } else {
                    maxLen = Math.max(maxLen, i - st.peek());
                }
            }
        }
        return maxLen;
//        int cnt = 0;
//        for (int i = 0; i < s.length(); i++) {
//            if (st.isEmpty()) {
//                st.add(s.charAt(i));
//            } else {
//                if (s.charAt(i) == ')' && st.peek() == '(') {
//                    cnt += 2;
//                    st.pop();
//                } else {
//                    st.add(s.charAt(i));
//                }
//            }
//        }
//        return cnt;

    }
}
