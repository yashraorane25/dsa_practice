package code.trees;

import code.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightSideViewOfBT {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(5);
        TreeNode node4 = new TreeNode(4);
        root.left = node1;
        root.right = node2;
        node1.right = node3;
        node2.right = node4;
        RightSideViewOfBT rightSide = new RightSideViewOfBT();
        List<Integer> res = rightSide.rightSideView(root);
        for (int val : res) {
            System.out.println(val);
        }

    }

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        q.add(root);
//        res.add(root.val);
        while (!q.isEmpty()) {
            int size = q.size();
            //List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode temp = q.poll();
                //level.add(temp.val);
                if (i == size - 1) {
                    res.add(temp.val);
                }
                if (temp.left != null) {
                    q.add(temp.left);
                }
                if (temp.right != null) {
                    q.add(temp.right);
                }
            }


        }
        return res;

    }
}
