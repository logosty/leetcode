package com.logosty.learning.leetcode.section800;

import java.util.ArrayList;
import java.util.List;

import com.logosty.learning.util.pojo.TreeNode;

/**
 * @author logosty(ganyingle) on 2024/4/15 14:27
 * description: 894. 所有可能的真二叉树 中等
 */
public class Solution894 {
    public List<TreeNode> allPossibleFBT(int n) {
        if (n % 2 != 1) {
            return new ArrayList<>();
        }

        List<TreeNode>[] dp = new ArrayList[n + 1];
        dp[1] = new ArrayList<>();
        dp[1].add(new TreeNode(0));

        for (int total = 3; total <= n; total += 2) {
            dp[total] = new ArrayList<>();

            for (int left = 1; left < total; left += 2) {
                int right = total - left - 1;

                for (TreeNode leftNode : dp[left]) {
                    for (TreeNode rightNode : dp[right]) {
                        TreeNode root = new TreeNode(0, leftNode, rightNode);
                        dp[total].add(root);
                    }
                }
            }
        }

        return dp[n];
    }
}
