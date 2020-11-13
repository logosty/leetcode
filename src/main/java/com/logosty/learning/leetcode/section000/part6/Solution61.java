package com.logosty.learning.leetcode.section000.part6;

import com.logosty.learning.util.pojo.ListNode;

/**
 * @author logosty(ganyingle) on 2020/11/13 14:52
 * 61. 旋转链表 中等
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 *
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 * 示例 2:
 *
 * 输入: 0->1->2->NULL, k = 4
 * 输出: 2->0->1->NULL
 * 解释:
 * 向右旋转 1 步: 2->0->1->NULL
 * 向右旋转 2 步: 1->2->0->NULL
 * 向右旋转 3 步: 0->1->2->NULL
 * 向右旋转 4 步: 2->0->1->NULL
 */

/**
 * 执行结果：
 * 通过
 * 显示详情
 * 执行用时：
 * 1 ms
 * , 在所有 Java 提交中击败了
 * 80.86%
 * 的用户
 * 内存消耗：
 * 37.9 MB
 * , 在所有 Java 提交中击败了
 * 82.85%
 * 的用户
 */
public class Solution61 {
  public ListNode rotateRight(ListNode head, int k) {
    if (head == null || head.next == null) {
      return head;
    }
    int length = 1;
    ListNode tail = head;
    while (tail.next != null) {
      length++;
      tail = tail.next;
    }

    k = k % length;
    if (k == 0 ) {
      return head;
    }
    tail.next = head;

    ListNode newHead = new ListNode(-1);
    ListNode cur = head;

    for (int i = 1; i < length - k; i++) {
      cur = cur.next;
    }
    newHead.next = cur.next;
    cur.next = null;
    return newHead.next;
  }
}
