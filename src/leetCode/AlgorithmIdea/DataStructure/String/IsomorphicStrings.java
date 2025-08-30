package leetCode.AlgorithmIdea.DataStructure.String;

/**
 * 数据结构：字符串
 * leetcode：https://leetcode-cn.com/problems/isomorphic-strings/
 * 同构字符串
 */
public class IsomorphicStrings {
    public boolean isomorphicStrings(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int n = s.length();
        int[] lastS = new int[256];
        int[] lastT = new int[256];
        for (int i = 0; i < n; i++) {
            char cs = s.charAt(i);
            char ct = t.charAt(i);
            if (lastS[cs] != lastT[ct]) {
                return false;
            }
            lastS[cs] = i + 1;
            lastT[ct] = i + 1;
        }
        return true;
    }
}
