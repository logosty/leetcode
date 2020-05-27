package com.logosty.learning.leetcode.section000.part10;

import com.logosty.learning.util.pojo.TreeNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

import static com.logosty.learning.util.TreeUtil.booleanToString;
import static com.logosty.learning.util.TreeUtil.stringToTreeNode;

/**
 * Created with IDEA by logosty
 * Date:2019/4/19 Time:14:38
 * Description: 简单 101. 对称二叉树
 * <p>
 * 给定一个二叉树，检查它是否是镜像对称的。
 * <p>
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 * <p>
 * 1
 * / \
 * 2   2
 * / \ / \
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 * <p>
 * 1
 * / \
 * 2   2
 * \   \
 * 3    3
 * 说明:
 * <p>
 * 如果你可以运用递归和迭代两种方法解决这个问题，会很加分。
 */
public class Solution101 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return loop(root.left, root.right);
    }

    /**
     * 递归
     *
     * @param node1
     * @param node2
     * @return
     */
    boolean loop(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 != null && node2 != null) {
            return node1.val == node2.val && loop(node1.left, node2.right) && loop(node1.right, node2.left);
        }
        return false;
    }

    /**
     * 迭代方法
     *
     * @param root
     * @return
     */
    public boolean isSymmetric1(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        if (root.left == null || root.right == null) {
            return false;
        }

        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root.left);
        list.add(root.right);

        while (!list.isEmpty()) {
            TreeNode left = list.poll();
            TreeNode right = list.poll();

            if (left == null && right == null) {
                continue;
            }
            if (left == null || right == null) {
                return false;
            }
            if (left.val != right.val) {
                return false;
            }

            list.add(left.right);
            list.add(right.left);
            list.add(left.left);
            list.add(right.right);
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line = "[1,2,2,3,4,4,3]";
//        while ( (line = in.readLine()) != null) {
        TreeNode root = stringToTreeNode(line);

        boolean ret = new Solution101().isSymmetric1(root);

        String out = booleanToString(ret);

        System.out.print(out);
    }
//    }
}
