package src.leetCode.everyday;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 3. 无重复字符的最长子串
 *
 * @author Ernest
 * @version 1.0, 16/3/2021
 * @since 1.0.0
 */
public class LengthOfLongestSubstring {
    /**
     * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
     *
     * @param s 初始字符串
     * @return 返回最长子串的长度
     */

    /** 暴力解法 */
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            int count = 0;
            HashMap<Character,Integer> map = new HashMap<>();
            for (int j = i; j < s.length(); j++) {
                char c = s.charAt(j);
                if (!map.containsKey(c)) {
                    map.put(c,1);
                    count++;
                } else {
                    break;
                }
            }
            max = Math.max(count, max);
        }
        return max;
    }
    /** 解法2：滑动窗口 */
    public int lengthOfLongestSubstring2(String s) {
        Set<Character> cSet = new HashSet<>();
        int n = s.length();
        int index = -1, max = 0;
        for (int i = 0; i < n; i++) {
            if (i != 0) {
                cSet.remove(s.charAt(i - 1));
            }
            while (index + 1 < n && !cSet.contains(s.charAt(index + 1))) {
                cSet.add(s.charAt(index + 1));
                index++;
            }
            max = Math.max(max, index - i + 1);
        }
        return max;
    }
}
