package com.logosty.learning.leetcode.section100.part11;

import com.logosty.learning.util.pojo.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * @author logosty(ganyingle) on 2020/10/15 20:08
 * 199. 二叉树的右视图 中等
 * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 *
 * 示例:
 *
 * 输入: [1,2,3,null,5,null,4]
 * 输出: [1, 3, 4]
 * 解释:
 *
 *    1            <---
 *  /   \
 * 2     3         <---
 *  \     \
 *   5     4       <---
 */
public class Solution119 {

  List<Integer> res = new ArrayList<>();
  public List<Integer> rightSideView(TreeNode root) {

    loop(root, 0);

    return res;
  }

  public void loop(TreeNode root, int index) {
    if (root == null) {
      return;
    }

    loop(root.left, index + 1);

    if (res.size() <= index) {
      for (int i = res.size(); i <= index; i++) {
        res.add(-1);
      }
    }
    res.set(index, root.val);

    loop(root.right, index + 1);

  }
}
