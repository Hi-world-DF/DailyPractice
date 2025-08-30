package leetCode.AlgorithmIdea.DataStructure.ArraysAndMatrices;

import java.util.Arrays;

/**
 * 数据结构：数组和矩阵
 * leetcode：https://leetcode-cn.com/problems/find-the-duplicate-number/
 * 题目描述：寻找重复的数
 * */
public class FindTheDuplicateNumber {
    //方法一：排序
    public int findDuplicate(int[] nums) {
        if(nums == null || nums.length==0){
            return -1;
        }
        int n = nums.length;
        Arrays.sort(nums);
        for(int i = 0;i < n;i++){
            if(i+1 < n && nums[i+1]==nums[i]){
                return nums[i];
            }
        }
        return -1;
    }
    //方法二：二分查找
    public int findDuplicate1(int[] nums) {
        int low = 1;
        int high = nums.length -1;
        while(low < high){
            int mid = low +(high - low)/2;
            int n = 0;
            for(int i = 0;i<nums.length;i++){
                if(nums[i] <= mid){
                    n++;
                }
            }
            if(mid < n){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return low;
    }
    //方法三：双指针
    public int findDuplicate2(int[] nums) {
        int slow = nums[0];
        int fast = nums[nums[0]];
        while(slow != fast){
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        fast = 0;
        while(slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
