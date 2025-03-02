package src.leetCode.AlgorithmIdea.DataStructure.HashMap;

import java.util.HashMap;

/**
 * 数据结构：哈希表
 * leetcode:https://leetcode-cn.com/problems/longest-consecutive-sequence/
 * 问题描述：最长连续序列
 * */
public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for(int num : nums){
            hashMap.put(num,1);
        }
        for(int num : nums){
            forWard(hashMap,num);
        }
        return maxCount(hashMap);
    }

    private int maxCount(HashMap<Integer, Integer> hashMap) {
        int max = 0;
        for(int num : hashMap.keySet()){
            max = Math.max(max,hashMap.get(num));
        }
        return max;
    }

    private int forWard(HashMap<Integer, Integer> hashMap, int num) {
        if(!hashMap.containsKey(num)){
            return 0;
        }
        int currentValue = hashMap.get(num);
        if(currentValue > 1){
            return currentValue;
        }
        currentValue = forWard(hashMap,num+1)+1;
        hashMap.put(num,currentValue);
        return currentValue;
    }
}
