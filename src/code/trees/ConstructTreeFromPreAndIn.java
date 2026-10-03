package code.trees;

import code.util.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class ConstructTreeFromPreAndIn {
    public static void main(String[] args) {
        int[] preorder = {8, 2, 7, 1, 9, 3, 6};
        int[] inorder = {7, 2, 1, 8, 3, 9, 6};
        ConstructTreeFromPreAndIn construct = new ConstructTreeFromPreAndIn();
        TreeNode root = construct.buildTree(preorder, inorder);
        construct.printInorder(root);
    }

    public void printInorder(TreeNode root) {
        if (root == null) return;
        printInorder(root.left);
        System.out.println(root.val);
        printInorder(root.right);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inOrderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inOrderMap.put(inorder[i], i);
        }
        return splitTree(preorder, inOrderMap, 0, 0, inorder.length - 1);
    }

    /**
     * Recursively builds a binary tree from preorder and inorder traversal data.
     *
     * @param preorder   the full preorder array; preorder[rootIdx] is the current subtree root
     * @param inOrderMap maps each value to its index in the inorder array for O(1) lookup
     * @param rootIdx    index in preorder of the current subtree's root
     * @param left       left boundary (inclusive) of the current subtree in the inorder array
     * @param right      right boundary (inclusive) of the current subtree in the inorder array
     * @return the root TreeNode of the constructed subtree, or null if left > right
     */
    private TreeNode splitTree(int[] preorder, Map<Integer, Integer> inOrderMap, int rootIdx, int left, int right) {
        // base case: no nodes remain in this subtree
        if (left > right) return null;

        TreeNode root = new TreeNode(preorder[rootIdx]);

        // mid is the root's position in inorder, splitting left and right subtrees
        int mid = inOrderMap.get(preorder[rootIdx]);

        // left subtree root is immediately next in preorder (rootIdx + 1)
        root.left = splitTree(preorder, inOrderMap, rootIdx + 1, left, mid - 1);

        // right subtree root skips past all (mid - left) left-subtree nodes in preorder
        root.right = splitTree(preorder, inOrderMap, rootIdx + (mid - left) + 1, mid + 1, right);

        return root;
    }
}
