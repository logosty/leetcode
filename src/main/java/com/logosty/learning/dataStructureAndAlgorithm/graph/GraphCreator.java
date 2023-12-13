package com.logosty.learning.dataStructureAndAlgorithm.graph;

/**
 * @author logosty(ganyingle) on 2023/12/7 19:06
 * description: 图构造器
 */
public class GraphCreator {

    /**
     *
     * @param matrix:  matrix[0]:   [a点][b点][weight]
     */
    public static Graph<Integer> buildGraph(Integer[][] matrix) {
        Graph<Integer> graph = new Graph<>();

        for (Integer[] integers : matrix) {
            Integer from = integers[0];
            Integer to = integers[1];
            Integer weight = integers[2];

            if (!graph.nodes.containsKey(from)) {
                graph.nodes.put(from, new GraphNode<>(from));
            }
            if (!graph.nodes.containsKey(to)) {
                graph.nodes.put(to, new GraphNode<>(to));
            }

            GraphNode<Integer> fromNode = graph.nodes.get(from);
            GraphNode<Integer> toNode = graph.nodes.get(to);

            GraphEdge<Integer> newEdge = new GraphEdge<>(weight, fromNode, toNode);

            fromNode.edges.add(newEdge);
            fromNode.nexts.add(toNode);

            fromNode.out++;
            toNode.in++;

            graph.edges.add(newEdge);
        }
        return graph;
    }

}
