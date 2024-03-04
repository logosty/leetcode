package com.logosty.learning.leetcode.section100.part11;

import com.logosty.learning.util.pojo.TreeNode;

/**
 * @author logosty(ganyingle) on 2024/3/4 17:37
 * description: 114. 二叉树展开为链表 中等
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 *
 * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
 *
 *
 * 示例 1：
 *
 *
 * 输入：root = [1,2,5,3,4,null,6]
 * 输出：[1,null,2,null,3,null,4,null,5,null,6]
 * 示例 2：
 *
 * 输入：root = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：root = [0]
 * 输出：[0]
 *
 *
 * 提示：
 *
 * 树中结点数在范围 [0, 2000] 内
 * -100 <= Node.val <= 100
 *
 *
 * 进阶：你可以使用原地算法（O(1) 额外空间）展开这棵树吗？
 */
public class Solution114 {
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

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        doRefactor(root);
    }

    /**
     * @param root 当前要处理的节点
     * @return 整个结束后，末尾的那个节点
     *
     * 执行用时分布
     * 0
     * ms
     * 击败
     * 100.00%
     * 使用 Java 的用户
     * 消耗内存分布
     * 41.15
     * MB
     * 击败
     * 32.52%
     * 使用 Java 的用户
     */
    public TreeNode doRefactor(TreeNode root) {
        //先序遍历，先处理左边
        //把左边一坨拼接到自己的右边
        //再把原来的右边拼接在一坨最后面

        TreeNode tail = root;
        TreeNode left = root.left;
        TreeNode right = root.right;

        if (left != null) {
            TreeNode leftTail = doRefactor(left);
            root.left = null;
            root.right = left;
            leftTail.right = right;
            tail = leftTail;
        }
        if (right != null) {
            tail = doRefactor(right);
        }

        return tail;
    }
}
