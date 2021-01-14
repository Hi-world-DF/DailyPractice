package DataStructure.ArraysAndMatrices;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 数据结构：数组和矩阵
 * leetcode：https://leetcode-cn.com/problems/set-mismatch/
 * 题目描述：错误的集合
 * */
public class SetMismatch {
    /**
     * 方法一：对数组排序
     * */
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        //结果数组只有两个元素：一个是数组中重复的那个元素，一个是缺少的那个元素
        int[] result = new int[2];
        //对数组排序
        Arrays.sort(nums);
        for(int i = 0;i < n;i++){
            if(i+1 < n && nums[i] == nums[i+1]){
                //排序后前后相同的元素就是重复的元素
                result[0] = nums[i];
            }
            if(i+1< n && nums[i+1] - nums[i] == 2){
                //排序后当前后两个元素相差为2，那么中间的元素即为缺失元素
                result[1] = nums[i]+1;
            }
        }
        //但要考虑缺失第一个元素1或者最后一个元素n
        if(result[1] == 0){
            if(nums[0] != 1){
                result[1] = 1;
            }else{
                result[1] = n-1;
            }
        }
        return result;
    }
    /**
     * 方法二：对数组元素进行交换，使元素在对应的位置
     * */
    public int[] findErrorNums1(int[] nums) {
        int n = nums.length;
        for(int i = 0;i < n;i++){
            while(nums[i] != i+1 && nums[nums[i]-1] != nums[i]){
                int temp = nums[i];
                nums[i] = nums[nums[i] -1];
                nums[nums[i]-1] = temp;
            }
        }
        for(int i = 0;i < n;i++){
            if(nums[i] != i+1){
                return new int[]{nums[i],i+1};
            }
        }
        return null;
    }

    public static void main(String[] args){
        int[] a = {3,2,3,4,6,5};
        SetMismatch setMismatch = new SetMismatch();
        int[] result = setMismatch.findErrorNums(a);
        System.out.println(result[0]+" "+result[1]);
    }

}
