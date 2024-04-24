package com.logosty.learning.leetcode.section500.part51;

import com.logosty.learning.util.pojo.TreeNode;

/**
 * @author logosty(ganyingle) on 2024/4/16 21:24
 * description: 513. 找树左下角的值 中等
 * 给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。
 *
 * 假设二叉树中至少有一个节点。
 *
 *
 *
 * 示例 1:
 *
 *
 *
 * 输入: root = [2,1,3]
 * 输出: 1
 * 示例 2:
 *
 *
 *
 * 输入: [1,2,3,4,null,5,6,null,null,7]
 * 输出: 7
 *
 *
 * 提示:
 *
 * 二叉树的节点个数的范围是 [1,104]
 * -231 <= Node.val <= 231 - 1
 */
public class Solution513 {
    int res = 0;
    int maxLevel = 0;
    public int findBottomLeftValue(TreeNode root) {
        dfs(root, 0);
        return res;
    }

    /**
     *
     * @param depth 上一层的层级
     */
    private void dfs(TreeNode node, int depth) {
        if (node == null) {
            return;
        }
        depth++;
        if (node.left == null && node.right == null) {
            if (depth > maxLevel) {
                res = node.val;
                maxLevel = depth;
            }
            return;
        }
        dfs(node.left, depth + 1);
        dfs(node.right, depth + 1);
    }
}