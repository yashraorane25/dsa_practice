package code.recursion;

import java.util.Stack;

public class DecodeString {
    public static void main(String[] args) {
        DecodeString ds = new DecodeString();
        String s = "3[a]2[bc]";
        String decodedString = ds.decodeString(s);
        System.out.println("Decoded string is : " + decodedString);
    }

    public String decodeString(String s) {
        Stack<Character> st = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c != ']') {
                st.push(c);
            } else {
                // extract inner string
                StringBuilder inner = new StringBuilder();
                while (!st.isEmpty() && st.peek() != '[') {
                    inner.append(st.pop());
                }
                st.pop(); // discard '['
                inner.reverse();

                // extract the number (may be multi-digit)
                StringBuilder numStr = new StringBuilder();
                while (!st.isEmpty() && Character.isDigit(st.peek())) {
                    numStr.append(st.pop());
                }
                int count = Integer.parseInt(numStr.reverse().toString());

                // push repeated string back onto stack
                for (char rc : inner.toString().repeat(count).toCharArray()) {
                    st.push(rc);
                }
            }
        }

        StringBuilder res = new StringBuilder();
        for (char c : st) {
            res.append(c);
        }
        return res.toString();
    }
}
