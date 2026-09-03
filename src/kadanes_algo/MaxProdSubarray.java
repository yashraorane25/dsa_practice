package kadanes_algo;

public class MaxProdSubarray {
    public static void main(String[] args) {
        int[] nums = {-2, 3, -4};
        MaxProdSubarray mp = new MaxProdSubarray();
        int prod = mp.maxProd(nums);
        System.out.println(prod);
    }

    public int maxProd(int[] nums) {
        int n = nums.length;
        int leftProd = 1;
        int rightProd = 1;
        int ans = nums[0];
        for (int i = 0; i < n; i++) {
            leftProd = leftProd == 0 ? 1 : leftProd;
            rightProd = rightProd == 0 ? 1 : rightProd;
            leftProd = leftProd * nums[i];
            rightProd = rightProd * nums[n - i - 1];
            ans = Math.max(ans, Math.max(leftProd, rightProd));
        }
        return ans;
    }
}
