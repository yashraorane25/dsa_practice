package code.dynamic_programming.graph_dp;

import code.util.TreeNode;

public class HouseRobberThree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode rootLeft = new TreeNode(4);
        TreeNode rootRight = new TreeNode(5);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(1);
        root.left = rootLeft;
        root.right = rootRight;
        rootLeft.left = node1;
        rootLeft.right = node2;
        rootRight.right = node3;
        HouseRobberThree houseRobberThree = new HouseRobberThree();
        int maxAmountLooted = houseRobberThree.rob(root);
        System.out.println("The max amount looted is : " + maxAmountLooted);
    }

    public int rob(TreeNode root) {
        int[] options = travel(root);
        return Math.max(options[0], options[1]);
    }

    public int[] travel(TreeNode root) {
        //base case
        if (root == null) return new int[2];
        int[] left_node_choices = travel(root.left);
        int[] right_node_choices = travel(root.right);
        int[] options = new int[2];
        options[0] = root.val + left_node_choices[1] + right_node_choices[1];
        options[1] = Math.max(left_node_choices[0], left_node_choices[1]) + Math.max(right_node_choices[0], right_node_choices[1]);
        return options;
    }


}
