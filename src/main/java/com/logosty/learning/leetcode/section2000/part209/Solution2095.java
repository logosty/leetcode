package com.logosty.learning.leetcode.section2000.part209;

import com.logosty.learning.util.pojo.ListNode;

/**
 * @author logosty(ganyingle) on 2025/10/20 17:02
 * description: 2095. 删除链表的中间节点 中等
 * 给你一个链表的头节点 head 。删除 链表的 中间节点 ，并返回修改后的链表的头节点 head 。
 * <p>
 * 长度为 n 链表的中间节点是从头数起第 ⌊n / 2⌋ 个节点（下标从 0 开始），其中 ⌊x⌋ 表示小于或等于 x 的最大整数。
 * <p>
 * 对于 n = 1、2、3、4 和 5 的情况，中间节点的下标分别是 0、1、1、2 和 2 。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：head = [1,3,4,7,1,2,6]
 * 输出：[1,3,4,1,2,6]
 * 解释：
 * 上图表示给出的链表。节点的下标分别标注在每个节点的下方。
 * 由于 n = 7 ，值为 7 的节点 3 是中间节点，用红色标注。
 * 返回结果为移除节点后的新链表。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：head = [1,2,3,4]
 * 输出：[1,2,4]
 * 解释：
 * 上图表示给出的链表。
 * 对于 n = 4 ，值为 3 的节点 2 是中间节点，用红色标注。
 * 示例 3：
 * <p>
 * <p>
 * <p>
 * 输入：head = [2,1]
 * 输出：[2]
 * 解释：
 * 上图表示给出的链表。
 * 对于 n = 2 ，值为 1 的节点 1 是中间节点，用红色标注。
 * 值为 2 的节点 0 是移除节点 1 后剩下的唯一一个节点。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 链表中节点的数目在范围 [1, 105] 内
 * 1 <= Node.val <= 105
 */
public class Solution2095 {
    /**
     * 快慢指针，快指针结束的时候慢指针就是对应的节点
     */
    public ListNode deleteMiddle(ListNode head) {
        if (head.next == null) {
            return null;
        }


        ListNode home = new ListNode(0, head);
        ListNode slow = home;
        ListNode fast = home;

        //找到中间节点
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        //删除slow的下一个
        slow.next = slow.next.next;

        return head;
    }
}
