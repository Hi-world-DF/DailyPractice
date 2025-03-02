package src.leetCode.everyday;

/**
 * 旋转图像：给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 *
 * @author Ernest
 * @version 1.0, 1/3/2021
 * @since 1.0.0
 */
public class Rotate {

    /**
     * 将矩阵旋转90°
     *
     * @param matrix n*n 初始数组
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        //水平翻转
        for (int i = 0; i < n/2; i++) {
            for (int j = 0; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n-i-1][j];
                matrix[n-i-1][j] = temp;
            }
        }

        //对角线翻转
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}
