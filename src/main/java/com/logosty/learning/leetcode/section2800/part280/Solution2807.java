package com.logosty.learning.leetcode.section2800.part280;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.logosty.learning.util.pojo.ListNode;

/**
 * @author logosty(ganyingle) on 2024/4/23 17:27
 * description: 2807. 在链表中插入最大公约数 中等
 * 给你一个链表的头 head ，每个结点包含一个整数值。
 * <p>
 * 在相邻结点之间，请你插入一个新的结点，结点值为这两个相邻结点值的 最大公约数 。
 * <p>
 * 请你返回插入之后的链表。
 * <p>
 * 两个数的 最大公约数 是可以被两个数字整除的最大正整数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：head = [18,6,10,3]
 * 输出：[18,6,6,2,10,1,3]
 * 解释：第一幅图是一开始的链表，第二幅图是插入新结点后的图（蓝色结点为新插入结点）。
 * - 18 和 6 的最大公约数为 6 ，插入第一和第二个结点之间。
 * - 6 和 10 的最大公约数为 2 ，插入第二和第三个结点之间。
 * - 10 和 3 的最大公约数为 1 ，插入第三和第四个结点之间。
 * 所有相邻结点之间都插入完毕，返回链表。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：head = [7]
 * 输出：[7]
 * 解释：第一幅图是一开始的链表，第二幅图是插入新结点后的图（蓝色结点为新插入结点）。
 * 没有相邻结点，所以返回初始链表。
 */
public class Solution2807 {
    Map<String, Integer> cache = new HashMap<>();
    Map<Integer, Set<Integer>> divisorCache = new HashMap<>();

    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode node = head;
        getAndCacheDivisors(head.val);
        while (node.next != null) {
            int middle = getMiddle(node.val, node.next.val);

            node.next = new ListNode(middle, node.next);
            node = node.next.next;
        }
        return head;
    }

    //求公约数
    private int getMiddle(int pre, int next) {
        String cacheKey = pre + "_" + next;
        if (cache.containsKey(cacheKey)) {
            return cache.get(cacheKey);
        }
        Set<Integer> preDivisors = divisorCache.get(pre);
        Set<Integer> nextDivisors = getAndCacheDivisors(next);

        //求两个set交集中最大的数
        Set<Integer> minSize = preDivisors;
        Set<Integer> maxSize = nextDivisors;
        if (preDivisors.size() > nextDivisors.size()) {
            maxSize = preDivisors;
            minSize = nextDivisors;
        }

        int res = 0;
        for (Integer num : minSize) {
            if (maxSize.contains(num)) {
                res = Math.max(res, num);
            }
        }

        cache.put(cacheKey, res);
        return res;
    }

    private Set<Integer> getAndCacheDivisors(int num) {
        if (divisorCache.containsKey(num)) {
            return divisorCache.get(num);
        }

        Set<Integer> divisors = new HashSet<>();
        divisors.add(num);
        divisors.add(1);

        for (int i = num - 1; i > 1; i--) {
            if (divisors.contains(i) || num % i != 0) {
                continue;
            }
            divisors.add(i);
//            divisors.addAll(getAndCacheDivisors(i));

            int i1 = num / i;
            divisors.add(i1);
//            divisors.addAll(getAndCacheDivisors(i1));
        }
        divisorCache.put(num, divisors);
        return divisors;
    }


}
