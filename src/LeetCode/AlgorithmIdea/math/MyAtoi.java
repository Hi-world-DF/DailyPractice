package AlgorithmIdea.math;

/**
 * 8. 字符串转换整数 (atoi)
 *
 * @author Ernest
 * @version 1.0, 14/3/2021
 * @since 1.0.0
 */
public class MyAtoi {

    /**
     * 读入字符串并丢弃无用的前导空格
     * 检查下一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。 确定最终结果是负数还是正数。 如果两者都不存在，则假定结果为正。
     * 读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。
     * 将前面步骤读入的这些数字转换为整数（即，"123" -> 123， "0032" -> 32）。如果没有读入数字，则整数为 0 。必要时更改符号（从步骤 2 开始）。
     * 如果整数数超过 32 位有符号整数范围 [−231,  231 − 1] ，需要截断这个整数，使其保持在这个范围内。具体来说，小于 −231 的整数应该被固定为 −231 ，大于 231 − 1 的整数应该被固定为 231 − 1 。
     * 返回整数作为最终结果。
     *
     * @param s 初始字符串
     * @return 返回字符串的整数
     */
    public int myAtoi(String s) {
        int i;
        int n = s.length();
        boolean isNegative = false;
        for (i = 0; i < n; i++) {
            if (s.charAt(i) == ' ') {
                continue;
            }
            if (s.charAt(i) == '-') {
                isNegative = true;
            }

            if (s.charAt(i) == '-' || s.charAt(i) == '+') {
                continue;
            }
            if (s.charAt(i) <= '9' && s.charAt(i) >= '0') {
                break;
            } else {
                return 0;
            }
        }
        int j = i;
        int res = 0;
        while (j < n && s.charAt(j) <= '9' && s.charAt(j) >= '0' ) {
            res = (s.charAt(j) - '0') + res * 10;
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && (s.charAt(j) - '0') > Integer.MAX_VALUE % 10)) {
                return Integer.MIN_VALUE;
            }
            if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && (s.charAt(j) - '0') > -(Integer.MIN_VALUE % 10))) {
                return Integer.MAX_VALUE;
            }
            j++;
        }
        return isNegative ? 0 - res : res;
    }

    public static void main(String[] args) {
        MyAtoi m = new MyAtoi();
        System.out.println(m.myAtoi(" -56 wor"));
    }
}
