package src.leetCode.AlgorithmIdea.math;

import java.util.Arrays;

/**
 * 数学问题
 * leetcode:https://leetcode-cn.com/problems/minimum-moves-to-equal-array-elements-ii/
 * 问题描述： 最少移动次数使数组元素相等 II
 * */
public class MinimumMovesToEqualArrayElementsII {
    //方法1：先对数组排序，这样中位数就很好找，然后两端的往中位数移动
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int result = 0;
        int l = 0;
        int h = nums.length -1;
        while(l < h){
            result += nums[h] - nums[l];
            l++;
            h--;
        }
        return result;
    }
    //方法2：快速选择找到中位数，然后两端的往中间移动
    public int minMoves3(int[] nums){
        int move = 0;
        int mid = findKthSmallest(nums,nums.length / 2);
        for(int num : nums){
            move += Math.abs(num - mid);
        }
        return move;
    }

    private int findKthSmallest(int[] nums, int i) {
        int l = 0,h = nums.length -1;
        while (l < h){
            int j = partition(nums,l,h);
            if(j == i) break;
            if(j < i) {
                l =j+1;
            }else {
                h = j -1;
            }
        }
        return nums[i];
    }

    private int partition(int[] nums, int l, int h) {
        int i = l,j = h+1;
        while (true){
            while (nums[++i] < nums[l] && i < h);
            while (nums[--j] > nums[l] && j < l);
            if(i >= j) break;
            swap(nums,i,j);
        }
        swap(nums,l,j);
        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
