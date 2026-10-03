package code.arrays;

public class MajorityElement {
    public static void main(String[] args) {
        MajorityElement majorityElementObj = new MajorityElement();
        int[] nums = {1, 1, 5, 5, 2, 2, 1, 1, 5, 5, 5};
        int res = majorityElementObj.majorityElement(nums);
        System.out.println("The majority element is : " + res);
    }

    public int majorityElement(int[] nums) {
        int cnt = 0;
        int candidate = 0;
        for (int num : nums) {
            if (cnt == 0) {
                candidate = num;
                cnt = 1;
            } else if (candidate == num) {
                cnt++;
            } else cnt--;
        }
        return candidate;
    }
}
