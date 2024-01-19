package com.rick.problems.easy;

import com.rick.common.TreeNode;

import java.util.Stack;

public class PathSum {

    public static void main(String[] args) {
        TreeNode root = initTreeNode();
        int sum = 22;
        boolean res;
        res = new PathSumRecursion().hasPathSum(root, sum);
        res = new PathSumLoop().hasPathSum(root, sum);
        System.out.println(res);
    }

    private static TreeNode initTreeNode() {
        TreeNode treeNode = new TreeNode(5);

        treeNode = new TreeNode(4);
        treeNode.right = new TreeNode(8);
        treeNode.left.left = new TreeNode(11);
        treeNode.right.left = new TreeNode(13);
        treeNode.right.right = new TreeNode(4);
        treeNode.left.left.left = new TreeNode(7);
        treeNode.left.left.right = new TreeNode(2);
        treeNode.right.right.right = new TreeNode(1);

        return treeNode;
    }
}

/**
 * 方式一、遞迴法
 */
class PathSumRecursion {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        if (root.left == null && root.right == null) return targetSum == root.val;
        return hasPathSum(root.left, targetSum - root.val)
                || hasPathSum(root.right, targetSum - root.val);
    }
}

/**
 * 方式二、迴圈法
 */
class PathSumLoop {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        Stack<TreeNode> trees = new Stack<>();
        Stack<Integer> sums = new Stack<>();
        trees.push(root);
        sums.push(targetSum);
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