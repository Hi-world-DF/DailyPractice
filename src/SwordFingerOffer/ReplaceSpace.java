package SwordFingerOffer;

/**
 * 剑指 Offer 05. 替换空格
 *
 * @author Ernest
 * @version 1.0, 10/3/2021
 * @since 1.0.0
 */
public class ReplaceSpace {
    /**
     * 把字符串 s 中的每个空格替换成"%20"。
     *
     * @param s 初始字符串
     * @return 返回替换后的字符串
     */
    public String replaceSpace(String s) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                res.append("%20");
            } else {
                res.append(s.charAt(i));
            }
        }
        return res.toString();
    }
}
