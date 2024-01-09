package LeetCode.everyday;

/**
 * 304.二维区域和检索-矩阵不可变 ---解法2
 *
 * @author Ernest
 * @version 1.0, 2/3/2021
 * @since 1.0.0
 */
public class NumMatrix2 {

    /** 方法2：*/
    int[][] sums;

    /**
     * 构造方法
     *
     * @param matrix 原始数组
     */
    public NumMatrix2(int[][] matrix) {
        int row = matrix.length;
        if (row > 0) {
            int col = matrix[0].length;
            sums = new int[row+1][col+1];
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    sums[i+1][j+1] = sums[i][j+1] + sums[i+1][j] - sums[i][j] + matrix[i][j];
                }
            }
        }
    }

    /**
     * 返回两个点矩形区域的总和
     *
     * @param row1 第1个点的所在行
     * @param col1 第1个点的所在列
     * @param row2 第2个点的所在行
     * @param col2 第2个点的所在行
     * @return 返回区域总和
     */
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sums[row2+1][col2+1] - sums[row2+1][col1] - sums[row1][col2+1] + sums[row1][col1];
    }
}
