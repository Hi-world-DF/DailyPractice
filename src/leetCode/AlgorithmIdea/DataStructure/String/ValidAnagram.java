package leetCode.AlgorithmIdea.DataStructure.String;


import java.util.Arrays;

/**
 * 数据结构：字符串
 * leetcode：https://leetcode-cn.com/problems/valid-anagram/
 * 两个字符串所包含的字符是否完全相同
 */
public class ValidAnagram {
    //方法一：转换为字符数组，然后排序，最后比较
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1, str2);
    }

    //方法二：HashMap
    public boolean isAnagram1(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'b']--;
        }
        for (int c : counter) {
            if (c != 0) {
                return false;
            }
        }
        return true;
    }
}
