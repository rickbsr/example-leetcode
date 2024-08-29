package com.rick.problems;

import com.rick.common.TreeNode;

public class SubtreeOfAnotherTree {

    public static void main(String[] args) {
        TreeNode s = new TreeNode(4);
        s.left = new TreeNode(1);
        s.right = new TreeNode(4);

        TreeNode t = new TreeNode(1);

        boolean res = new SubtreeOfAnotherTree().isSubtree(s, t);
        System.out.println(res);
    }

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) return false;
        if (isSame(s, t)) return true;
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    private boolean isSame(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        if (s.val != t.val) return false;
        return isSame(s.left, t.left) && isSame(s.right, t.right);
    }
}
