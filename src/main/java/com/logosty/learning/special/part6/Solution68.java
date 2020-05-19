package com.logosty.learning.special.part6;

import java.util.HashMap;
import java.util.Map;

/**
 * @author logosty(ganyingle) on 2020/5/19 16:30 68 二叉树的最近公共祖先 简单 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * <p>
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * <p>
 * 例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
 * <p>
 * 示例 1:
 * <p>
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1 输出: 3 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。 示例 2:
 * <p>
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4 输出: 5 解释: 节点 5 和节点 4 的最近公共祖先是节点
 * 5。因为根据定义最近公共祖先节点可以为节点本身。  
 * <p>
 * 说明:
 * <p>
 * 所有节点的值都是唯一的。 p、q 为不同节点且均存在于给定的二叉树中。
 * <p>
 * <p>
 * /** Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode(int x) { val = x; } }
 */
class Solution68 {

  private static int maxLength = -1;
  TreeNode res = null;
  Map<TreeNode, Pair> map = new HashMap<>();

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    maxLength = -1;
    res = root;
    map = new HashMap<>();
    this.isParent(root, p, q, 1);

    return res;
  }

  private Pair isParent(TreeNode root, TreeNode p, TreeNode q, int currentLength) {

    if (root == null) {
      return new Pair(false, false);
    }
    if (map.get(root) != null) {
      return map.get(root);
    }

    Pair leftPair = isParent(root.left, p, q, currentLength + 1);
    Pair rightPair = isParent(root.right, p, q, currentLength + 1);

    Pair currentPair = new Pair();
    currentPair.setHasp(leftPair.hasp || rightPair.hasp);
    currentPair.setHasq(leftPair.hasq || rightPair.hasq);

    if (root.val == p.val) {
      currentPair.setHasp(true);
    }
    if (root.val == q.val) {
      currentPair.setHasq(true);
    }

    map.put(root, currentPair);

    if (currentPair.allMatched()) {
      if (currentLength > maxLength) {
        maxLength = currentLength;
        res = root;
      }
    }

    return currentPair;
  }

  public static void main(String[] args) {

  }
}

class Pair {

  boolean hasp;
  boolean hasq;

  Pair() {
  }

  Pair(boolean hasp, boolean hasq) {
    this.hasp = hasp;
    this.hasq = hasq;
  }

  public boolean isHasp() {
    return hasp;
  }

  public void setHasp(boolean hasp) {
    this.hasp = hasp;
  }

  public boolean isHasq() {
    return hasq;
  }

  public void setHasq(boolean hasq) {
    this.hasq = hasq;
  }

  public boolean allMatched() {
    return this.hasp && this.hasq;
  }
}

class TreeNode {

  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int x) {
    val = x;
  }
}

