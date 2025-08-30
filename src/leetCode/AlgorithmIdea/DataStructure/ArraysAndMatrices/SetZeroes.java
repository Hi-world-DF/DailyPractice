package leetCode.AlgorithmIdea.DataStructure.ArraysAndMatrices;

/**
 * 73. 矩阵置零
 *
 * @author Ernest
 * @version 1.0, 21/3/2021
 * @since 1.0.0
 */
public class SetZeroes {
    /**
     * 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。
     * 请使用 原地 算法。
     *
     * @param matrix 初始矩阵
     */
    public void setZeroes(int[][] matrix) {

        int n = matrix.length;
        int m = matrix[0].length;

        boolean[] row = new boolean[n];
        boolean[] col = new boolean[m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = col[j] = true;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (row[i] || col[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
