package com.logosty.learning.leetcode.section200.part20;

import com.logosty.learning.util.ListNodeUtils;
import com.logosty.learning.util.pojo.ListNode;

/**
 * @author logosty(ganyingle) on 2020/6/18 20:16
 *
 * 206. 反转链表 简单
 * 反转一个单链表。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 */
public class Solution206 {

  public ListNode reverseList(ListNode head) {
    if (head == null) {
      return null;
    }

    ListNode cur = head;
    ListNode pre = null;
    ListNode next = null;
    while (cur.next != null) {
      next = cur.next;
      cur.next = pre;
      pre = cur;
      cur = next;
    }
    cur.next = pre;
    return cur;
  }

  public ListNode reverseList2(ListNode head) {
    if (head == null) {
      return null;
    }
    if (head.next == null) {
      return head;
    }

    return loop(null, head);
  }

  public ListNode loop(ListNode pre, ListNode node) {
    if (node.next == null) {
      node.next = pre;
      return node;
    }
    ListNode tmp = node.next;
    node.next = pre;
    return loop(node, tmp);
  }


  public static void main(String[] args) {
    String s = "[1,2,3,4,5]";
    System.out.println(s);

    ListNode listNode = ListNodeUtils.stringToListNode(s);
    ListNode node = new Solution206().reverseList(listNode);
    System.out.println(ListNodeUtils.listNodeToString(node));

    listNode = ListNodeUtils.stringToListNode(s);
    ListNode node2 = new Solution206().reverseList2(listNode);
    System.out.println(ListNodeUtils.listNodeToString(node2));

  }

}
