package src.leetCode.AlgorithmIdea.doublePointer;

/**
 * 双指针问题
 * leetcode:https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/
 * 两数相加问题
 * */

public class AddTwoNumbers {
    public static int[] twoSum(int[] numbers, int target) {
        if(numbers == null){
            return null;
        }
        //定义两个指针，一个指向数组第一个元素，一个指向数组最后一个元素
        int i = 0;
        int j = numbers.length -1;
        while(i<j){
            int sum = numbers[i] + numbers[j];
            if(sum == target){
                return new int[]{i+1,j+1};
            }else if(sum < target){
                i++;
            }else{
                j--;
            }
        }
        return null;
    }
    /**
     * 测试
     * */
    public static void main(String[] args){
        int[] numbers = {2,7,11,15};
        int target = 9;
        int[] result = twoSum(numbers,target);
        for (int i = 0;i < result.length;i++){
            System.out.print(result[i]+" ");
        }
    }

}
