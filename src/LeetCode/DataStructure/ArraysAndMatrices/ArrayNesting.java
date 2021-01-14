package DataStructure.ArraysAndMatrices;
/**
 * 数据结构：数组和矩阵
 * leetcode：https://leetcode-cn.com/problems/array-nesting/
 * 题目描述：数组嵌套
 * */
public class ArrayNesting {
    public int arrayNesting(int[] nums) {
        int max = 0;
        for(int i =0;i < nums.length;i++){
            //用来计算可以嵌套的层数
            int current = 0;
            for(int j = i;nums[j] != -1;){
                current++;
                int tmp = nums[j];
                //用来标记嵌套（访问）过的位置
                nums[j] = -1;
                j = tmp;
            }
            //每个位置开始都有一个嵌套层数，取最大的输出
            max = Math.max(max,current);
        }
        return max;
    }
}
