package com.logosty.learning.leetcode.section100.part16;

import com.logosty.learning.util.pojo.ListNode;

/**
 * @author logosty(ganyingle) on 2020/11/13 16:47
 * 160. 相交链表 简单
 * 编写一个程序，找到两个单链表相交的起始节点。
 *
 * 如下面的两个链表：
 *
 *
 *
 * 在节点 c1 开始相交。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 * 输出：Reference of the node with value = 8
 * 输入解释：相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
 *
 *
 * 示例 2：
 *
 *
 *
 * 输入：intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
 * 输出：Reference of the node with value = 2
 * 输入解释：相交节点的值为 2 （注意，如果两个链表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4]。在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
 *
 *
 * 示例 3：
 *
 *
 *
 * 输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
 * 输出：null
 * 输入解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。由于这两个链表不相交，所以 intersectVal 必须为 0，而 skipA 和 skipB 可以是任意值。
 * 解释：这两个链表不相交，因此返回 null。
 *
 *
 * 注意：
 *
 * 如果两个链表没有交点，返回 null.
 * 在返回结果后，两个链表仍须保持原有的结构。
 * 可假定整个链表结构中没有循环。
 * 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
 */
public class Solution160 {

  /**
   * 执行用时：
   * 1 ms
   * , 在所有 Java 提交中击败了
   * 99.99%
   * 的用户
   * 内存消耗：
   * 41.2 MB
   * , 在所有 Java 提交中击败了
   * 83.16%
   * 的用户
   * @param headA
   * @param headB
   * @return
   */
  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    if (headA == null || headB == null) {
      return null;
    }
    int lengthA = 0;
    int lengthB = 0;

    ListNode tmp = headA;
    while (tmp != null) {
      lengthA++;
      tmp = tmp.next;
    }

    tmp = headB;
    while (tmp != null) {
      lengthB++;
      tmp = tmp.next;
    }



    ListNode longer = lengthA >= lengthB ? headA : headB;
    ListNode shorter = longer == headA ? headB : headA;
    int gap = Math.abs(lengthA - lengthB);
    for (int i = 0; i < gap; i++) {
      longer = longer.next;
    }

    while (longer != null && shorter != null) {
      if (longer == shorter) {
        return longer;
      }
      longer = longer.next;
      shorter = shorter.next;
    }
    return null;
  }
}