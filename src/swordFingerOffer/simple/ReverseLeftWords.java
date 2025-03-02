package src.swordFingerOffer.simple;

/**
 * 剑指 Offer 58 - II. 左旋转字符串
 *
 * @author Ernest
 * @version 1.0, 15/3/2021
 * @since 1.0.0
 */
public class ReverseLeftWords {
    /**
     * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
     * 请定义一个函数实现字符串左旋转操作的功能。
     * 比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
     *
     * @param s 初始字符串
     * @param n 左旋长度
     * @return 返回旋转后的字符串
     */
    public String reverseLeftWords(String s, int n) {
        StringBuilder res = new StringBuilder();
        res.append(s.substring(n, s.length() - 1));
        res.append(s.substring(0, n));
        return res.toString();
    }
}
