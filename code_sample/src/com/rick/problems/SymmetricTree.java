package com.rick.problems;

import com.rick.common.TreeNode;

public class SymmetricTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.right.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(5);
        boolean res = new SymmetricTree().isSymmetric(root);
        System.out.println(res);
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return dfs(root.left, root.right);
    }

    private boolean dfs(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        if ((left.val == right.val) && dfs(left.left, right.right) && dfs(left.right, right.left)) return true;
        return false;
    }
}
