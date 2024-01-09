package swordFingerOffer.midDifficulty;

/**
 * 剑指 Offer 04. 二维数组中的查找
 *
 * @author Ernest
 * @version 1.0, 15/4/2021
 * @since 1.0.0
 */
public class FindNumberIn2DArray {

    /**
     * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
     * 请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
     *
     * @param matrix 二维数组
     * @param target 目标数
     * @return 返回目标数是否存在
     */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int n = matrix.length;
        int m = matrix[0].length;
        if (target > matrix[n-1][m-1] || target < matrix[0][0]) {
            return false;
        }
        int row = 0, col = m - 1;
        while (row < col && col >= 0) {
            int cur = matrix[row][col];
            if (cur == target) {
                return true;
            } else if (cur > target) {
                col--;
            } else {
                row++;
            }
        }
        return false;
    }
}
