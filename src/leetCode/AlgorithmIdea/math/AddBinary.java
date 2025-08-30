package leetCode.AlgorithmIdea.math;

/**
 * 数学问题
 * leetcode:https://leetcode-cn.com/problems/add-binary/
 * 问题描述：二进制求和
 */
public class AddBinary {
    public String addBinary(String a, String b) {
        int carry = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;
        StringBuilder sb = new StringBuilder();
        while (carry == 1 || i >= 0 || j >= 0) {
            if (i >= 0 && a.charAt(i) == '1') {
                carry++;
            }
            if (j >= 0 && b.charAt(j) == '1') {
                carry++;
            }
            sb.append(carry % 2);
            carry /= 2;
            i--;
            j--;
        }
        return sb.reverse().toString();
    }
}
