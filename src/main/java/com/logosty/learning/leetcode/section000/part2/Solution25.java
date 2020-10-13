package com.logosty.learning.leetcode.section000.part2;

import com.logosty.learning.util.ListNodeUtils;
import com.logosty.learning.util.pojo.ListNode;

/**
 * @author logosty(ganyingle) on 2020/10/13 20:15
 * 25. K 个一组翻转链表 困难
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 *
 * k 是一个正整数，它的值小于或等于链表的长度。
 *
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 *
 *
 * 示例：
 *
 * 给你这个链表：1->2->3->4->5
 *
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 *
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 *
 *
 *
 * 说明：
 *
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 */
public class Solution25 {

  static class Pair {

    ListNode begin;
    ListNode end;
  }

  public ListNode reverseKGroup(ListNode head, int k) {
    if (k == 1) {
      return head;
    }

    ListNode begin = new ListNode(0, head);

    ListNode current = begin;

    while (true) {
      ListNode contact = null;

      ListNode tmp = current;
      for (int i = 0; i < k; i++) {
        if (tmp.next == null) {
          return begin.next;
        }

        tmp = tmp.next;
      }
      contact = tmp.next;
      tmp.next = null;

      Pair pair = reverse(current.next);
      current.next = pair.begin;
      pair.end.next = contact;
      current = pair.end;
    }

  }

  public Pair reverse(ListNode head) {
    Pair pair = new Pair();
    pair.end = head;

    ListNode first = head;
    ListNode second = head.next;
    first.next = null;
    while (true) {
      ListNode tmp = second.next;

      second.next = first;
      first = second;
      second = tmp;
      if (second == null) {
        pair.begin = first;
        return pair;
      }
    }
  }

  public static void main(String[] args) {
    ListNode listNode = ListNodeUtils.stringToListNode("[1,2,3,4,5]");
    System.out.println(ListNodeUtils.listNodeToString(listNode));
    listNode = new Solution25().reverseKGroup(listNode, 2);
    System.out.println(ListNodeUtils.listNodeToString(listNode));



  }
}
