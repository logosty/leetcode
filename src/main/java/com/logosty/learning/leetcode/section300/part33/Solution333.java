package com.logosty.learning.leetcode.section300.part33;

import com.logosty.learning.util.pojo.TreeNode;

/**
 * @author logosty(ganyingle) on 2023/12/5 15:54
 * description: Largest BST Subtree最大二叉搜索树子树 中等
 * Given a binary tree, find the largest subtree which is a Binary Search Tree (BST), where largest means subtree
 * with largest number of nodes in it.
 * <p>
 * Note:
 * A subtree must include all of its descendants.
 * Here's an example:
 * <p>
 * 10
 * / \
 * 5  15
 * / \   \
 * 1   8   7
 * The Largest BST Subtree in this case is the highlighted one.
 * The return value is the subtree's size, which is 3.
 * <p>
 * <p>
 * <p>
 * 题意：
 * <p>
 * 给定二叉树，找出最大的二叉搜索树子树头结点。
 */
public class Solution333 {
    public TreeNode largestBSTSubtree(TreeNode root) {
        if (root == null) {
            return root;
        }
        Info info = process(root);

        return info.largestBSTSubtree;
    }
    public static class Info{
        private TreeNode largestBSTSubtree;
        private int largestBSTSubtreeSize;
        private int minValue;
        private int maxValue;
        private boolean isBST;
    }

    private Info process(TreeNode node) {
        Info info = new Info();
        info.isBST = true;
        info.maxValue = Integer.MIN_VALUE;
        info.minValue = Integer.MAX_VALUE;
        info.largestBSTSubtree = null;

        if (node == null) {
            return info;
        }

        Info leftInfo = process(node.left);
        Info rightInfo = process(node.right);

        //任意一遍不是搜索树，那就整个树都只能是子树中的值了
        if (!leftInfo.isBST || !rightInfo.isBST) {
            info.isBST = false;
            if (leftInfo.largestBSTSubtreeSize > rightInfo.largestBSTSubtreeSize) {
                info.largestBSTSubtreeSize = leftInfo.largestBSTSubtreeSize;
                info.largestBSTSubtree = leftInfo.largestBSTSubtree;
            } else {
                info.largestBSTSubtreeSize = rightInfo.largestBSTSubtreeSize;
                info.largestBSTSubtree = rightInfo.largestBSTSubtree;
            }
            return info;
        }

        //两边都是搜索子树，需要看看子项是否满足
        info.maxValue = Math.max(leftInfo.maxValue, rightInfo.maxValue);
        info.minValue = Math.min(leftInfo.minValue, rightInfo.minValue);

        //本身不是搜索树
        if (node.val < leftInfo.maxValue || node.val > rightInfo.minValue) {
            info.isBST = false;
            if (leftInfo.largestBSTSubtreeSize > rightInfo.largestBSTSubtreeSize) {
                info.largestBSTSubtreeSize = leftInfo.largestBSTSubtreeSize;
                info.largestBSTSubtree = leftInfo.largestBSTSubtree;
            } else {
                info.largestBSTSubtreeSize = rightInfo.largestBSTSubtreeSize;
                info.largestBSTSubtree = rightInfo.largestBSTSubtree;
            }
            return info;
        }

        //本身也是子树，那就是两边size相加再加自己
        info.largestBSTSubtree = node;
        info.largestBSTSubtreeSize = leftInfo.largestBSTSubtreeSize + info.largestBSTSubtreeSize + 1;

        return info;
    }
}
