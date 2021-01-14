package AlgorithmIdea.dynamicProgramming.arrayInterval;
/**
 * 动态规划：数组区间
 * leetcode:https://leetcode-cn.com/problems/range-sum-query-immutable/
 * 问题描述： 区域和检索 - 数组不可变
 * */
public class RangeSumQueryImmutable {
    private int[] sum;
    public RangeSumQueryImmutable(int[] nums) {
        sum = new int[nums.length+1];
        sum[0] = nums[0];
        for (int i = 1; i < sum.length ; i++) {
            sum[i] = sum[i-1] + nums[i];
        }
        sum[0] = 0;
    }

    public int sumRange(int i, int j) {
        return sum[j] - sum[i];
    }

    public static void main(String[] args) {
        int[] num = {-2,0,3,-5,2,-1};
        RangeSumQueryImmutable rangeSumQueryImmutable = new RangeSumQueryImmutable(num);
        int a = rangeSumQueryImmutable.sumRange(2,5);
        System.out.println(a);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
