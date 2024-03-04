package com.logosty.learning.leetcode.section100.part12;

import com.logosty.learning.util.TreeUtil;
import com.logosty.learning.util.pojo.TreeNode;

/**
 * @author logosty(ganyingle) on 2024/3/4 17:58
 * description: 124. 二叉树中的最大路径和 困难
 * 二叉树中的 路径 被定义为一条节点序列，序列中每对相邻节点之间都存在一条边。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
 * <p>
 * 路径和 是路径中各节点值的总和。
 * <p>
 * 给你一个二叉树的根节点 root ，返回其 最大路径和 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [1,2,3]
 * 输出：6
 * 解释：最优路径是 2 -> 1 -> 3 ，路径和为 2 + 1 + 3 = 6
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [-10,9,20,null,null,15,7]
 * 输出：42
 * 解释：最优路径是 15 -> 20 -> 7 ，路径和为 15 + 20 + 7 = 42
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中节点数目范围是 [1, 3 * 104]
 * -1000 <= Node.val <= 1000
 */
public class Solution124 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */

    public int maxPathSum(TreeNode root) {
        Info info = maxPathSumInfo(root);
        return Math.max(info.maxNotToFather, info.maxToFather);
    }

    private static class Info {
        int maxNotToFather;
        int maxToFather;

        public Info() {
        }

        public Info(int maxNotToFather, int maxToFather) {
            this.maxNotToFather = maxNotToFather;
            this.maxToFather = maxToFather;
        }
    }

    private Info maxPathSumInfo(TreeNode root) {
        if (root == null) {
            return new Info(Integer.MIN_VALUE, Integer.MIN_VALUE);
        }

        Info leftInfo = maxPathSumInfo(root.left);

        Info rightInfo = maxPathSumInfo(root.right);

        Info info = new Info();
        info.maxToFather = Math.max(0, Math.max(leftInfo.maxToFather, rightInfo.maxToFather)) + root.val;

        info.maxNotToFather = Math.max(leftInfo.maxNotToFather, rightInfo.maxNotToFather);

        int val = root.val;
        if (leftInfo.maxToFather > 0) {
            val += leftInfo.maxToFather;
        }
        if (rightInfo.maxToFather > 0) {
            val += rightInfo.maxToFather;
        }
        info.maxNotToFather = Math.max(val, info.maxNotToFather);

        return info;
    }

    public static void main(String[] args) {
        TreeNode treeNode = TreeUtil.stringToTreeNode("[-3]");
        System.out.println(new Solution124().maxPathSum(treeNode));
    }
}
