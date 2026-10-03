package code.stacks;

import java.util.Stack;

public class DailyTemperatures {
    public static void main(String[] args) {
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        DailyTemperatures dt = new DailyTemperatures();
        int[] res = dt.dailyTemperatures(temperatures);
        for (int val : res) {
            System.out.println(val);
        }
    }

    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> st = new Stack<>();

        int n = temperatures.length;
        int[] res = new int[n];
        for (int i = n - 1; i >= 0; i--) {

            while (!st.isEmpty() && temperatures[st.peek()] <= temperatures[i]) {
                st.pop();
            }
            if (!st.isEmpty()) {
                res[i] = st.peek() - i;
            }
            st.push(i);
        }
        return res;
    }
}
