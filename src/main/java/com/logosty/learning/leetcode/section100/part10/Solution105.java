package com.logosty.learning.leetcode.section100.part10;

import com.logosty.learning.util.pojo.TreeNode;

/**
 * @author logosty(ganyingle) on 2025/5/2 16:10
 * description: 105. 从前序与中序遍历序列构造二叉树 中等
 * 给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * 输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * 输出: [3,9,20,null,null,15,7]
 * 示例 2:
 * <p>
 * 输入: preorder = [-1], inorder = [-1]
 * 输出: [-1]
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= preorder.length <= 3000
 * inorder.length == preorder.length
 * -3000 <= preorder[i], inorder[i] <= 3000
 * preorder 和 inorder 均 无重复 元素
 * inorder 均出现在 preorder
 * preorder 保证 为二叉树的前序遍历序列
 * inorder 保证 为二叉树的中序遍历序列
 */
public class Solution105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, inorder, 0, 0, inorder.length);
    }

    private TreeNode buildTree(int[] preorder, int[] inorder, int preStart, int inStart, int totalSize) {
        // 前序遍历第一个肯定是根结点， 在中序遍历中找到头结点， 然后确定根结点前面几个，后面几个。

        int root = preorder[preStart];
        TreeNode rootNode = new TreeNode(root);
        int inRootIndex = -1;
        for (int i = inStart; i < inorder.length; i++) {
            if (inorder[i] == root) {
                inRootIndex = i;
                break;
            }
        }
        int leftLen = inRootIndex - inStart;
        int rightLen = totalSize - leftLen - 1;

        if (leftLen != 0) {
            rootNode.left = buildTree(preorder, inorder, preStart + 1, inStart, leftLen);
        }

        if (rightLen != 0) {
            rootNode.right = buildTree(preorder, inorder, preStart + leftLen + 1, inRootIndex + 1, rightLen);
        }
        return rootNode;
    }
}
