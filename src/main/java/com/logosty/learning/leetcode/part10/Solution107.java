package com.logosty.learning.leetcode.part10;

import com.logosty.learning.util.pojo.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * @author logosty(ganyingle) on 2020/5/22 15:37
 * 107. 二叉树的层次遍历 II 简单
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其自底向上的层次遍历为：
 *
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution107 {

  public List<List<Integer>> levelOrderBottom(TreeNode root) {
    List<List<Integer>> res = new ArrayList<>();
    if (root == null) {
      return res;
    }

    loop(root, 1, res);

    reversalList(res);
    return res;
  }

  public void loop(TreeNode root, int depth, List<List<Integer>> res) {
    if (res.size() < depth) {
      res.add(new ArrayList<>());
    }

    if (root.left != null) {
      loop(root.left, depth + 1, res);
    }
    res.get(depth - 1).add(root.val);
    if (root.right != null) {
      loop(root.right, depth + 1, res);
    }
  }

  public void reversalList(List list) {
    Object tmp;
    for (int i = 0; i < list.size() / 2; i++) {
      tmp = list.get(i);
      list.set(i, list.get(list.size() - i - 1));
      list.set(list.size() - i - 1, tmp);
    }
  }

  public static void main(String[] args) {

  }
}
