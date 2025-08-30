package leetCode.everyday;

/**
 * 304.二维区域和检索-矩阵不可变
 *
 * @author Ernest
 * @version 1.0, 2/3/2021
 * @since 1.0.0
 */
public class NumMatrix {

    /** 方法1：*/
    int[][] sum;

    /**
     * 构造方法
     *
     * @param matrix 原始数组
     */
    public NumMatrix(int[][] matrix) {
        int row = matrix.length;
        if (row > 0) {
            int col = matrix[0].length;
            sum = new int[row][col+1];
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    sum[i][j+1] = sum[i][j] + matrix[i][j];
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
        int result = 0;
        for (int i = row1; i <= row2; i++) {
            result += sum[i][col2+1] - sum[i][col1];
        }
        return result;
    }

}
