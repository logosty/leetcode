package com.logosty.learning.leetcode.section200.part23;

import com.logosty.learning.util.pojo.TreeNode;

/**
 * @author logosty(ganyingle) on 2025/4/28 16:56
 * description: 236. 二叉树的最近公共祖先 中等
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * <p>
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出：3
 * 解释：节点 5 和节点 1 的最近公共祖先是节点 3 。
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出：5
 * 解释：节点 5 和节点 4 的最近公共祖先是节点 5 。因为根据定义最近公共祖先节点可以为节点本身。
 * 示例 3：
 * <p>
 * 输入：root = [1,2], p = 1, q = 2
 * 输出：1
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中节点数目在范围 [2, 105] 内。
 * -109 <= Node.val <= 109
 * 所有 Node.val 互不相同 。
 * p != q
 * p 和 q 均存在于给定的二叉树中。
 */
public class Solution236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return loop(root, p, q).node;
    }

    public Info loop(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return new Info(false, false, null);
        }

        Info left = loop(root.left, p, q);
        Info right = loop(root.right, p, q);

        if (left.node != null) {
            return left;
        }
        if (right.node != null) {
            return right;
        }

        boolean hasQ = root == q || left.hasQ || right.hasQ;
        boolean hasP = root == p || left.hasP || right.hasP;

        if (hasQ && hasP) {
            return new Info(true, true, root);
        }

        return new Info(hasP, hasQ, null);
    }

    class Info {
        boolean hasP;
        boolean hasQ;
        TreeNode node;

        public Info(boolean hasP, boolean hasQ, TreeNode node) {
            this.hasP = hasP;
            this.hasQ = hasQ;
            this.node = node;
        }
    }
}
