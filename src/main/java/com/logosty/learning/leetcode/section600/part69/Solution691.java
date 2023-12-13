package com.logosty.learning.leetcode.section600.part69;

/**
 * @author logosty(ganyingle) on 2023/12/13 15:54
 * description: 691. 贴纸拼词 困难
 * 我们有 n 种不同的贴纸。每个贴纸上都有一个小写的英文单词。
 * <p>
 * 您想要拼写出给定的字符串 target ，方法是从收集的贴纸中切割单个字母并重新排列它们。如果你愿意，你可以多次使用每个贴纸，每个贴纸的数量是无限的。
 * <p>
 * 返回你需要拼出 target 的最小贴纸数量。如果任务不可能，则返回 -1 。
 * <p>
 * 注意：在所有的测试用例中，所有的单词都是从 1000 个最常见的美国英语单词中随机选择的，并且 target 被选择为两个随机单词的连接。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： stickers = ["with","example","science"], target = "thehat"
 * 输出：3
 * 解释：
 * 我们可以使用 2 个 "with" 贴纸，和 1 个 "example" 贴纸。
 * 把贴纸上的字母剪下来并重新排列后，就可以形成目标 “thehat“ 了。
 * 此外，这是形成目标字符串所需的最小贴纸数量。
 * 示例 2:
 * <p>
 * 输入：stickers = ["notice","possible"], target = "basicbasic"
 * 输出：-1
 * 解释：我们不能通过剪切给定贴纸的字母来形成目标“basicbasic”。
 * <p>
 * <p>
 * 提示:
 * <p>
 * n == stickers.length
 * 1 <= n <= 50
 * 1 <= stickers[i].length <= 10
 * 1 <= target.length <= 15
 * stickers[i] 和 target 由小写英文单词组成
 */
public class Solution691 {
    public int minStickers(String[] stickers, String target) {
        int[] targetNum = new int[26];
        for (char c : target.toCharArray()) {
            targetNum[c - 'a']++;
        }

        int[][] stickerNums = new int[stickers.length][26];
        for (int i = 0; i < stickers.length; i++) {
            for (char c : stickers[i].toCharArray()) {
                stickerNums[i][c - 'a']++;
            }
        }

        return process(targetNum, stickerNums, 0);

    }

    /**
     * @param stickerIndex 当前遍历到第i张卡了
     * @return 最小值
     */
    private int process(int[] targetNum, int[][] stickerNums, int stickerIndex) {
        if (stickerIndex >= stickerNums.length) {
            return -1;
        }

        int[] stickerNum = stickerNums[stickerIndex];

        //当前字符串取一遍，如果没变化，直接跳下一步
        if (!isEffect(targetNum, stickerNum)) {
            return process(targetNum, stickerNums, stickerIndex + 1);
        }

        //取当前字符串 和 不取当前字符串，取最小值
        subtract(targetNum, stickerNum);
        if (isEmpty(targetNum)) { //已经match了
            add(targetNum, stickerNum);
            return 1;
        }
        int ans1 = process(targetNum, stickerNums, stickerIndex); //+1
        add(targetNum, stickerNum);

        int ans2 = process(targetNum, stickerNums, stickerIndex + 1);

        if (ans1 == -1) {
            return ans2;
        }
        if (ans2 == -1) {
            return ans1 + 1;
        }

        return Math.min(ans1 + 1, ans2);
    }

    private void add(int[] origin, int[] target) {
        for (int i = 0; i < origin.length; i++) {
            origin[i] += target[i];
        }
    }

    private void subtract(int[] origin, int[] target) {
        for (int i = 0; i < origin.length; i++) {
            origin[i] -= target[i];
        }
    }

    private boolean isEffect(int[] origin, int[] target) {
        for (int i = 0; i < origin.length; i++) {
            if (origin[i] > 0 && target[i] > 0) {
                return true;
            }
        }
        return false;
    }

    private boolean isEmpty(int[] origin) {
        for (int i = 0; i < origin.length; i++) {
            if (origin[i] > 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] stickers = {"seven","old","stream","century","energy","period","an","proper","together","sight","carry","milk","appear","winter","field","rather","caught","danger","lake","shall","machine","few","other","test","got","wing","map","finish","though","observe","log","they","foot","path","eat","glad","must","bar","did","of","clear","work","rule","quotient","produce","clean","wild","grass","example","left"};
        String target = "weresurprise";
        System.out.println(new Solution691().minStickers(stickers, target));

    }

}
