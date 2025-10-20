package com.logosty.learning.leetcode.section300.part32;

import com.logosty.learning.util.pojo.ListNode;

/**
 * @author logosty(ganyingle) on 2020/11/13 14:07
 * 328. 奇偶链表 中等
 * 给定单链表的头节点 head ，将所有索引为奇数的节点和索引为偶数的节点分别分组，保持它们原有的相对顺序，然后把偶数索引节点分组连接到奇数索引节点分组之后，返回重新排序的链表。
 * <p>
 * 第一个节点的索引被认为是 奇数 ， 第二个节点的索引为 偶数 ，以此类推。
 * <p>
 * 请注意，偶数组和奇数组内部的相对顺序应该与输入时保持一致。
 * <p>
 * 你必须在 O(1) 的额外空间复杂度和 O(n) 的时间复杂度下解决这个问题。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * <p>
 * 输入: head = [1,2,3,4,5]
 * 输出: [1,3,5,2,4]
 * 示例 2:
 * <p>
 * <p>
 * <p>
 * 输入: head = [2,1,3,5,6,4,7]
 * 输出: [2,3,6,7,1,5,4]
 * <p>
 * <p>
 * 提示:
 * <p>
 * n ==  链表中的节点数
 * 0 <= n <= 104
 * -106 <= Node.val <= 106
 */
public class Solution328 {

    public ListNode oddEvenList(ListNode head) {
        ListNode oddLink = new ListNode(0);
        ListNode evenHead = new ListNode(0);
        ListNode evenLink = evenHead;

        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }

        ListNode cur = head;
        boolean oddFlag = true;
        while (cur != null) {
            if (oddFlag) {
                oddLink.next = cur;
                oddLink = oddLink.next;
            } else {
                evenLink.next = cur;
                evenLink = evenLink.next;
            }
            oddFlag = !oddFlag;
            cur = cur.next;
        }
        evenLink.next = null;
        oddLink.next = evenHead.next;

        return head;
    }
}
