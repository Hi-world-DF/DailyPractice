package src.leetCode.AlgorithmIdea.greedyAlgorithm;
/**
 * 贪心算法
 * leetcode:https://leetcode-cn.com/problems/maximum-subarray/description/
 * 子数组最大和
 * */
public class MaximumSubarray {
    public int maximumSubarray(int[] nums){
        int n = nums.length;
        if(n == 0 || nums ==null){
            return 0;
        }
        int preIndex = nums[0];
        int maxSum = preIndex;
        for(int i = 1;i < n;i++){
            preIndex = preIndex>0?preIndex+nums[i]:nums[i];
            maxSum = maxSum > preIndex?maxSum:preIndex;
        }
        return maxSum;
    }
    /**
     * 测试
     * */
    public static void main(String[] args){
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        MaximumSubarray m = new MaximumSubarray();
        int result = m.maximumSubarray(nums);
        System.out.println(result);
    }
}
