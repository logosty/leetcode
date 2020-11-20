package com.logosty.learning.leetcode.section100.part14;

import com.logosty.learning.util.ListNodeUtils;
import com.logosty.learning.util.pojo.ListNode;

/**
 * @author logosty(ganyingle) on 2020/11/20 11:35
 * 147. 对链表进行插入排序 中等
 * 对链表进行插入排序。
 *
 *
 * 插入排序的动画演示如上。从第一个元素开始，该链表可以被认为已经部分排序（用黑色表示）。
 * 每次迭代时，从输入数据中移除一个元素（用红色表示），并原地将其插入到已排好序的链表中。
 *
 *
 *
 * 插入排序算法：
 *
 * 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
 * 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
 * 重复直到所有输入数据插入完为止。
 *
 *
 * 示例 1：
 *
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * 示例 2：
 *
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 */
public class Solution147 {
  public ListNode insertionSortList(ListNode head) {
    ListNode first = new ListNode(Integer.MIN_VALUE);
    ListNode cur = head;

    while (cur != null) {
      ListNode next = cur.next;
      cur.next = null;

      insert(cur, first);

      cur = next;
    }
    return first.next;
  }

  private void insert(ListNode node, ListNode target) {
    ListNode cur = target;
    while (cur != null) {
      if (cur.next == null) {
        cur.next = node;
        return;
      }

      if (cur.next.val >= node.val) {
        node.next = cur.next;
        cur.next = node;
        return;
      }
      cur = cur.next;
    }
  }

  public static void main(String[] args) {
    ListNode node = ListNodeUtils.stringToListNode("[]");
    node = new Solution147().insertionSortList(node);
    System.out.println(ListNodeUtils.listNodeToString(node));

  }
}
