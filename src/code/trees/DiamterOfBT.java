package code.trees;

import code.util.TreeNode;

public class DiamterOfBT {
    public static void main(String[] args) {
        // Construct the tree:
        //        1
        //       / \
        //      2   3
        //     / \
        //    4   5
        // Expected diameter: 3 (path: 4 -> 2 -> 1 -> 3)
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        DiamterOfBT solution = new DiamterOfBT();
        int result = solution.diameterOfBinaryTree(root);
        System.out.println("Diameter of Binary Tree: " + result);
    }

//    public int diameterOfBinaryTree(TreeNode root) {
//        if (root == null) return 0;
//        int maxi = 0;
//        int lh = findHeight(root.left);
//        int rh = findHeight(root.right);
//        maxi = Math.max(maxi, lh + rh);
//        diameterOfBinaryTree(root.left);
//        diameterOfBinaryTree(root.right);
//        return maxi;
//    }

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        int lh = findHeight(root.left);
        int rh = findHeight(root.right);
        int currentDiameter = lh + rh;
        int leftDiameter = diameterOfBinaryTree(root.left);
        int rightDiameter = diameterOfBinaryTree(root.right);
        return Math.max(currentDiameter, Math.max(leftDiameter, rightDiameter));
    }

    public int findHeight(TreeNode node) {
        if (node == null) return 0;
        return 1 + Math.max(findHeight(node.left), findHeight(node.right));
    }


}
