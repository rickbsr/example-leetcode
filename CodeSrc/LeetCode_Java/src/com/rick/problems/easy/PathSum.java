package com.rick.problems.easy;

import com.rick.common.TreeNode;

import java.util.Stack;

public class PathSum {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.right.right = new TreeNode(1);
        int sum = 22;
        boolean res = new PathSum().hasPathSum(root, sum);
        System.out.println(res);
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false; // 遞迴起手式，終止點
        else if (root.left == null && root.right == null // 代表為葉
                && root.val == sum) return true; // 總和符合條件
        // 代表有 children
        return hasPathSum(root.left, sum - root.val)
                || hasPathSum(root.right, sum - root.val);
    }

    public boolean hasPathSumByLoop(TreeNode root, int sum) {
        Stack<TreeNode> trees = new Stack<>();
        Stack<Integer> sums = new Stack<>();
        trees.push(root);
        sums.push(sum);
        while (!trees.isEmpty() && (root != null)) {
            int target = sums.pop();
            TreeNode top = trees.pop();
            if (top.left == null && top.right == null
                    && top.val == target) return true;
            if (top.right != null) {
                trees.push(top.right);
                sums.push(target - top.val);
            }
            if (top.left != null) {
                trees.push(top.left);
                sums.push(target - top.val);
            }
        }
        return false;
    }
}
