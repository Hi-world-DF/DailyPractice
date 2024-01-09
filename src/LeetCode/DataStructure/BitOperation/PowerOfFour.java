package LeetCode.DataStructure.BitOperation;
/**
 * 数据结构：位运算
 * leetcode：https://leetcode-cn.com/problems/power-of-four/
 * 题目描述：判断数是不是4的幂
 * */
public class PowerOfFour {
    //方法1：普通方法
    public boolean isPowerOfFour(int num) {
        if(num == 1) return true;
        while(num> 1 && num % 4 == 0){
            num /=4;
            if(num == 1) return true;
        }
        return false;
    }
    //方法2：位运算-->4的n次方是只有一个奇数位为1，num为32位有符号整数
    public boolean isPowerOfFour2(int num){
        return num > 0 && (num & (num - 1)) == 0 && (num & 0b01010101010101010101010101010101) != 0;
    }

    //方法3：正则表达式
    public boolean isPowerOfFour3(int num){
        return Integer.toString(num, 4).matches("10*");
    }

}
