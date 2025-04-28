package com.logosty.learning.leetcode.section000.part8;

import com.logosty.learning.util.pojo.ListNode;

/**
 * @author logosty(ganyingle) on 2025/4/28 16:00
 * description: 82. 删除排序链表中的重复元素 II 中等
 * 给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [1,2,3,3,4,4,5]
 * 输出：[1,2,5]
 * 示例 2：
 * <p>
 * <p>
 * 输入：head = [1,1,1,2,3]
 * 输出：[2,3]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 链表中节点数目在范围 [0, 300] 内
 * -100 <= Node.val <= 100
 * 题目数据保证链表已经按升序 排列
 */
public class Solution82 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode zero = new ListNode(-1000);
        zero.next = head;
        ListNode tail = zero;

        int lastNum = head.val;
        ListNode cur = head.next;
        ListNode tmp = head;

        while (cur != null) {
            if (cur.val == lastNum) {
                tmp = tail;
                tail.next = cur.next;
            } else {
                tail = tmp;
                lastNum = cur.val;
                tmp = cur;
            }
            cur = cur.next;
        }

        return zero.next;
    }
}
