package com.logosty.learning.dataStructureAndAlgorithm.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * @author logosty(ganyingle) on 2023/12/7 18:50
 * description: 图的点
 */
public class GraphNode<T> {
    public T value;
    public int out; //出度
    public int in; //入度

    List<GraphEdge<T>> edges;
    List<GraphNode<T>> nexts;

    public GraphNode(T value) {
        this.value = value;
        in = 0;
        out = 0;
        edges = new ArrayList<>();
        nexts = new ArrayList<>();
    }
}
