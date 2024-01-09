package LeetCode.everyday;

/**
 * 单调数组题
 *
 * @author Ernest
 * @version 1.0, 28/2/2021
 * @since 1.0.0
 */
public class Monotonic {

    /**
     * 判断是否为单调数组：单调递增|递减
     *
     * @param
     * @return
     */
    public boolean isMonotonic(int[] A) {
        return monotonous(A, true) || monotonous(A, false);
    }

    private boolean monotonous(int[] A, boolean isUp) {
        int len = A.length;
        if (isUp) {
            for (int i = 0; i < len; i++) {
                if (A[i] > A[i+1]) {
                    return false;
                }
            }
        } else {
            for (int i = 0; i < len; i++) {
                if (A[i] < A[i+1]) {
                    return false;
                }
            }
        }
        return true;
    }
}
