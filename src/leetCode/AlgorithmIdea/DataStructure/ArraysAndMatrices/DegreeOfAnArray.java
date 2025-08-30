package leetCode.AlgorithmIdea.DataStructure.ArraysAndMatrices;

import java.util.HashMap;
import java.util.Map;

/**
 * 数据结构：数组和矩阵
 * leetcode：https://leetcode-cn.com/problems/degree-of-an-array/
 * 题目描述：数组的度
 * */
public class DegreeOfAnArray {
    public int findShortestSubArray(int[] nums) {
        /**current用来找nums的度及对应的数字;
         * lastIndex用来记录数字最后出现的位置;
         * firstIndex用来记录数字最后出现的位置
         */
        Map<Integer,Integer> current = new HashMap<>();
        Map<Integer,Integer> lastIndex = new HashMap<>();
        Map<Integer,Integer> firstIndex = new HashMap<>();
        for(int i = 0;i < nums.length;i++){
            //如果map中没有nums[i]的key，则nums[i]的value设为0+1;否则就是它的value+1;
            current.put(nums[i],current.getOrDefault(nums[i],0)+1);
            lastIndex.put(nums[i],i);
            if(!firstIndex.containsKey(nums[i])){
                firstIndex.put(nums[i],i);
            }
        }
        /**
         * 现在：
         * current放了所有num的key和value;key是数字，value是;
         * lastIndex用来记录数字最后出现的位置;
         * firstIndex用来记录数字第一次出现的位置
         */
        int maxDu = 0;
        for(int num : nums){
            maxDu = maxDu >= current.get(num)?maxDu:current.get(num);
        }
        int resultL = nums.length;
        for(int i = 0;i < nums.length; i++){
            int num = nums[i];
            int currentNum = current.get(num);
            if(currentNum != maxDu){
                continue;
            }
            resultL = Math.min(resultL,lastIndex.get(num) - firstIndex.get(num)+1);
        }
        return resultL;
    }
    public static void main(String[] args){
        DegreeOfAnArray degreeOfAnArray = new DegreeOfAnArray();
        int[] a = {2,1,2,2,4,4,5,1};
        int result = degreeOfAnArray.findShortestSubArray(a);
        System.out.println(result);
    }
}
