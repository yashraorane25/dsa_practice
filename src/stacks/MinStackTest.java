package stacks;
import java.util.Stack;

public class MinStackTest {

    static class MinStack {
        Stack<Long> st = null;
        long mini;

        MinStack() {
            st = new Stack<>();
            mini = Long.MAX_VALUE;
        }

        public void push(int x) {
            long val = x;
            if (st.isEmpty()) {
                mini = val;
                st.push(val);
            } else {
                if (val >= mini) {
                    st.push(val);
                } else {
                    st.push(2 * val - mini);
                    mini = val;
                }
            }
        }

        public void pop() {
            if (st.isEmpty())
                return;
            long x = st.peek();
            st.pop();
            if (x < mini) {
                mini = 2 * mini - x;
            }

        }

        public int top() {
            if (st.isEmpty())
                return -1;
            long x = st.peek();
            if (mini < x) {
                return (int) x;
            } else
                return (int) mini;
        }

        public int getMin() {
            return (int) mini;
        }
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(15);
        minStack.push(12);
        minStack.push(10);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        minStack.push(10);
        System.out.println(minStack.top());

    }

}
