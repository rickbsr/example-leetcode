package com.rick.problems;

import com.rick.common.TreeNode;

public class SumOfLeftLeaves {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        int res = new SumOfLeftLeaves().sumOfLeftLeaves(root);
        System.out.println(res);
    }

    public int sumOfLeftLeaves(TreeNode root) {
        return dfs(root, false);
    }

    private int dfs(TreeNode root, boolean isLeft) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return isLeft == true ? root.val : 0;
        return dfs(root.left, true) + dfs(root.right, false);
    }
}
