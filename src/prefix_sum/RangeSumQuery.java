package prefix_sum;


import java.util.ArrayList;
import java.util.List;

public class RangeSumQuery {


    int[] prefix;

    RangeSumQuery(int[] nums) {
        prefix = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        return prefix[right+1] - prefix[left];
    }

    public static void main(String[] args) {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        RangeSumQuery rs = new RangeSumQuery(nums);
        System.out.println(rs.sumRange(0, 2));
        System.out.println(rs.sumRange(2, 5));
    }


}
