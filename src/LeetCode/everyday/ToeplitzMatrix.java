package LeetCode.everyday;

/**
 * 托普利茨矩阵：如果矩阵上每一条由左上到右下的对角线上的元素都相同，那么这个矩阵是托普利茨矩阵 。
 *
 * @author Ernest
 * @version 1.0, 22/2/2021
 * @since 1.0.0
 */
public class ToeplitzMatrix {

    /**
     * 判断矩阵是否是托普利茨矩阵
     *
     * @param matrix 二维矩阵
     * @return true|false
     */
    public boolean isToeplitzMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        if (row <= 1 || col <= 1) {
            return true;
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (matrix[i][j] != matrix[i - 1][j - 1]) {
                    return false;
                }
            }
        }
        return true;
    }
}
