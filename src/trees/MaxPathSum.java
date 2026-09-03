package trees;

import util.TreeNode;

public class MaxPathSum {
    public static void main(String[] args) {
        // Construct the tree:
        //        -10
        //        / \
        //       9  20
        //         /  \
        //        15   7
        // Expected max path sum: 42 (path: 15 -> 20 -> 7)
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        MaxPathSum solution = new MaxPathSum();
        int result = solution.maxPathSum(root);
        System.out.println("Max Path Sum: " + result); // Expected: 42
    }

    public int maxPathSum(TreeNode root) {
        int[] maxi = new int[1];
        maxi[0] = Integer.MIN_VALUE;
        maxPath(root, maxi);
        return maxi[0];
    }

    private int maxPath(TreeNode node, int[] maxi) {
        if (node == null) return 0;
        //clamp negative branch sums to 0 using the math.max
        int leftSum = Math.max(maxPath(node.left, maxi), 0);
        int rightSum = Math.max(maxPath(node.right, maxi), 0);
        maxi[0] = Math.max(maxi[0], leftSum + rightSum + node.val);
        return node.val + Math.max(leftSum, rightSum);

    }

}
