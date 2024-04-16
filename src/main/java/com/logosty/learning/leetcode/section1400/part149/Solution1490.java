package com.logosty.learning.leetcode.section1400.part149;

import java.util.ArrayList;
import java.util.List;

/**
 * @author logosty(ganyingle) on 2024/4/16 19:28
 * description:1490. 克隆N叉树 中等
 * 给定一棵 N 叉树的根节点 root ，返回该树的深拷贝（克隆）。
 * <p>
 * N 叉树的每个节点都包含一个值（ int ）和子节点的列表（ List[Node] ）。
 * <p>
 * class Node {
 * public int val;
 * public List<Node> children;
 * }
 * N 叉树的输入序列用层序遍历表示，每组子节点用 null 分隔（见示例）。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：root = [1,null,3,2,4,null,5,6]
 * 输出：[1,null,3,2,4,null,5,6]
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
 * 输出：[1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 给定的 N 叉树的深度小于或等于 1000。
 * 节点的总个数在 [0, 10^4] 之间
 * <p>
 * <p>
 * <p>
 * 进阶：你的解决方案可以适用于克隆图问题吗？
 * <p>
 * // Definition for a Node.
 * class Node {
 * public int val;
 * public List<Node> children;
 * <p>
 * <p>
 * public Node() {
 * children = new ArrayList<Node>();
 * }
 * <p>
 * public Node(int _val) {
 * val = _val;
 * children = new ArrayList<Node>();
 * }
 * <p>
 * public Node(int _val,ArrayList<Node> _children) {
 * val = _val;
 * children = _children;
 * }
 * };
 */
public class Solution1490 {
    // Definition for a Node.
    class Node {
        public int val;
        public List<Node> children;


        public Node() {
            children = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            children = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _children) {
            val = _val;
            children = _children;
        }
    }


    public Node cloneTree(Node root) {
        if (root == null) return null;

        Node node = new Node(root.val);
        clone(node, root);
        return node;
    }

    private void clone(Node root, Node target) {
        for (Node child : target.children) {
            Node node = new Node(child.val);
            root.children.add(node);
            clone(node, child);

        }
    }
}
