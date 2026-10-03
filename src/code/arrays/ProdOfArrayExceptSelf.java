package code.arrays;

public class ProdOfArrayExceptSelf {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        ProdOfArrayExceptSelf prodOfArrayExceptSelfObj = new ProdOfArrayExceptSelf();
        int[] res = prodOfArrayExceptSelfObj.productExceptSelf(nums);
        printArray(res);


    }

    private static void printArray(int[] res) {
        for (int val : res) {
            System.out.println(val);
        }
    }

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        int prodTemp=1;
        for (int i = n-1; i >=0 ; i--) {
            res[i]*=prodTemp;
            prodTemp*=nums[i];
        }
        return res;

    }


}
