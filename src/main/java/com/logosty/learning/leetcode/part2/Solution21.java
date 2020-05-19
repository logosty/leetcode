package com.logosty.learning.leetcode.part2;

/**
 * Created with IDEA by logosty
 * Date:2019/1/29 Time:16:01
 * Description: 21. 合并两个有序链表
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * <p>
 * 示例：
 * <p>
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

class Solution21 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode init = new ListNode(-1);
        ListNode ret = init;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                init.next = l1;
                l1 = l1.next;
            } else {
                init.next = l2;
                l2 = l2.next;
            }
            init = init.next;
        }
        if (l1 == null) {
            init.next = l2;
        } else {
            init.next = l1;
        }
        return ret.next;
    }



    public ListNode listNodeBuilder(int... ints) {
        ListNode listNode = new ListNode(-1);
        ListNode cur = listNode;
        for (int i = 0; i < ints.length; i++) {
            cur.next = new ListNode(ints[i]);
            cur = cur.next;
        }
        return listNode.next;
    }
    public static void main(String[] args) {
//[1,2,4]
//[1,3,4]
        ListNode l1 = new Solution21().listNodeBuilder(1, 2, 4);
        ListNode l2 = new Solution21().listNodeBuilder(1, 3, 4);

        ListNode listNode = new Solution21().mergeTwoLists(l1, l2);
        System.out.println();
    }
}



