package com.logosty.learning.leetcode.section700.part73;

import com.alibaba.fastjson.JSON;
import com.logosty.learning.util.ArrayUtils;
import java.util.Stack;

/**
 * @author logosty(ganyingle) on 2020/6/11 10:26
 * 739. 每日温度 中等
 * 根据每日 气温 列表，请重新生成一个列表，对应位置的输出是需要再等待多久温度才会升高超过该日的天数。如果之后都不会升高，请在该位置用 0 来代替。
 *
 * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
 *
 * 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
 */
public class Solution739 {

  public int[] dailyTemperatures(int[] T) {
    int[] ret = new int[T.length];
    Stack<Integer> stack = new Stack<>();

    for (int i = 0; i < T.length; i++) {
      if (stack.isEmpty()) {
        stack.push(i);
        continue;
      }

      Integer top = stack.peek();
      if (T[i] <= T[top]) {
        stack.push(i);
        continue;
      }

      while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
        Integer pop = stack.pop();
        ret[pop] = i - pop;
      }
      stack.push(i);
    }

    while (!stack.isEmpty()) {
      Integer pop = stack.pop();
      ret[pop] = 0;
    }
    return ret;
  }

  public int[] dailyTemperatures1(int[] T) {
    for (int i = 0; i < T.length; i++) {
      int retBit = 0;
      for (int j = i + 1; j < T.length; j++) {
        if (T[j] > T[i]) {
          retBit = j - i;
          break;
        }
      }
      T[i] = retBit;
    }

    return T;
  }

  public static void main(String[] args) {
    int[] ints = ArrayUtils.stringToIntegerArray("[73,74,75,71,69,72,76,73]");
    System.out.println(JSON.toJSONString(new Solution739().dailyTemperatures(ints)));
  }
}
