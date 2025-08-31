package leetCode.AlgorithmIdea.DataStructure.bitOperation;
/**
 * 数据结构：位运算
 * leetcode：https://leetcode-cn.com/problems/power-of-two/
 * 题目描述：判断数是不是2的幂
 * */
public class PowerOfTwo {
    //方法一：常规法
    public boolean isPowerOfTwo(int n) {
        if(n == 1) return true;
        if(n == 0) return false;
        while(n % 2 == 0){
            n = n /2;
            if(n == 1)
                return true;
        }
        return false;
    }
    //方法二：2的幂在二进制，只有一个1
    public boolean isPowerOfTwo2(int n){
        return n > 0 && Integer.bitCount(n) == 1;
    }

    //方法三：2的幂在二进制，只有一个1
    public boolean isPowerOfTwo3(int n){
        return n > 0 && (n & (n - 1)) == 0;
    }
}
