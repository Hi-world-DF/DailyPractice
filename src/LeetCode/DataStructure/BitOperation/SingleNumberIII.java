package DataStructure.BitOperation;

import java.util.HashMap;

/**
 * 数据结构：位运算
 * leetcode：https://leetcode-cn.com/problems/single-number-iii/
 * 题目描述：数组中唯一的单一元素
 * */
public class SingleNumberIII {
    //方法1：利用hashMap
    public int[] singleNumber(int[] nums) {
        HashMap<Integer,Integer> hashMap = new HashMap();
        for(int n : nums){
            hashMap.put(n,hashMap.getOrDefault(n,0)+1);
        }
        int[] result = new int[2];
        int index = 0;
//        for(HashMap.Entry<Integer,Integer> item : hashMap.entrySet()){
//            if(item.getValue() == 1) {
//                result[index] = item.getKey();
//                index++;
//            }
//        }
        for(int n : hashMap.keySet()){
            if(hashMap.get(n) == 1){
                result[index] = n;
                index ++;
            }
        }
        return result;
    }

    //方法2：位运算
    public int[] singleNumber2(int[] nums) {
        int two = 0;
        for(int n : nums){
            two = two ^ n;
        }
        two = two & (-two);
        int[] result = new int[2];
        for (int n:nums) {
            if((n & two) == 0) {
                result[0] = result[0]^n;
            }else {
                result[1] = result[1]^n;
            }
        }
        return result;
    }
}
