package com.logosty.learning.leetcode.section000.part2;

import com.logosty.learning.util.pojo.ListNode;

/**
 * @author logosty(ganyingle) on 2020/10/13 19:56
 * 24. 两两交换链表中的节点 中等
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 * 示例 2：
 *
 * 输入：head = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：head = [1]
 * 输出：[1]
 *
 *
 * 提示：
 *
 * 链表中节点的数目在范围 [0, 100] 内
 * 0 <= Node.val <= 100
 */
public class Solution24 {

  public ListNode swapPairs(ListNode head) {
    ListNode begin = new ListNode(0, head);

    ListNode current = begin;

    while (true) {
      ListNode first = current.next;
      if (first == null || first.next == null) {
        return begin.next;
      }
      ListNode second = first.next;

      current.next = second;
      first.next = second.next;
      second.next = first;

      current = first;
    }
  }

  public static void main(String[] args) {

  }
}
