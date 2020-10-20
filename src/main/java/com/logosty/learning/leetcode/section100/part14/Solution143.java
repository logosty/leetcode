package com.logosty.learning.leetcode.section100.part14;

import com.logosty.learning.util.ListNodeUtils;
import com.logosty.learning.util.pojo.ListNode;

/**
 * @author logosty(ganyingle) on 2020/10/20 14:40
 * 143. 重排链表 中等
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 示例 1:
 *
 * 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
 * 示例 2:
 *
 * 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
 */

/**
 * 执行用时：
 * 3 ms
 * , 在所有 Java 提交中击败了
 * 36.63%
 * 的用户
 * 内存消耗：
 * 40.8 MB
 * , 在所有 Java 提交中击败了
 * 98.66%
 * 的用户
 */
public class Solution143 {

  public void reorderList(ListNode head) {
    if (head == null || head.next == null) {
      return;
    }

    ListNode slow = head;
    ListNode fast = head;

    while (fast != null && fast.next != null && fast.next.next != null) {
      slow = slow.next;
      fast = fast.next;
      fast = fast.next;
    }

    ListNode head2 = slow.next;
    slow.next = null;

    head2 = reversal(head2);

    ListNode tmp = head;

    while (tmp != null && head2 != null) {

      ListNode next = tmp.next;

      tmp.next = head2;
      head2 = head2.next;

      tmp.next.next = next;

      tmp = next;
    }

  }

  public ListNode reversal(ListNode node) {
    ListNode first = new ListNode(-1);
    first.next = node;
    ListNode current = node.next;
    node.next = null;

    while (current != null) {

      ListNode tmp = first.next;
      first.next = current;

      current = current.next;
      first.next.next = tmp;
    }

    return first.next;
  }

  public static void main(String[] args) {
    ListNode listNode = ListNodeUtils.stringToListNode("[1,2,3,4,5,6,7,8,9]");
    new Solution143().reorderList(listNode);
    System.out.println(ListNodeUtils.listNodeToString(listNode));
  }
}
