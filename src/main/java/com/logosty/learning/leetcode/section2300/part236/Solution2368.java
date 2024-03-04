package com.logosty.learning.leetcode.section2300.part236;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author logosty(ganyingle) on 2024/3/4 15:50
 * description: 2368. 受限条件下可到达节点的数目 中等
 * 现有一棵由 n 个节点组成的无向树，节点编号从 0 到 n - 1 ，共有 n - 1 条边。
 * <p>
 * 给你一个二维整数数组 edges ，长度为 n - 1 ，其中 edges[i] = [ai, bi] 表示树中节点 ai 和 bi 之间存在一条边。另给你一个整数数组 restricted 表示 受限 节点。
 * <p>
 * 在不访问受限节点的前提下，返回你可以从节点 0 到达的 最多 节点数目。
 * <p>
 * 注意，节点 0 不 会标记为受限节点。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：n = 7, edges = [[0,1],[1,2],[3,1],[4,0],[0,5],[5,6]], restricted = [4,5]
 * 输出：4
 * 解释：上图所示正是这棵树。
 * 在不访问受限节点的前提下，只有节点 [0,1,2,3] 可以从节点 0 到达。
 * 示例 2：
 * <p>
 * <p>
 * 输入：n = 7, edges = [[0,1],[0,2],[0,5],[0,4],[3,2],[6,5]], restricted = [4,2,1]
 * 输出：3
 * 解释：上图所示正是这棵树。
 * 在不访问受限节点的前提下，只有节点 [0,5,6] 可以从节点 0 到达。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= n <= 105
 * edges.length == n - 1
 * edges[i].length == 2
 * 0 <= ai, bi < n
 * ai != bi
 * edges 表示一棵有效的树
 * 1 <= restricted.length < n
 * 1 <= restricted[i] < n
 * restricted 中的所有值 互不相同
 */
public class Solution2368 {
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        Set<Integer> restrictedNodes = new HashSet<>();
        for (int i : restricted) {
            restrictedNodes.add(i);
        }

        Map<Integer, Set<Integer>> cache = new HashMap<>();
        for (int[] edge : edges) {
            int first = edge[0];
            int second = edge[1];
            if (restrictedNodes.contains(first) || restrictedNodes.contains(second)) {
                continue;
            }

            Set<Integer> linkedNodes = cache.getOrDefault(first, new HashSet<>());
            linkedNodes.add(second);
            cache.put(first, linkedNodes);

            linkedNodes = cache.getOrDefault(second, new HashSet<>());
            linkedNodes.add(first);
            cache.put(second, linkedNodes);
        }

        return process(0, -1, cache);

    }

    private int process(int node, int lastNode, Map<Integer, Set<Integer>> cache) {
        int res = 0;
        Set<Integer> sets = cache.getOrDefault(node, Collections.emptySet());

        for (Integer next : sets) {
            if (next == lastNode) {
                continue;
            }
            res += process(next, node, cache);
        }
        return res + 1;
    }

    public static void main(String[] args) {
        int[][] edges = new int[][] {{4, 1}, {1, 3}, {1, 5}, {0, 5}, {3, 6}, {8, 4}, {5, 7}, {6, 9}, {3, 2}};
        int[] restricted = new int[] {2, 7};
        System.out.println(new Solution2368().reachableNodes(10, edges, restricted));
    }
}
