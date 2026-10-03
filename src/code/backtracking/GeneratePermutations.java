package code.backtracking;

import java.util.ArrayList;
import java.util.List;

public class GeneratePermutations {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        GeneratePermutations gp = new GeneratePermutations();
        List<List<Integer>> res = gp.permute(nums);
        for (List<Integer> list : res) {
            System.out.print("[");
            for (Integer val : list) {
                System.out.print(val);
            }
            System.out.print("]");
            System.out.println();
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), nums);
        return res;
    }

    public void backtrack(List<List<Integer>> res, List<Integer> tempList, int[] nums) {
        //base case
        if (tempList.size() == nums.length) {
            res.add(new ArrayList<>(tempList));
            return;
        }
        //iterate elements and backtrack
        for (int num : nums) {
            if (tempList.contains(num)) continue;
            tempList.add(num);
            backtrack(res, tempList, nums);
            tempList.remove(tempList.size() - 1);
        }
    }

}
