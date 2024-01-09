package LeetCode.DataStructure.BitOperation;

/**
 * 数据结构：位运算
 * leetcode：https://leetcode-cn.com/problems/number-complement/
 * 题目描述：数字的补码
 * */

public class NumberComplement {
    public int findComplement(int num) {
        if (num == 0) return 1;
        int mask = 1 << 30;
        while ((num & mask) == 0) mask >>= 1;
        mask = (mask << 1) - 1;
        return num ^ mask;
    }
}
