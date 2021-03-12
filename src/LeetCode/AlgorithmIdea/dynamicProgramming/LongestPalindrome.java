package AlgorithmIdea.dynamicProgramming;

/**
 * leetcode 5. 最长回文子串
 *
 * @author Ernest
 * @version 1.0, 12/3/2021
 * @since 1.0.0
 */
public class LongestPalindrome {
    /**
     * 给你一个字符串 s，找到 s 中最长的回文子串。
     *
     * @param s 初始字符串
     * @return 返回最长的回文子串
     */
    public String longestPalindrome(String s) {
        int n = s.length();
        if (n < 2) {
            return s;
        }

        int maxRes = 1;
        int begin = 0;

        boolean[][] dp = new boolean[n][n];
        char[] chars = s.toCharArray();

        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (chars[j] != chars[i]) {
                    dp[j][i] = false;
                } else {
                    if (i - j < 3) {
                        dp[j][i] = true;
                    } else {
                        dp[j][i] = dp[j + 1][i - 1];
                    }
                }
                if (dp[j][i] && i - j + 1> maxRes) {
                    maxRes = i - j + 1;
                    begin = j;
                }
            }
        }
        return s.substring(begin, begin + maxRes);
    }
}
