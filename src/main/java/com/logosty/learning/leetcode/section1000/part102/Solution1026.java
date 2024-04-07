package com.logosty.learning.leetcode.section1000.part102;

import com.logosty.learning.util.pojo.TreeNode;

/**
 * @author logosty(ganyingle) on 2024/4/7 10:43
 * description: 1026. 节点与其祖先之间的最大差值 中等
 * 给定二叉树的根节点 root，找出存在于 不同 节点 A 和 B 之间的最大值 V，其中 V = |A.val - B.val|，且 A 是 B 的祖先。
 *
 * （如果 A 的任何子节点之一为 B，或者 A 的任何子节点是 B 的祖先，那么我们认为 A 是 B 的祖先）
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：root = [8,3,10,1,6,null,14,null,null,4,7,13]
 * 输出：7
 * 解释：
 * 我们有大量的节点与其祖先的差值，其中一些如下：
 * |8 - 3| = 5
 * |3 - 7| = 4
 * |8 - 1| = 7
 * |10 - 13| = 3
 * 在所有可能的差值中，最大值 7 由 |8 - 1| = 7 得出。
 * 示例 2：
 *
 *
 * 输入：root = [1,null,2,null,0,3]
 * 输出：3
 *
 *
 * 提示：
 *
 * 树中的节点数在 2 到 5000 之间。
 * 0 <= Node.val <= 105
 *
 * 0
 * ms
 * 击败
 * 100.00%
 * 使用 Java 的用户
 */
public class Solution1026 {
    int res;

    private static class Info{
        int min;
        int max;

        public Info(int min, int max) {
            this.min = min;
            this.max = max;
        }
    }

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    public int maxAncestorDiff(TreeNode root) {
        loop(root);
        return res;
    }

    private Info loop(TreeNode root){
        if (root == null) return new Info(Integer.MAX_VALUE, Integer.MIN_VALUE);

        Info left = loop(root.left);
        Info right = loop(root.right);

        int min = Math.min(left.min, right.min);
        int max = Math.max(left.max, right.max);

        if (min != Integer.MAX_VALUE) {
            res = Math.max(res, Math.abs(root.val - min));
        }
        if (max != Integer.MIN_VALUE) {
            res = Math.max(res, Math.abs(root.val - max));
        }

        Info info = new Info(root.val, root.val);
        info.min = Math.min(min, info.min);
        info.max = Math.max(max, info.max);

        return info;
    }
}
