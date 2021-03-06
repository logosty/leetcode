package com.logosty.learning.leetcode.section300.part32;

import com.logosty.learning.util.pojo.ListNode;

/**
 * @author logosty(ganyingle) on 2020/11/13 14:07
 * 328. 奇偶链表 中等
 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 *
 * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
 *
 * 示例 1:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 1->3->5->2->4->NULL
 * 示例 2:
 *
 * 输入: 2->1->3->5->6->4->7->NULL
 * 输出: 2->3->6->7->1->5->4->NULL
 * 说明:
 *
 * 应当保持奇数节点和偶数节点的相对顺序。
 * 链表的第一个节点视为奇数节点，第二个节点视为偶数节点，以此类推。
 */
public class Solution328 {

  /**
   * 执行用时：
   * 0 ms
   * , 在所有 Java 提交中击败了
   * 100.00%
   * 的用户
   * 内存消耗：
   * 38.3 MB
   * , 在所有 Java 提交中击败了
   * 76.48%
   * 的用户
   */
  public ListNode oddEvenList(ListNode head) {
    if (head == null || head.next == null || head.next.next == null) {
      return head;
    }

    ListNode oddHead = new ListNode(-1);
    ListNode evenHead = new ListNode(-1);
    ListNode oddTail = oddHead;
    ListNode evenTail = evenHead;

    ListNode cur = head;
    boolean odd = true;
    while (cur != null) {
      if (odd) {
        oddTail.next = cur;
        oddTail = cur;
        odd = false;
      } else {
        evenTail.next = cur;
        evenTail = cur;
        odd = true;
      }

      ListNode tmp = cur.next;
      cur.next = null;
      cur = tmp;
    }

    oddTail.next = evenHead.next;

    return oddHead.next;
  }
}
