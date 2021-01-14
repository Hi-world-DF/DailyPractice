package AlgorithmIdea.math;


import java.util.Arrays;

/**
 * 数学问题
 * leetcode:https://leetcode-cn.com/problems/majority-element/
 * 问题描述：多数元素
 * */
public class MajorityElement {
    //方法1：先排序，中间元素肯定是多数元素
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int l = nums.length;
        return nums[l/2];
    }
    //方法2：先排序，中间元素肯定是多数元素
    public int majorityElement1(int[] nums) {
        int cnt = 0;
        int majority = nums[0];
        for(int num : nums){
            majority = (cnt == 0)?num : majority;
            cnt = (majority == num)? cnt +1 : cnt -1;
        }
        return majority;
    }
}
