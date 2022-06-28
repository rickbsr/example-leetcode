package com.rick.problems;

import com.rick.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(4);
        root.left.left.left = new TreeNode(9);
        root.left.left.right = new TreeNode(2);
        root.right.right.right = new TreeNode(1);
        int sum = 22;
        List<List<Integer>> res = new PathSumII().pathSum(root, sum);
        System.out.println(res);
    }

    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        dfs(new ArrayList<>(), root, sum);
        return result;
    }

    private void dfs(List<Integer> list, TreeNode root, int sum) {
        if (root == null) return;
        list.add(root.val);
        sum -= root.val;
        if (root.left == null && root.right == null) {
            if (sum == 0) result.add(list);
            return;
        }
        dfs(new ArrayList<>(list), root.left, sum);
        dfs(new ArrayList<>(list), root.right, sum);
    }
}
