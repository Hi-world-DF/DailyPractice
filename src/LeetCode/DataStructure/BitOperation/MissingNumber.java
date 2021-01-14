package DataStructure.BitOperation;
/**
 * 数据结构：位运算
 * leetcode：https://leetcode-cn.com/problems/missing-number/
 * 题目描述：数组中缺失的那个数
 * */
public class MissingNumber {
    //方法1：利用等差数列求缺失的值
    public int missingNumber(int[] nums) {
        int sum = 0;
        int l = nums.length;
        for (int i = 0; i < l; i++) {
            sum += nums[i];
        }
        return l*(l+1)/2 - sum;
    }

    //方法2：利用位运算---> a ^ b ^ a = b 下标+长度 和 原数组 异或
    /**eg: [4,5,3,2,1,0,7,8]
     * ->  4^0 ^ 5^1 ^ 3^2 ^ 2^3 ^ 1^4 ^ 0^5 ^ 7^6 ^ 8^7 ^ 8
     * ->  0^0 ^ 1^1 ^ 2^2 ^ 3^3 ^ 4^4 ^ 5^5 ^ 7^7 ^ 8^8 ^ 6
     * ->  0 ^ 0 ^ 0 ^ 0 ^ 0 ^ 0 ^ 0 ^ 0 ^ 6
     * ->  6
     * */
    public int missingNumber2(int[] nums){
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result = result ^ i ^ nums[i];
        }
        return result ^ nums.length;
    }
}
