package stacks;

import java.util.Stack;

public class LargestRectangleInHist {
    public static void main(String[] args) {
        LargestRectangleInHist lect = new LargestRectangleInHist();
        int[] heights = {2, 1, 5, 6, 2, 3};
        int maxArea = lect.largestRectangleArea(heights);
        System.out.println(maxArea);
    }

    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int maxArea = 0;
        int n = heights.length;
        int nse = 0;
        int pse = 0;
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && heights[st.peek()] > heights[i]) {
                int idx = st.peek();
                st.pop();
                nse = i;
                pse = st.isEmpty() ? -1 : st.peek();
                maxArea = Math.max(maxArea, (nse - pse - 1) * heights[idx]);

            }
            st.push(i);
        }
        while (!st.isEmpty()) {
            nse = n;
            int idx = st.peek();
            st.pop();
            pse = st.isEmpty() ? -1 : st.peek();
            maxArea = Math.max(maxArea, (nse - pse - 1) * heights[idx]);
        }
        return maxArea;
    }

}
