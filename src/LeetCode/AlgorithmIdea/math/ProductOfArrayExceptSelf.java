package LeetCode.AlgorithmIdea.math;

import java.util.Arrays;

/**
 * 数学问题
 * leetcode:https://leetcode-cn.com/problems/product-of-array-except-self/
 * 问题描述： 除自身以外数组的乘积
 * */
public class ProductOfArrayExceptSelf {
    //不能用除法
    public int[] productExceptSelf(int[] nums) {
        //只能该数左边的数相乘再乘以右边的数相乘
        int l = nums.length;
        int[] result = new int[l];
        Arrays.fill(result,1);
        int left = 1;
        for (int i = 1; i < l; i++) {
            left *= nums[i-1];
            result[i] *=left;
        }
        int right = 1;
        for (int j = l-2; j >=0 ; j--) {
            right *= nums[j+1];
            result[j] *= right;
        }
        return result;
    }
}
