package com.logosty.learning.leetcode.section200.part23;

import com.logosty.learning.util.ListNodeUtils;
import com.logosty.learning.util.pojo.ListNode;

/**
 * @author logosty(ganyingle) on 2020/10/23 10:37
 * 234. 回文链表 简单
 * 请判断一个链表是否为回文链表。
 *
 * 示例 1:
 *
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 *
 * 输入: 1->2->2->1
 * 输出: true
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 *
 */

/**
 * 执行用时：
 * 1 ms
 * , 在所有 Java 提交中击败了
 * 99.86%
 * 的用户
 * 内存消耗：
 * 41 MB
 * , 在所有 Java 提交中击败了
 * 95.81%
 * 的用户
 */
public class Solution234 {

  public boolean isPalindrome(ListNode head) {
    if (head==null||head.next == null) {
      return true;
    }
    if (head.next.next == null) {
      return head.val == head.next.val;
    }

    ListNode fast = head;
    ListNode slow = head;

    ListNode last = null;
    ListNode next = slow.next;

    while (fast.next != null && fast.next.next != null) {
      fast = fast.next.next;

      next = slow.next;
      slow.next = last;
      last = slow;
      slow = next;
    }
    next = slow.next;
    slow.next = last;

    if (fast.next == null) {
      slow = slow.next;
    }

    while (slow != null && next != null) {
      if (slow.val != next.val) {
        return false;
      }
      slow = slow.next;
      next = next.next;
    }
    return true;
  }

  public static void main(String[] args) {
    System.out.println(new Solution234().isPalindrome(ListNodeUtils.stringToListNode("[1,2,2,1]")));
  }
}
