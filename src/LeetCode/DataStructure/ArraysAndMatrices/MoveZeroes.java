package LeetCode.DataStructure.ArraysAndMatrices;
/**
 * 数据结构：数组和矩阵
 * leetcode：https://leetcode-cn.com/problems/move-zeroes/
 * 题目描述：移动零到数组末尾
 * */

public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int notZero = 0;
        for(int i = 0; i < n;i++){
            if(nums[i] != 0){
                nums[notZero] = nums[i];
                notZero++;
            }
        }
        while(notZero < n){
            nums[notZero] = 0;
            notZero++;
        }
    }
}
