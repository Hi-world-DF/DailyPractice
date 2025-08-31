package leetCode.AlgorithmIdea.DataStructure.HashMap;

import java.util.HashMap;

/**
 * 统计一致字符串的数目:给你一个由不同字符组成的字符串 allowed 和一个字符串数组 words 。
 *          如果一个字符串的每一个字符都在 allowed 中，就称这个字符串是 一致字符串 。
 *
 * @author Ernest
 * @version 1.0, 26/2/2021
 * @since 1.0.0
 */
public class CountConsistentStrings {
    /**
     * 统计一致字符串的数目
     *
     * @param allowed 不同字符组成的字符串
     * @param words 字符串数组
     * @return 一致字符串的数目
     */
    public int countConsistentStrings(String allowed, String[] words) {
        int res = 0;
        int len = allowed.length();
        HashMap<Character,Integer> map = new HashMap<>(26);
        for (int i = 0; i < len; i++) {
            char c = allowed.charAt(i);
            map.put(c, 1);
        }
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            int j;
            for (j = 0; j < word.length(); j++) {
                if (!map.containsKey(word.charAt(j))) {
                    break;
                }
            }
            if (j == word.length()) {
                res++;
            }
        }
        return res;
    }
}
