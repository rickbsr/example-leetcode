package com.rick.problems;

import com.rick.common.TreeNode;

public class ConstructStringFromBinaryTree {

    public static void main(String[] args) {
        TreeNode t = new TreeNode(1);
        t.left = new TreeNode(2);
        t.right = new TreeNode(3);
        t.left.right = new TreeNode(4);
        String res = new ConstructStringFromBinaryTree().tree2str(t);
        System.out.println(res);
    }

    public String tree2str(TreeNode t) {
        if (t == null) return "";
        if (t.left != null && t.right != null)
            return t.val + "(" + tree2str(t.left) + ")" + "(" + tree2str(t.right) + ")";
        else if (t.left != null)
            return t.val + "(" + tree2str(t.left) + ")";
        else if (t.right != null)
            return t.val + "()" + "(" + tree2str(t.right) + ")";
        else return t.val + "";
    }
}
