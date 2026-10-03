package code.backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    public static void main(String[] args) {
        int n = 3;
        GenerateParenthesis gp = new GenerateParenthesis();
        List<String> res = gp.generateParenthesis(n);
        for (String val : res) {
            System.out.println(val);
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        int open = 0;
        int close = 0;
        solve(open, close, n, res, "");
        return res;
    }

    private void solve(int open, int close, int n, List<String> res, String s) {
        if (open == n && close == n) {
            res.add(s);
            return;
        }
        if (open < n) {
            solve(open + 1, close, n, res, s + "(");
        }
        if (close < open) {
            solve(open, close + 1, n, res, s + ")");
        }
    }


}
