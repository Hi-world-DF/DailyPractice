package LeetCode.everyday;

/**
 * 求矩阵的转置
 *
 * @author Ernest
 * @version 1.0, 25/2/2021
 * @since 1.0.0
 */
public class Transpose {

    /**
     * 矩阵的 转置 是指将矩阵的主对角线翻转，交换矩阵的行索引与列索引。
     *
     * @param matrix 二维矩阵
     * @return 返回转置后的矩阵
     */
    public int[][] transpose(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] result = new int[col][row];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                result[j][i] = matrix[i][j];
            }
        }
        return result;
    }
}
