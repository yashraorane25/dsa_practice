package trees;

import util.TreeNode;

public class ConvertSortedToBST {
    public static void main(String[] args) {
        int[] nums = {-10, -3, 0, 5, 9};
        ConvertSortedToBST convert = new ConvertSortedToBST();
        TreeNode root = convert.sortedArrayToBST(nums);
    }

    public void printInorder(TreeNode root) {
        if (root == null) return;
        printInorder(root.left);
        System.out.println(root.val);
        printInorder(root.right);
    }


    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    public TreeNode helper(int[] nums, int low, int high) {
        if (low > high) {
            return null;
        }
        int mid = low + (high - low) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, low, mid - 1);
        root.right = helper(nums, mid + 1, high);
        return root;
    }

}
