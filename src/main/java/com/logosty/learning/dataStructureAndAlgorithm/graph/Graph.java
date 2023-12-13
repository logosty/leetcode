package com.logosty.learning.dataStructureAndAlgorithm.graph;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author logosty(ganyingle) on 2023/12/7 18:55
 * description: 图
 */
public class Graph<T> {
    public HashMap<T, GraphNode<T>> nodes;
    public HashSet<GraphEdge<T>> edges;

    public Graph() {
        nodes = new HashMap<>();
        edges = new HashSet<>();
    }
}
