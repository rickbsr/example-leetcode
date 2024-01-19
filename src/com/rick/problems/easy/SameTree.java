package com.rick.problems.easy;

import com.rick.common.TreeNode;

import java.util.Stack;

public class SameTree {

    public static void main(String[] args) {
        TreeNode p = new TreeNode('F');
        p.left = new TreeNode('B');
        p.left.left = new TreeNode('A');
        p.left.right = new TreeNode('D');
        p.left.right.left = new TreeNode('C');
        p.left.right.right = new TreeNode('E');
        p.right = new TreeNode('G');
        p.right.right = new TreeNode('I');
        p.right.right.left = new TreeNode('H');

        TreeNode q = new TreeNode(1);
        q.left = new TreeNode(2);
        q.right = new TreeNode(3);

        boolean res;

        res = new SameTreeRecursion().isSameTree(p, q);
        res = new SameTreeLoop().isSameTree(p, q);
        System.out.println(res);
    }
}

/**
 * 方式一、遞迴法
 */
class SameTreeRecursion {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null) return q == null;
        if (q == null) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right) && (p.val == q.val);
    }
}

/**
 * 方式二、迴圈法
 */
class SameTreeLoop {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Stack<TreeNode> pTrees = new Stack<>(), qTrees = new Stack<>();
        pTrees.push(p);
        qTrees.push(q);
        while (!pTrees.empty() && !qTrees.empty()) {
            TreeNode currP = pTrees.pop();
            TreeNode currQ = qTrees.pop();
            if (currP == null && currQ == null) continue;
            else if (currP == null || currQ == null || currP.val != currQ.val) return false;
            pTrees.push(currP.left);
            pTrees.push(currP.right);
            qTrees.push(currQ.left);
            qTrees.push(currQ.right);
        }
        return true;
    }
}