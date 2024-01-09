package LeetCode.AlgorithmIdea.math;
/**
 * 数学问题
 * https://leetcode-cn.com/problems/add-strings/
 * 问题描述：字符串求和
 * */
public class AddStrings {
    public String addStrings(String num1, String num2) {
        int carry = 0;
        int l1 = num1.length() -1;
        int l2 = num2.length() -1;
        StringBuilder result = new StringBuilder();
        while(carry == 1 || l1 >= 0 || l2 >= 0){
            int x = l1 < 0? 0 : + num1.charAt(l1);
            int y = l2 < 0? 0 : + num2.charAt(l2);
            result.append((x+y+carry) % 10);
            carry = (x+y+carry) / 10;
            l1--;l2--;
        }
        return result.reverse().toString();
    }
}
