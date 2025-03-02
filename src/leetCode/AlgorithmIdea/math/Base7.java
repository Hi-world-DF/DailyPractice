package src.leetCode.AlgorithmIdea.math;
/**
 * 数学问题
 * leetcode:https://leetcode-cn.com/problems/base-7/
 * 问题描述：七进制数
 * */
public class Base7 {
    public String convertToBase7(int num) {
        if(num == 0) return "0";
        StringBuffer result = new StringBuffer();
        int numIndex = num;
        if(num < 0) num = -num;
        while(num > 0) {
            result.append(num % 7);
            num /= 7;
        }
        String re = result.reverse().toString();
        if(numIndex < 0) return "-" + re;
        return re;
    }

    public static void main(String[] args) {
        Base7 base7 = new Base7();
        String s = base7.convertToBase7(-104);
        System.out.println(s);
    }
}
