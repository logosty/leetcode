package com.logosty.learning.leetcode.section1400.part148;

/**
 * @author logosty(ganyingle) on 2024/4/7 14:30
 * description: 1483. 树节点的第 K 个祖先 困难
 * 给你一棵树，树上有 n 个节点，按从 0 到 n-1 编号。树以父节点数组的形式给出，其中 parent[i] 是节点 i 的父节点。树的根节点是编号为 0 的节点。
 * <p>
 * 树节点的第 k 个祖先节点是从该节点到根节点路径上的第 k 个节点。
 * <p>
 * 实现 TreeAncestor 类：
 * <p>
 * TreeAncestor（int n， int[] parent） 对树和父数组中的节点数初始化对象。
 * getKthAncestor(int node, int k) 返回节点 node 的第 k 个祖先节点。如果不存在这样的祖先节点，返回 -1 。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：
 * ["TreeAncestor","getKthAncestor","getKthAncestor","getKthAncestor"]
 * [[7,[-1,0,0,1,1,2,2]],[3,1],[5,2],[6,3]]
 * <p>
 * 输出：
 * [null,1,0,-1]
 * <p>
 * 解释：
 * TreeAncestor treeAncestor = new TreeAncestor(7, [-1, 0, 0, 1, 1, 2, 2]);
 * <p>
 * treeAncestor.getKthAncestor(3, 1);  // 返回 1 ，它是 3 的父节点
 * treeAncestor.getKthAncestor(5, 2);  // 返回 0 ，它是 5 的祖父节点
 * treeAncestor.getKthAncestor(6, 3);  // 返回 -1 因为不存在满足要求的祖先节点
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= k <= n <= 5 * 104
 * parent[0] == -1 表示编号为 0 的节点是根节点。
 * 对于所有的 0 < i < n ，0 <= parent[i] < n 总成立
 * 0 <= node < n
 * 至多查询 5 * 104 次
 */
public class Solution1483 {
    static class TreeAncestor {

        //fathers[i][j] i号节点的2^j次方父节点
        int[][] fathers;

        public TreeAncestor(int n, int[] parent) {
            int y = (int) (Math.log(n) / Math.log(2));
            fathers = new int[n][y + 1];

            //初始化第一列
            for (int i = 0; i < parent.length; i++) {
                fathers[i][0] = parent[i];
            }

            //写好其他列  dp[i][j] = dp[dp[i][j-1]][j-1]
            for (int col = 1; col < fathers[0].length; col++) {

                for (int row = 0; row < n; row++) {

                    int father = fathers[row][col - 1];
                    if (father == -1) {
                        fathers[row][col] = -1;
                        continue;
                    }

                    fathers[row][col] = fathers[father][col - 1];
                }

            }
        }

        public int getKthAncestor(int node, int k) {
            int y = (int) (Math.log(k) / Math.log(2));
            if (fathers[node][y] == -1) {
                return -1;
            }

            int pow = (int) Math.pow(2, y);
            if (pow == k) {
                return fathers[node][y];
            }
            return getKthAncestor(fathers[node][y], k - pow);
        }
    }

    public static void main(String[] args) {
        TreeAncestor treeAncestor = new TreeAncestor(6, new int[] {-1, 2, 3, 4, 5, 0});
        System.out.println(treeAncestor.getKthAncestor(1, 4));

    }
}
