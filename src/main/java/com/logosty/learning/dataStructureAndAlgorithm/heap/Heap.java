package com.logosty.learning.dataStructureAndAlgorithm.heap;

import java.util.concurrent.ThreadLocalRandom;

import com.logosty.learning.util.ArrayUtils;

/**
 * @author logosty(ganyingle) on 2023/11/20 16:30
 * description: 最小堆
 *
 * 使用数组实现堆，父节点位置为 i-1/2, 子节点为 2*i+1,2*i+2
 */
public class Heap {
    private final int[] content;
    private int size = -1;

    public Heap(int size) {
        content = new int[size];
    }

    public Heap() {
        content = new int[100000];
    }

    public void addOne(int num) {
        if (size == content.length) {
            throw new RuntimeException("full!");
        }
        content[++size] = num;
        doRefactor(size);
    }

    public int getMin() {
        return content[0];
    }

    private void doRefactor(int index) {
        //比父节点小，就和父节点交换
        while (index != 0) {
            int fatherIndex = (index - 1) / 2;
            if (content[index] >= content[fatherIndex]) {
                return;
            }
            ArrayUtils.switchOne(content, index, fatherIndex);
            index = fatherIndex;
        }
    }

    public static void main(String[] args) {
        Heap heap = new Heap(100);
        for (int i = 0; i < 100; i++) {
            heap.addOne(ThreadLocalRandom.current().nextInt(-100, 100));
            if (ThreadLocalRandom.current().nextInt(1, 10) <= 1) {
                System.out.println("最小值为：" + heap.getMin());
            }
        }
        System.out.println("----最小值为：" + heap.getMin());
    }
}
