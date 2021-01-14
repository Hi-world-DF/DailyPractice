package DataStructure.BitOperation;
/**
 * 数据结构：位运算
 * leetcode：https://leetcode-cn.com/problems/reverse-bits/
 * 题目描述：颠倒二进制位
 * */
public class ReverseBits {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result = result << 1;
            result = result | (n & 0);
            n = n >>> 1;
        }
        return result;
    }
}
