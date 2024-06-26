package com.logosty.learning.leetcode.section2400.part243;

import com.logosty.learning.util.pojo.ListNode;

/**
 * @author logosty(ganyingle) on 2024/4/22 17:14
 * description: 2487. 从链表中移除节点 中等
 * 给你一个链表的头节点 head 。
 *
 * 移除每个右侧有一个更大数值的节点。
 *
 * 返回修改后链表的头节点 head 。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：head = [5,2,13,3,8]
 * 输出：[13,8]
 * 解释：需要移除的节点是 5 ，2 和 3 。
 * - 节点 13 在节点 5 右侧。
 * - 节点 13 在节点 2 右侧。
 * - 节点 8 在节点 3 右侧。
 * 示例 2：
 *
 * 输入：head = [1,1,1,1]
 * 输出：[1,1,1,1]
 * 解释：每个节点的值都是 1 ，所以没有需要移除的节点。
 *
 *
 * 提示：
 *
 * 给定列表中的节点数目在范围 [1, 105] 内
 * 1 <= Node.val <= 105
 */
public class Solution2487 {
    public ListNode removeNodes(ListNode head) {
        int size = 0;
        ListNode cur = head;
        while (cur != null) {
            cur = cur.next;
            size++;
        }

        int[] nums = new int[size];

        cur = head;
        int index = 0;
        while (cur != null) {
            nums[index++] = cur.val;
            cur = cur.next;
        }
        int[] rightMax = new int[size];
        rightMax[size - 1] = nums[size - 1];
        for (int i = size - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], nums[i]);
        }

        ListNode visualHead = new ListNode(-1, head);

        cur = head;
        ListNode pre = visualHead;
        for (int i = 0; i < size; i++) {
            if (rightMax[i] <= nums[i]) {
                pre = cur;
            } else {
                //remove
                pre.next = cur.next;
            }
            cur = cur.next;
        }

        return visualHead.next;
    }


}
