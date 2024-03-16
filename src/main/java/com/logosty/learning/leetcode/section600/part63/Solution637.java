package com.logosty.learning.leetcode.section600.part63;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import com.logosty.learning.util.pojo.TreeNode;

/**
 * @author logosty(ganyingle) on 2024/3/16 20:19
 * description: 637. 二叉树的层平均值 简单
 */
public class Solution637 {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            double value = 0;
            int times = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                value += node.val;
                times++;

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            res.add((value / times));
        }
        return res;
    }
}
