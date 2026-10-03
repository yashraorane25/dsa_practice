package code.backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateSubsets {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        GenerateSubsets gs = new GenerateSubsets();
        List<List<Integer>> res = gs.subsets(nums);
        for (List<Integer> list : res) {
            System.out.print("[");
            for (Integer val : list) {
                System.out.print(val);
            }
            System.out.print("]");
            System.out.println();
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), 0, nums);
        return res;


    }

    public void backtrack(List<List<Integer>> res, List<Integer> tempList, int idx, int[] nums) {
        if (idx == nums.length) {
            res.add(new ArrayList<>(tempList));
            return;
        }
        tempList.add(nums[idx]);
        backtrack(res, tempList, idx + 1, nums);
        tempList.remove(tempList.size() - 1);
        backtrack(res, tempList, idx + 1, nums);

    }
}
