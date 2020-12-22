package com.logosty.learning.leetcode.section100.part10;

import com.alibaba.fastjson.JSON;
import com.logosty.learning.util.TreeUtil;
import com.logosty.learning.util.pojo.TreeNode;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * @author logosty(ganyingle) on 2020/12/22 11:02
 * 103. 二叉树的锯齿形层序遍历 中等
 * 给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回锯齿形层序遍历如下：
 *
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 */
public class Solution103 {

  List<List<Integer>> res = new ArrayList<>();

  public static void main(String[] args) {
    TreeNode node = TreeUtil.stringToTreeNode("[3,9,20,null,null,15,7]");
    System.out.println(JSON.toJSONString(new Solution103().zigzagLevelOrder(node)));
  }

  /**
   * 执行用时：
   * 1 ms
   * , 在所有 Java 提交中击败了
   * 98.42%
   * 的用户
   * 内存消耗：
   * 38.4 MB
   * , 在所有 Java 提交中击败了
   * 71.87%
   * 的用户
   * @param root
   * @return
   */
  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    if (root == null) {
      return res;
    }

    ArrayDeque<TreeNode> leftBuffer = new ArrayDeque<>();
    ArrayDeque<TreeNode> rightBuffer = new ArrayDeque<>();
    leftBuffer.add(root);
    loop(leftBuffer, rightBuffer, true);
    return res;
  }

  private void loop(ArrayDeque<TreeNode> leftBuffer, ArrayDeque<TreeNode> rightBuffer,
      boolean isLeft) {
    ArrayDeque<TreeNode> curDeque = isLeft ? leftBuffer : rightBuffer;
    ArrayDeque<TreeNode> nextDeque = !isLeft ? leftBuffer : rightBuffer;
    if (curDeque.isEmpty()) {
      return;
    }
    List<Integer> list = new ArrayList<>(curDeque.size());

    while (!curDeque.isEmpty()) {
      TreeNode node;
      if (isLeft) {
        node = curDeque.pollFirst();

        list.add(node.val);
        if (node.left != null) {
          nextDeque.addLast(node.left);
        }
        if (node.right != null) {
          nextDeque.addLast(node.right);
        }
      } else {
        node = curDeque.pollLast();

        list.add(node.val);
        if (node.right != null) {
          nextDeque.addFirst(node.right);
        }
        if (node.left != null) {
          nextDeque.addFirst(node.left);
        }
      }
    }
    res.add(list);

    loop(leftBuffer, rightBuffer, !isLeft);
  }
}
