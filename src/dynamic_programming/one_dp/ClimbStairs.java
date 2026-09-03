package dynamic_programming.one_dp;

public class ClimbStairs {

    public int climbStairs(int n) {
        int num1 = 1;
        int num2 = 1;
        for (int i = 0; i < n - 1; i++) {
            int temp = num1;
            num1 = num1 + num2;
            num2 = temp;
        }
        return num1;
    }

    public static void main(String[] args) {
        ClimbStairs cs = new ClimbStairs();
        int n = 3;
        int count = cs.climbStairs(n);
        System.out.println("No of steps required:" + count);
    }
}
