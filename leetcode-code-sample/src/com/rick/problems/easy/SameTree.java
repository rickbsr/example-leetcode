package com.rick.problems.easy;

import com.rick.common.TreeNode;

import java.util.*;

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

class SameTreeRecursion {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null) return q == null;
        if (q == null) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right) && (p.val == q.val);
    }
}

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