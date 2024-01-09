package LeetCode.AlgorithmIdea.math;
/**
 * 数学问题
 * leetcode:https://leetcode-cn.com/problems/convert-a-number-to-hexadecimal/
 * 问题描述：数字转换为十六进制数
 * */
public class ConvertANumberToHexadecimal {
    public String toHex(int num) {
        if(num == 0) return "0";
        StringBuffer result = new StringBuffer();
        char[] map = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
        while(num != 0){
            result.append(map[num & 0b1111]);
            num >>>= 4;
        }
        return result.reverse().toString();
    }
}
