package LeetCode.DataStructure.String;

import java.util.HashMap;
/**
 * 数据结构：字符串
 * leetcode：https://leetcode-cn.com/problems/longest-palindrome/
 * 可以构成的最长的回文串
 * */
public class LongestPalindrome {
    //方法一：使用HashMap
    public int longestPalindrome(String s) {
        int result = 0;
        HashMap<Character,Integer> hashMap = new HashMap<>();
        for(char c : s.toCharArray()){
            char key = c;
            int value = 1;
            if(hashMap.get(key)!= null){
                value = hashMap.get(key) + 1;
            }
            hashMap.put(key,value);
        }
        for(char key : hashMap.keySet()){
            int value = hashMap.get(key);
            result = result + 2*(value/2);
        }
        if(result < s.length()){
            result++;
        }
        return result;
    }
    //方法二：利用数组来统计
    public int longestPalindrome1(String s) {
        int[] nums = new int[256];
        int result = 0;
        for(char c : s.toCharArray()){
            nums[c]++;
        }
        for(int num : nums){
            result += 2*(num/2);
        }
        if(result < s.length()){
            result = result + 1;
        }
        return result;
    }
}
