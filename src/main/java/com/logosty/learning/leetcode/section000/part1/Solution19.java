package com.logosty.learning.leetcode.section000.part1;

import com.logosty.learning.util.pojo.ListNode;

/**
 * @author logosty(ganyingle) on 2020/10/19 10:48
 * 19. 删除链表的倒数第N个节点 中等
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 *
 * 给定的 n 保证是有效的。
 *
 * 进阶：
 *
 * 你能尝试使用一趟扫描实现吗？
 */
public class Solution19 {

  public ListNode removeNthFromEnd(ListNode head, int n) {
    if (head == null) {
      return null;
    }
    ListNode start = new ListNode(-1);
    start.next = head;

    ListNode first = head;
    ListNode second = start;

    for (int i = 0; i < n; i++) {
      first = first.next;
    }
    while (first != null) {
      first = first.next;
      second = second.next;
    }

    second.next = second.next.next;

    return start.next;
  }
}
