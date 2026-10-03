package code.dynamic_programming.graph_dp;

import code.util.TreeNode;

public class BinaryTreeCameras {
    private int cameras = 0;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        TreeNode node1 = new TreeNode(0);
        TreeNode node2 = new TreeNode(0);
        TreeNode node3 = new TreeNode(0);
        TreeNode node4 = new TreeNode(0);
        root.left = node1;
        node1.left = node2;
        node2.left = node3;
        node3.right = node4;
        BinaryTreeCameras cameras = new BinaryTreeCameras();
        int res = cameras.minCameraCover(root);
        System.out.println("Minimum no of cameras required are: " + res);
    }

    public int minCameraCover(TreeNode root) {
        cameras = 0;
        if (dfs(root) == 0) {
            cameras++;
        }
        return cameras;
    }

    public int dfs(TreeNode node) {
        if (node == null) return 2;
        int left = dfs(node.left);
        int right = dfs(node.right);
        if (left == 0 || right == 0) {
            cameras++;
            return 1;
        }
        if (left == 1 || right == 1) {
            return 2;
        }
        return 0;

    }
}
