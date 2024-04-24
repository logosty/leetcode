package com.logosty.learning.leetcode.section2300.part238;

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
    int res;
    public int amountOfTime(TreeNode root, int start) {
        dfs(root, start);
        return res - 1;
    }


    //返回包含该节点的最大深度
    private Info dfs(TreeNode root, int start) {
        Info info = new Info();
        if (root == null) {
            return info;
        }
        //当前节点已经是了
        Info leftInfo = dfs(root.left, start);
        Info rightInfo = dfs(root.right, start);
        if (root.val == start) {
            res = Math.max(res, Math.max(leftInfo.length, rightInfo.length) + 1);
            info.hasTarget = true;
            info.length = 1;
            return info;
        }

        //都不包含，就返回最大值
        if (!leftInfo.hasTarget && !rightInfo.hasTarget) {
            info.length = Math.max(leftInfo.length, rightInfo.length) + 1;
            return info;
        }

        info.hasTarget = true;
        res = Math.max(res, leftInfo.length + rightInfo.length + 1);
        info.length = 1 + (leftInfo.hasTarget ? leftInfo.length : rightInfo.length);
        return info;
    }

    class Info {
        boolean hasTarget;
        int length;
    }
}
