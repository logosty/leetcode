package com.logosty.learning.leetcode.section200.part27;

import com.alibaba.fastjson.JSON;
import java.util.ArrayList;
import java.util.List;

/**
 * @author logosty(ganyingle) on 2020/8/10 15:50
 *
 * 271. 字符串的编码与解码 中等
 * 请你设计一个算法，可以将一个 字符串列表 编码成为一个 字符串。这个编码后的字符串是可以通过网络进行高效传送的，并且可以在接收端被解码回原来的字符串列表。
 *
 * 1 号机（发送方）有如下函数：
 *
 * string encode(vector<string> strs) {
 *   // ... your code
 *   return encoded_string;
 * }
 * 2 号机（接收方）有如下函数：
 *
 * vector<string> decode(string s) {
 *   //... your code
 *   return strs;
 * }
 * 1 号机（发送方）执行：
 *
 * string encoded_string = encode(strs);
 * 2 号机（接收方）执行：
 *
 * vector<string> strs2 = decode(encoded_string);
 * 此时，2 号机（接收方）的 strs2 需要和 1 号机（发送方）的 strs 相同。
 *
 * 请你来实现这个 encode 和 decode 方法。
 *
 * 注意：
 *
 * 因为字符串可能会包含 256 个合法 ascii 字符中的任何字符，所以您的算法必须要能够处理任何可能会出现的字符。
 * 请勿使用 “类成员”、“全局变量” 或 “静态变量” 来存储这些状态，您的编码和解码算法应该是非状态依赖的。
 * 请不要依赖任何方法库，例如 eval 又或者是 serialize 之类的方法。本题的宗旨是需要您自己实现 “编码” 和 “解码” 算法。
 */
public class Solution271 {


  public static void main(String[] args) {
//     Your Codec object will be instantiated and called as such:

    List<String> strs = new ArrayList<>();
    for (int i = 0; i < 10; i++) {
      strs.add("strs" + i);
    }
    System.out.println(JSON.toJSONString(strs));

    Codec codec = new Codec();
    String encode = codec.encode(strs);
    System.out.println(encode);
    List<String> decode = codec.decode(encode);
    System.out.println(JSON.toJSONString(decode));


  }


}

class Codec {

  public static char END = '$';
  public static char DELIMITER = '#';

  // Encodes a list of strings to a single string.
  public String encode(List<String> strs) {
    StringBuilder sb = new StringBuilder();
    StringBuilder sb2 = new StringBuilder();

    for (int i = 0; i < strs.size(); i++) {
      sb.append(strs.get(i).length());
      sb.append(DELIMITER);

      sb2.append(strs.get(i));
    }

    return sb.append(END).append(sb2).toString();
  }

  // Decodes a single string to a list of strings.
  public List<String> decode(String s) {
    char[] chars = s.toCharArray();
    int end = 0;
    for (int i = 0; i < chars.length; i++) {
      if (chars[i] == END) {
        end = i;
        break;
      }
    }
    List<String> res = new ArrayList<>();
    int length = 0;
    int offset = end;
    for (int i = 0; i < end; i++) {
      if (chars[i] == DELIMITER) {
        res.add(s.substring(offset + 1, offset + 1 + length));
        offset += length;
        length = 0;
        continue;
      }
      length = length * 10 + (chars[i] - 48);
    }

    return res;
  }
}