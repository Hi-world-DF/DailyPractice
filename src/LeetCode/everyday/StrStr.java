package everyday;

/**
 * 28. 实现 strStr()
 *
 * @author Ernest
 * @version 1.0, 16/3/2021
 * @since 1.0.0
 */
public class StrStr {
    /**
     * 给定一个 haystack 字符串和一个 needle 字符串，
     * 在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。
     * 如果不存在，则返回  -1。
     *
     * @param haystack 初始字符串
     * @param needle 目标字符串
     * @return 返回目标字符串出现的第一个位置
     */
    public int strStr(String haystack, String needle) {
        int n = needle.length();
        int hl = haystack.length();
        for (int i = 0; i < hl - n + 1; i++) {
            String cur = haystack.substring(i, i + n);
            if (cur.equals(needle)) {
                return i;
            }
        }
        return -1;
    }
}
