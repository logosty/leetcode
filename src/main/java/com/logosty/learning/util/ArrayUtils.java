package com.logosty.learning.util;

import com.alibaba.fastjson.JSONObject;
import com.eclipsesource.json.JsonArray;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author logosty(ganyingle) on 2020/6/1 20:17
 */
public class ArrayUtils {
  public static char[] stringToCharArray(String input) {
    input = input.trim();
    input = input.substring(1, input.length() - 1);
    if (input.length() == 0) {
      return new char[0];
    }

    String[] parts = input.split(",");
    char[] output = new char[parts.length];
    for(int index = 0; index < parts.length; index++) {
      String part = parts[index].trim();
      output[index] = part.charAt(0);
    }
    return output;
  }

  public static int[] stringToIntegerArray(String input) {
    input = input.trim();
    input = input.substring(1, input.length() - 1);
    if (input.length() == 0) {
      return new int[0];
    }

    String[] parts = input.split(",");
    int[] output = new int[parts.length];
    for(int index = 0; index < parts.length; index++) {
      String part = parts[index].trim();
      output[index] = Integer.parseInt(part);
    }
    return output;
  }

  public static int[][] stringToInt2dArray(String input) {
    JsonArray jsonArray = JsonArray.readFrom(input);
    if (jsonArray.size() == 0) {
      return new int[0][0];
    }

    int[][] arr = new int[jsonArray.size()][];
    for (int i = 0; i < arr.length; i++) {
      JsonArray cols = jsonArray.get(i).asArray();
      arr[i] = stringToIntegerArray(cols.toString());
    }
    return arr;
  }

  public static char[][] stringToChar2dArray(String input) {
    JsonArray jsonArray = JsonArray.readFrom(input);
    if (jsonArray.size() == 0) {
      return new char[0][0];
    }

    char[][] arr = new char[jsonArray.size()][];
    for (int i = 0; i < arr.length; i++) {
      JsonArray cols = jsonArray.get(i).asArray();
      arr[i] = stringToCharArray(cols.toString());
    }
    return arr;
  }

  public static String booleanToString(boolean input) {
    return input ? "True" : "False";
  }

  /**
   * 打印数组
   */
  public static void printArray(int[] nums) {
    printArray("原数组结果为:", nums);
  }

  public static void printArray(String prefix, int[] nums) {
    System.out.println(prefix + JSONObject.toJSON(nums));
  }

  /**
   * 创建一个随机数组
   * @return
   */
  public static int[] createRandomArray() {
    return createRandomArray(ThreadLocalRandom.current().nextInt());
  }

  public static int[] createRandomArray(int length) {
    int[] nums = new int[length];
    for (int i = 0; i < nums.length; i++) {
      nums[i] = ThreadLocalRandom.current().nextInt(-length, length);
    }
    return nums;
  }

  /**
   * 更换两个值
   */
  public static void switchOne(int[] nums, int L, int R) {
    if (nums[L] == nums[R]) {
      return;
    }
    nums[L] = nums[L] ^ nums[R];
    nums[R] = nums[L] ^ nums[R];
    nums[L] = nums[L] ^ nums[R];
  }


  public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    String line;
    while ((line = in.readLine()) != null) {
      int[][] matrix = stringToInt2dArray(line);

//      boolean ret = new Solution().isToeplitzMatrix(matrix);
//
//      String out = booleanToString(ret);
//
//      System.out.print(out);
    }
  }
}
