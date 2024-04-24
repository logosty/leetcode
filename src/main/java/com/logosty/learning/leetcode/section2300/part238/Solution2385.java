package com.logosty.learning.leetcode.section2300.part238;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.logosty.learning.util.pojo.TreeNode;

/**
 * @author logosty(ganyingle) on 2024/4/24 15:52
 * description: 2385. 感染二叉树需要的总时间 中等
 * 给你一棵二叉树的根节点 root ，二叉树中节点的值 互不相同 。另给你一个整数 start 。在第 0 分钟，感染 将会从值为 start 的节点开始爆发。
 * <p>
 * 每分钟，如果节点满足以下全部条件，就会被感染：
 * <p>
 * 节点此前还没有感染。
 * 节点与一个已感染节点相邻。
 * 返回感染整棵树需要的分钟数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [1,5,3,null,4,10,6,9,2], start = 3
 * 输出：4
 * 解释：节点按以下过程被感染：
 * - 第 0 分钟：节点 3
 * - 第 1 分钟：节点 1、10、6
 * - 第 2 分钟：节点5
 * - 第 3 分钟：节点 4
 * - 第 4 分钟：节点 9 和 2
 * 感染整棵树需要 4 分钟，所以返回 4 。
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [1], start = 1
 * 输出：0
 * 解释：第 0 分钟，树中唯一一个节点处于感染状态，返回 0 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中节点的数目在范围 [1, 105] 内
 * 1 <= Node.val <= 105
 * 每个节点的值 互不相同
 * 树中必定存在值为 start 的节点
 */
public class Solution2385 {
    Map<Integer, Point> pointMap = new HashMap<>();

    class Point {
        List<Point> points = new ArrayList<>();
    }

    public int amountOfTime(TreeNode root, int start) {
        Point point = new Point();
        pointMap.put(start, point);
        dfs(root, point);
        return infection(pointMap.get(start));
    }

    //从当前节点开始，层次遍历完所有节点
    private int infection(Point point) {
        Set<Point> hasLoopCache = new HashSet<>();
        ArrayDeque<Point> deque = new ArrayDeque<>();
        deque.addLast(point);
        hasLoopCache.add(point);

        int res = 0;
        while (!deque.isEmpty()) {

            int size = deque.size();
            for (int i = 0; i < size; i++) {
                Point pop = deque.pollFirst();

                for (Point point1 : pop.points) {
                    if (!hasLoopCache.contains(point1)) {
                        deque.addLast(point1);
                        hasLoopCache.add(point1);
                    }
                }

            }
            res++;
        }

        return res - 1;
    }

    /**
     * 构造并将自己的孩子点连入自己
     *
     * @param root 当前节点
     * @param point 当前节点所对应的点
     */
    private void dfs(TreeNode root, Point point) {
        if (root.left != null) {
            Point left = new Point();
            left.points.add(point);
            pointMap.put(root.left.val, left);
            point.points.add(left);
            dfs(root.left, left);
        }
        if (root.right != null) {
            Point right = new Point();
            right.points.add(point);
            pointMap.put(root.right.val, right);
            point.points.add(right);
            dfs(root.right, right);
        }
    }

}
