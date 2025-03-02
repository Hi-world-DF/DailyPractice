package src.leetCode.everyday;

/**
 * 58. 最后一个单词的长度
 *
 * @author Ernest
 * @version 1.0, 15/4/2021
 * @since 1.0.0
 */
public class LengthOfLastWord {
    /**
     * 给你一个字符串 s，由若干单词组成，单词之间用空格隔开。
     * 返回字符串中最后一个单词的长度。如果不存在最后一个单词，请返回 0 。
     * 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
     *
     * @param s 初始字符串
     * @return 最后一个单词的长度
     */
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        String[] cur = s.split(" ");
        if (cur == null || cur.length == 0) {
            return 0;
        }
        int n = cur.length;
        String res = cur[n-1];
        return res.length();
    }
}
