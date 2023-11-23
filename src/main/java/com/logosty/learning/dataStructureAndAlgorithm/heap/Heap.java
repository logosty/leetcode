package com.logosty.learning.dataStructureAndAlgorithm.heap;

import java.util.PriorityQueue;
import java.util.concurrent.ThreadLocalRandom;

import com.logosty.learning.util.ArrayUtils;

/**
 * @author logosty(ganyingle) on 2023/11/20 16:30
 * description: 最小堆
 * <p>
 * 使用数组实现堆，父节点位置为 i-1/2, 子节点为 2*i+1,2*i+2
 */
public class Heap {
    private final int[] content;
    private int curIndex = -1;

    public Heap(int size) {
        content = new int[size];
    }

    public Heap() {
        content = new int[100000];
    }

    public Heap(int[] nums) {
        if (nums.length < 1) {
            throw new RuntimeException("illegal nums");
        }
        content = new int[nums.length];
        curIndex = content.length - 1;

        for (int i = nums.length - 1; i >= 0; i--) {
            content[i] = nums[i];
            heapify(i);
        }
        System.out.println("");
    }

    public void addOne(int num) {
        if (curIndex == content.length - 1) {
            throw new RuntimeException("full!");
        }
        content[++curIndex] = num;
        heapInsert(curIndex);
    }

    public int getMin() {
        if (!hasNum()) {
            throw new RuntimeException("empty cant getMin!");
        }
        return content[0];
    }

    public boolean hasNum() {
        return curIndex >= 0;
    }

    public int popMin() {
        if (!hasNum()) {
            throw new RuntimeException("empty cant pop!");
        }
        int res = content[0];

        if (curIndex == 0) {
            curIndex--;
            return res;
        }

        //交换头尾，并且 curIndex 减一
        content[0] = content[curIndex];
        content[curIndex] = 0;
        curIndex--;
        //头结点依次往下腾挪
        int curr = 0;
        heapify(curr);

        return res;
    }

    /**
     * 下沉
     */
    public void heapify(int index) {
        while (true) {
            int minSonIndex = index;
            int minSonValue = content[index];

            int leftSonIndex = 2 * index + 1;
            int rightSonIndex = 2 * index + 2;

            //存在左孩子
            if (leftSonIndex <= curIndex) {
                if (minSonValue > content[leftSonIndex]) {
                    minSonIndex = leftSonIndex;
                    minSonValue = content[leftSonIndex];
                }
            }

            //存在右孩子
            if (rightSonIndex <= curIndex) {
                if (minSonValue > content[rightSonIndex]) {
                    minSonIndex = rightSonIndex;
                    minSonValue = content[rightSonIndex];
                }
            }

            //需要交换才继续
            if (minSonIndex == index) {
                break;
            }

            ArrayUtils.switchOne(content, index, minSonIndex);
            index = minSonIndex;
        }
    }

    /**
     * 上浮
     */
    private void heapInsert(int index) {
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


    public void print() {
        ArrayUtils.printArray("当前index：" + curIndex, content);
    }

    public static void main(String[] args) {
        int size = 20;
        Heap heap = new Heap(size);
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(20);

        for (int i = 0; i < size; i++) {
            int nextInt = ThreadLocalRandom.current().nextInt(1, 2 * size);
            heap.addOne(nextInt);
            priorityQueue.add(nextInt);
        }

        heap.print();

        for (int i = 0; i < size; i++) {
            if (ThreadLocalRandom.current().nextInt(0, 1) <= 1) {
                heap.print();
                System.out.println("最小值为：" + heap.getMin());
                int popMin = heap.popMin();
                System.out.println("popMin:" + popMin + " 后最小值为：" + heap.getMin());
            }
        }
        System.out.println("----最小值为：" + heap.getMin());

    }
}
