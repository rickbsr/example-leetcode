package com.rick.problems.easy;

import com.rick.common.TreeNode;

import java.util.Iterator;
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
        res = new SameTreeRecursionPlus().isSameTree(p, q);
        res = new SameTreeLoop().isSameTree(p, q);
        res = new SameTreeLoopPlus().isSameTree(p, q);
        System.out.println(res);
    }
}

/**
 * 方式一、遞迴法
 */
class SameTreeRecursion {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        else if (p == null) return false;
        else if (q == null) return false;
        else if (p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}

/**
 * 方式一、遞迴法（優化）
 */
class SameTreeRecursionPlus {
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
        Stack<TreeNode> pTrees = preOrder(p), qTrees = preOrder(q);
        if (pTrees.size() != qTrees.size()) return false;
        Iterator<TreeNode> pIterator = pTrees.iterator(), qIterator = qTrees.iterator();
        while (pIterator.hasNext()) {
            TreeNode pNode = pIterator.next(), qNode = qIterator.next();
            if (pNode == null && qNode != null || qNode == null && pNode != null || pNode != null && pNode.val != qNode.val)
                return false;
        }
        return true;
    }

    public Stack<TreeNode> preOrder(TreeNode root) {
        Stack<TreeNode> rootTrees = new Stack<>(), orderTrees = new Stack<>();
        rootTrees.push(root);
        while (!rootTrees.isEmpty()) {
            TreeNode currNode = rootTrees.pop();
            orderTrees.push(currNode);
            if (currNode != null) {
                rootTrees.push(currNode.right);
                rootTrees.push(currNode.left);
            }
        }
        return orderTrees;
    }
}

/**
 * 方式二、迴圈法（優化）
 */
class SameTreeLoopPlus {
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