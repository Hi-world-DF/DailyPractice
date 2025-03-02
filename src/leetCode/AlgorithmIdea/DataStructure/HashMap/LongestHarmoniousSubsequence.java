package src.leetCode.AlgorithmIdea.DataStructure.HashMap;

import java.util.HashMap;

/**
 * 数据结构：哈希表
 * leetcode:https://leetcode-cn.com/problems/longest-harmonious-subsequence/
 * 问题描述：最长和谐子序列
 * */
public class LongestHarmoniousSubsequence {
    public int findLHS(int[] nums) {
        int max = 0;
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for(int i = 0;i < nums.length;i++){
            hashMap.put(nums[i],hashMap.getOrDefault(nums[i], 0) + 1);
        }
        for(int num : hashMap.keySet()){
            if(hashMap.containsKey(num+1)){
                int sum = hashMap.get(num) + hashMap.get(num+1);
                max = Math.max(max,sum);
            }
        }
        return max;
    }
}
