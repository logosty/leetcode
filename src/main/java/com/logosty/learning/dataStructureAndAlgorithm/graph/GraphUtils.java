package com.logosty.learning.dataStructureAndAlgorithm.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * @author logosty(ganyingle) on 2023/12/7 19:06
 * description: 图的工具方法
 */
public class GraphUtils {

    /**
     * 深度遍历
     * @param firstGraphNode 头结点
     * @return 深度遍历的顺序结点
     */
    public static <T> List<GraphNode<T>> bfs(GraphNode<T> firstGraphNode) {
        Queue<GraphNode<T>> queue = new LinkedList<>();
        Set<GraphNode<T>> hadPushed = new HashSet<>();
        List<GraphNode<T>> res = new ArrayList<>();

        queue.add(firstGraphNode);
        hadPushed.add(firstGraphNode);

        while (!queue.isEmpty()) {
            GraphNode<T> tGraphNode = queue.poll();
            res.add(tGraphNode);

            for (GraphNode<T> next : tGraphNode.nexts) {
                if (!hadPushed.contains(next)) {
                    queue.add(next);
                    hadPushed.add(next);
                }
            }
        }
        return res;
    }

    /**
     * 深度遍历打印
     *
     * @param firstGraphNode 头结点
     */
    public static <T> void bfsPrint(GraphNode<T> firstGraphNode) {
        List<GraphNode<T>> nodeList = bfs(firstGraphNode);
        for (GraphNode<T> tGraphNode : nodeList) {
            System.out.print(tGraphNode.value.toString() + ",");
        }
    }


    public static void main(String[] args) {
        Integer[][] ints = {{1, 2, 0}, {2, 3, 0}, {3, 4, 0}, {2, 5, 0}, {3, 6, 0}, {5, 6, 0}, {6, 7, 0}, {7, 5, 0},};
        Graph<Integer> graph = GraphCreator.buildGraph(ints);

        GraphUtils.bfsPrint(graph.nodes.values().stream().findFirst().get());
    }
}
