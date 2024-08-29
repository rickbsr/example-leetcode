package com.rick.problems;

import com.rick.common.TreeNode;

public class UnivaluedBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(1);
        root.right = new TreeNode(1);
        root.right.right = new TreeNode(1);
        boolean res = new UnivaluedBinaryTree().isUnivalTree(root);
        System.out.println(res);
    }

    public boolean isUnivalTree(TreeNode root) {

        // 判斷左邊的節點
        boolean left_correct = (root.left == null ||
                (root.val == root.left.val && isUnivalTree(root.left)));

        // 判斷右邊的節點
        boolean right_correct = (root.right == null ||
                (root.val == root.right.val && isUnivalTree(root.right)));
        return left_correct && right_correct;
    }
}
