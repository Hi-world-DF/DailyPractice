package swordFingerOffer.simple;

/**
 * 剑指 Offer 46. 把数字翻译成字符串
 *
 * @author Ernest
 * @version 1.0, 17/3/2021
 * @since 1.0.0
 */
public class TranslateNum {
    /**
     * 给定一个数字，我们按照如下规则把它翻译为字符串：
     * 0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。
     * 一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
     *
     * @param num 初始数字
     * @return 翻译的总方式
     */
    public int translateNum(int num) {
        String s = String.valueOf(num);
        int len = s.length();
        if (len < 2) {
            return len;
        }
        char[] chars = s.toCharArray();
        int[] dp = new int[len + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 1; i < len; i++) {
            dp[i + 1] = dp[i];
            int cur = 10 * (chars[i - 1] - '0') + (chars[i] - '0');
            if (cur > 9 && cur < 26) {
                dp[i + 1] = dp[i] + dp[i-1];
            }
        }
        return dp[len];
    }
}
