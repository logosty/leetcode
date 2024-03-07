package com.logosty.learning.leetcode.section100.part14;

import com.logosty.learning.util.ListNodeUtils;
import com.logosty.learning.util.pojo.ListNode;

/**
 * @author logosty(ganyingle) on 2024/3/6 17:54
 * description: 148. 排序链表 中等
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [4,2,1,3]
 * 输出：[1,2,3,4]
 * 示例 2：
 * <p>
 * <p>
 * 输入：head = [-1,5,3,4,0]
 * 输出：[-1,0,3,4,5]
 * 示例 3：
 * <p>
 * 输入：head = []
 * 输出：[]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 链表中节点的数目在范围 [0, 5 * 104] 内
 * -105 <= Node.val <= 105
 * <p>
 * <p>
 * 进阶：你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
 */
public class Solution148 {
    /**
     * 1.给定头结点，双指针找中心节点
     * 2.排序
     */
    public ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode middle = findMiddleAndSplit(head);
        head = sortList(head);
        middle = sortList(middle);
        return merge(head, middle);
    }

    /**
     * 给定头结点，双指针找中心节点，并且切断中心节点的上一个连接
     */
    private ListNode findMiddleAndSplit(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode middlePre = head;
        ListNode doubleNode = head.next;

        while (doubleNode != null) {
            middlePre = head;
            head = head.next;
            doubleNode = doubleNode.next == null ? null : doubleNode.next.next;
        }
        middlePre.next = null;
        return head;
    }

    /**
     * 合并两个有序链表并且返回头结点
     */
    private ListNode merge(ListNode per, ListNode after) {
        ListNode head = new ListNode(0);
        ListNode cur = head;
        while (per != null && after != null) {
            if (per.val <= after.val) {
                cur.next = per;
                per = per.next;
            } else {
                cur.next = after;
                after = after.next;
            }
            cur = cur.next;
        }

        if (per != null) {
            cur.next = per;
        } else {
            cur.next = after;
        }

        return head.next;
    }

    public static void main(String[] args) {
        ListNode listNode = ListNodeUtils.stringToListNode("[4,2,1,3]");
        System.out.println(ListNodeUtils.listNodeToString(new Solution148().sortList(listNode)));
    }
}
