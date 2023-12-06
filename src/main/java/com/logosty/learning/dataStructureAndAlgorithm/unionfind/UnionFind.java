package com.logosty.learning.dataStructureAndAlgorithm.unionfind;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author logosty(ganyingle) on 2023/12/5 21:00
 * description: 并查集工具
 */
public class UnionFind<T> {
    static class Node<T> {
        T value;

        public Node(T value) {
            this.value = value;
        }
    }

    private Map<T, Node<T>> nodeMap = new HashMap<>();
    private Map<Node<T>, Node<T>> fatherMap = new HashMap<>();
    private Map<Node<T>, Integer> sizeMap = new HashMap<>();

    public UnionFind() {

    }

    public UnionFind(T... values) {

        for (T value : values) {
            Node<T> node = new Node<>(value);
            nodeMap.put(value, node);
            fatherMap.put(node, node);
            sizeMap.put(node, 1);
        }
    }

    //往并查集中加一个新的集合
    public Node<T> addOneValue(T value) {
        Node<T> node = new Node<>(value);
        nodeMap.put(value, node);
        fatherMap.put(node, node);
        sizeMap.put(node, 1);
        return node;
    }

    //判断两个元素所处的集合是否是同一个
    public boolean isSameSet(T valueA, T valueB) {
        Node<T> nodeA = nodeMap.get(valueA);
        Node<T> nodeB = nodeMap.get(valueB);

        //都没录入，这是异常了把
        if (nodeA == null || nodeB == null) {
            return false;
        }

        Node<T> fatherA = findFather(nodeA);
        Node<T> fatherB = findFather(nodeB);

        return fatherA == fatherB;
    }

    private Node<T> findFather(Node<T> node) {
        //用栈存储子链，以便后续优化调整
        Stack<Node<T>> stack = new Stack<>();

        while (fatherMap.containsKey(node)) {
            if (fatherMap.get(node) == node) {
                break;
            }
            stack.push(node);
            node = fatherMap.get(node);
        }

        while (stack.size() > 1) {
            Node<T> node1 = stack.pop();
            fatherMap.put(node1, node);
        }

        return node;
    }

    //将两个元素所处集合合并
    public void union(T valueA, T valueB) {
        Node<T> nodeA = nodeMap.get(valueA);
        Node<T> nodeB = nodeMap.get(valueB);

        //都没录入，这是异常了把,生成一个新的
        if (nodeA == null) {
            nodeA = addOneValue(valueA);
        }
        if (nodeB == null) {
            nodeB = addOneValue(valueB);
        }

        Node<T> fatherA = findFather(nodeA);
        Node<T> fatherB = findFather(nodeB);

        if (fatherA == fatherB) {
            return;
        }

        //获取集合的size，小挂大
        int sizeA = sizeMap.get(fatherA);
        int sizeB = sizeMap.get(fatherB);

        Node<T> smallNode;
        Node<T> bigNode;

        if (sizeA < sizeB) {
            smallNode = fatherA;
        } else {
            smallNode = fatherB;
        }
        bigNode = smallNode == fatherA ? fatherB : fatherA;

        //调整小集合指针到大集合
        fatherMap.put(smallNode, bigNode);

        sizeMap.remove(smallNode);
        sizeMap.put(bigNode, sizeA + sizeB);
    }

    public int setCount() {
        return sizeMap.size();
    }
}
