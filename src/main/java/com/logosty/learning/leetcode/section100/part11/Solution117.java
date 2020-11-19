package com.logosty.learning.leetcode.section100.part11;

import com.logosty.learning.util.TreeUtil;
import com.logosty.learning.util.pojo.Node;
import com.logosty.learning.util.pojo.TreeNode;

/**
 * @author logosty(ganyingle) on 2020/10/15 17:14
 * 117. 填充每个节点的下一个右侧节点指针 II 中等
 * 给定一个二叉树
 *
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 *
 * 初始状态下，所有 next 指针都被设置为 NULL。
 *
 *
 *
 * 进阶：
 *
 * 你只能使用常量级额外空间。
 * 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
 *
 *
 * 示例：
 *
 *
 *
 * 输入：root = [1,2,3,4,5,null,7]
 * 输出：[1,#,2,3,#,4,5,7,#]
 * 解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。
 *
 *
 * 提示：
 *
 * 树中的节点数小于 6000
 * -100 <= node.val <= 100
 */
public class Solution117 {

  //从下找上
  public Node connect(Node root) {
    if (root == null) {
      return root;
    }
    func(root, root.left, root.right);
    return root;
  }

  public void func(Node lastHead, Node left, Node right) {
    if (left == null && right == null) {
      return;
    }

    Node tmp = lastHead;
    Node curHead = null;
    while (tmp != null) {
      if (tmp.left != null) {
        curHead = tmp.left;
        break;
      }
      if (tmp.right != null) {
        curHead = tmp.right;
        break;
      }
      tmp = tmp.next;
    }

    tmp = curHead;
    while (tmp.next != null) {
      tmp = tmp.next;
    }

    if (tmp != left && left != null) {
      tmp.next = left;
      tmp = left;
    }
    if (tmp != right && right != null) {
      tmp.next = right;
    }

    if (left != null) {
      func(curHead, left.left, left.right);
    }

    if (right != null) {
      func(curHead, right.left, right.right);
    }

  }

  //从上处理下
  public Node connect2(Node root) {
    if (root == null) {
      return root;
    }
    Node dummy = new Node();
    dummy.next = root;
    func2(dummy);
    return root;
  }

  public void func2(Node dummy) {
    if (dummy.next == null) {
      return;
    }
    Node curTmp = dummy.next;
    dummy.next = null;
    Node nextTmp = dummy;
    while (curTmp != null) {
      if (curTmp.left != null) {
        nextTmp.next = curTmp.left;
        nextTmp = nextTmp.next;
      }

      if (curTmp.right != null) {
        nextTmp.next = curTmp.right;
        nextTmp = nextTmp.next;
      }
      curTmp = curTmp.next;
    }
    func2(dummy);
  }

  public static void main(String[] args) {
    TreeNode node = TreeUtil.stringToTreeNode("[1,null,2]");
  }
}
