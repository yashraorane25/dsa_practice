package code.stacks;

import java.util.Stack;

public class ValidParenthesis {
    public static void main(String[] args) {
        ValidParenthesis vp = new ValidParenthesis();
        String s = "()([]{})";
        boolean isValidParenthesis = vp.isValid(s);
        System.out.println(isValidParenthesis);
    }

    // Use a stack to match each closing bracket with its most recent opening bracket
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        char[] chArr = s.toCharArray();
        for (int i = 0; i < chArr.length; i++) {
            // If it's an opening bracket, push onto the stack
            if (chArr[i] == '(' || chArr[i] == '{' || chArr[i] == '[') {
                st.push(chArr[i]);
            } else {
                // Closing bracket with no matching opener — invalid
                if (st.isEmpty()) return false;
                // Pop the top and check if it matches the current closing bracket
                char c = st.pop();
                if ((chArr[i] == ')' && c != '(') ||
                    (chArr[i] == '}' && c != '{') ||
                    (chArr[i] == ']' && c != '[')) {
                    return false;
                }
            }
        }
        // If stack is empty, all brackets were matched
        return st.size() == 0 ? true : false;

    }
}