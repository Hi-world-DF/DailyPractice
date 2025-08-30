package swordFingerOffer.simple;

/**
 * 剑指 Offer 58 - I. 翻转单词顺序
 *
 * @author Ernest
 * @version 1.0, 17/3/2021
 * @since 1.0.0
 */
public class ReverseWords {
    /**
     * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。
     * 为简单起见，标点符号和普通字母一样处理。
     * 例如输入字符串"I am a student. "，则输出"student. a am I"。
     *
     * @param s 初始数组
     * @return 返回反转后的字符串
     */
    public String reverseWords(String s) {
        String[] cur = s.trim().split(" ");
        StringBuilder res = new StringBuilder();
        for (int i = cur.length - 1;i >= 0; i--) {
            if(cur[i].equals("")) {
                continue;
            }
            res.append(cur[i] + " ");
        }
        return res.toString().trim();
    }
}
