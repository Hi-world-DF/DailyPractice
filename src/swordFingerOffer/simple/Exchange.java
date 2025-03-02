package src.swordFingerOffer.simple;

/**
 * 剑指 Offer 21. 调整数组顺序使奇数位于偶数前面
 *
 * @author Ernest
 * @version 1.0, 17/3/2021
 * @since 1.0.0
 */
public class Exchange {

    /**
     * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
     * 使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
     *
     * @param nums 初始数组
     * @return 返回调整后的数组
     */
    public int[] exchange(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int i = 0, j = n - 1;
        for (int k = 0; k < n; k++) {
            if (nums[k] % 2 == 0) {
                res[j] = nums[k];
                j--;
            } else {
                res[i] = nums[k];
                i++;
            }
        }
        return res;
    }
}
