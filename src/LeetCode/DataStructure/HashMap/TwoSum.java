package LeetCode.DataStructure.HashMap;

import java.util.HashMap;

/**
 * 数据结构：哈希表
 * leetcode:https://leetcode-cn.com/problems/two-sum/
 * 问题描述：两数之和
 *
 * @author laomao*/
public class TwoSum {

    /** 方法一：暴力法 */
    public int[] twoSum2(int[] nums, int target) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
   }

    /** 方法二：hash表 */
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for(int i = 0;i < nums.length;i++){
            if(hashMap.containsKey(target - nums[i])){
                return new int[]{hashMap.get(target - nums[i]),i};
            }else{
                hashMap.put(nums[i],i);
            }
        }
        return null;
    }
}
