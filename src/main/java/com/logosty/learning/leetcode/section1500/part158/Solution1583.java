package com.logosty.learning.leetcode.section1500.part158;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Set;

import com.logosty.learning.util.pojo.TreeNode;

/**
 * @author logosty(ganyingle) on 2024/9/1 14:23
 * description: 1586.二叉搜索树迭代器 Ⅱ 中等
 */
public class Solution1583 {
    class BSTIterator {
        private TreeNode currentNode;
        ArrayDeque<TreeNode> nextNodes = new ArrayDeque<>();
        ArrayDeque<TreeNode> preNodes = new ArrayDeque<>();
        Set<TreeNode> visited = new HashSet<>();

        public BSTIterator(TreeNode root) {
            nextNodes.add(root);
        }

        public boolean hasNext() {
            return !nextNodes.isEmpty();
        }

        public int next() {
            TreeNode node = nextNodes.pollFirst();
            if (node == null) {
                return currentNode.val;
            }

            while (!visited.contains(node)) {
                if (node.right != null) {
                    nextNodes.addFirst(node.right);
                }
                nextNodes.addFirst(node);
                visited.add(node);
                if (node.left != null) {
                    nextNodes.addFirst(node.left);
                }

                node = nextNodes.pollFirst();
            }
            if (currentNode != null) {
                preNodes.addFirst(currentNode);
            }
            currentNode = node;
            return node.val;
        }

        public boolean hasPrev() {
            return !preNodes.isEmpty();
        }

        public int prev() {
            TreeNode node = preNodes.pollFirst();
            if (node == null) {
                return currentNode.val;
            }

            nextNodes.addFirst(currentNode);

            currentNode = node;

            return node.val;
        }
    }
}
