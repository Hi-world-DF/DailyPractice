package leetCode.everyday;

/**
 * 303.区域和检索 - 数组不可变
 *
 * @author Ernest
 * @version 1.0, 1/3/2021
 * @since 1.0.0
 */
public class NumArray {

    int[] sums;

    /**
     * 构造函数：初始构造一个sum数组，这个数组的每个元素表示nums前i个元素的和
     *
     * @param nums 整数数组
     */
    public NumArray(int[] nums) {
        int len = nums.length;
        sums = new int[len + 1];
        for (int i = 0; i < len; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }
    }

    /**
     * 返回范围间的元素值总和
     *
     * @param i 前下标
     * @param j 后下标
     * @return 返回差值
     */
    public int sumRange(int i, int j) {
        return sums[j + 1] - sums[i];
    }
}
