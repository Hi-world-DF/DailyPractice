package leetCode.AlgorithmIdea.DataStructure.bitOperation;
/**
 * 数据结构：位运算
 * leetcode：https://leetcode-cn.com/problems/single-number/
 * 题目描述：数组中唯一的单一元素
 * */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        int result = 0;
        for(int n : nums){
            result = n ^ result;
        }
        return result;
    }
}
