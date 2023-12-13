package com.logosty.learning.dataStructureAndAlgorithm.graph;

/**
 * @author logosty(ganyingle) on 2023/12/7 18:50
 * description: 图的边
 */
public class GraphEdge<T> {
    public int weight;

    public GraphNode<T> from;
    public GraphNode<T> to;

    public GraphEdge(int weight, GraphNode<T> from, GraphNode<T> to) {
        this.weight = weight;
        this.from = from;
        this.to = to;
    }
}
