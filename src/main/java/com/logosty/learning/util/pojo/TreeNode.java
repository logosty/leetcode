package com.logosty.learning.util.pojo;

import lombok.Data;

/**
 * Created with IDEA by logosty
 * Date:2019/4/19 Time:15:01
 * Description: 二叉树
 */
@Data
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode next;

    public TreeNode(int x) {
        val = x;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
