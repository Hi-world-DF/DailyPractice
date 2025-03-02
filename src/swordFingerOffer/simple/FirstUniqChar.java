package src.swordFingerOffer.simple;

import java.util.HashMap;

/**
 * 剑指 Offer 50. 第一个只出现一次的字符
 *
 * @author Ernest
 * @version 1.0, 17/3/2021
 * @since 1.0.0
 */
public class FirstUniqChar {
    /**
     * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
     *
     * @param s 初始字符串
     * @return 第一个只出现一次的字符
     */
    public char firstUniqChar(String s) {
        if (s == null || s.length() == 0) {
            return ' ';
        }
        HashMap<Character,Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (char c : chars) {
            if (map.get(c) == 1) {
                return c;
            }
        }
        return ' ';
    }
}
