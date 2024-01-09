package LeetCode.DataStructure.HashMap;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 数据结构：哈希表
 * leetcode:https://leetcode-cn.com/problems/contains-duplicate/
 * 问题描述：判断是否存在重复元素
 *
 * @author laomao
 * */
public class ContainsDuplicate {
    //方法一：HashMap
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for(int i = 0;i < nums.length;i++){
            if(hashMap.containsKey(nums[i])){
                return true;
            }else{
                hashMap.put(nums[i],i);
            }
        }
        return false;
    }
    //方法二：HashSet
    public boolean containsDuplicate2(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        for(int num : nums){
            hashSet.add(num);
        }
        if(hashSet.size() < nums.length){
            return true;
        }else{
            return false;
        }
    }

}
