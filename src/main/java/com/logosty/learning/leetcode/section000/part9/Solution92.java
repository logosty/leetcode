package com.logosty.learning.leetcode.section000.part9;

import com.logosty.learning.util.pojo.ListNode;

/**
 * @author logosty(ganyingle) on 2025/4/28 15:25
 * description: 92. 反转链表 II 中等
 * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [1,2,3,4,5], left = 2, right = 4
 * 输出：[1,4,3,2,5]
 * 示例 2：
 * <p>
 * 输入：head = [5], left = 1, right = 1
 * 输出：[5]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 链表中节点数目为 n
 * 1 <= n <= 500
 * -500 <= Node.val <= 500
 * 1 <= left <= right <= n
 * <p>
 * <p>
 * 进阶： 你可以使用一趟扫描完成反转吗？
 */
public class Solution92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) {
            return head;
        }

        ListNode zero = new ListNode(0);
        zero.next = head;
        ListNode noReverseTail = zero;

        ListNode reverseHead = null;
        ListNode reverseTail = null;

        ListNode cur = zero;
        ListNode next = zero.next;
        int count = 0;

        while (next != null) {
            cur = next;
            next = next.next;
            count++;

            //还没开始呢
            if (count < left) {
                noReverseTail = cur;
                continue;
            }

            //已经结束了
            if (count > right) {
                reverseTail.next = cur;
                break;
            }

            //如果是第一个节点，初始化，不做其他操作
            if (count == left) {
                cur.next = null;
                reverseTail = cur;
                reverseHead = cur;
                continue;
            }

            //1,将cur的next指向rehead 2，将rehead变成当前的值 3，将noretail指向当前
            cur.next = reverseHead;
            reverseHead = cur;
        }
        noReverseTail.next = reverseHead;

        return zero.next;
    }
}
