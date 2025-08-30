package leetCode.AlgorithmIdea.DataStructure.ArraysAndMatrices;

/**
 * 566. 重塑矩阵
 *
 * @author Ernest
 * @version 1.0, 16/3/2021
 * @since 1.0.0
 */
public class MatrixReshape {

    /**
     * 在MATLAB中，有一个非常有用的函数 reshape，
     * 它可以将一个矩阵重塑为另一个大小不同的新矩阵，但保留其原始数据。
     *
     * @param nums 初始数组
     * @param r 重塑后的矩阵行
     * @param c 重塑后的矩阵列
     * @return 返回重塑后的矩阵
     */
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int[][] res = new int[r][c];
        int m = nums.length;
        int n = nums[0].length;
        if (m * n != r * c) {
            return nums;
        }
        for (int i = 0; i < m * n; i++) {
            res[i / c][i % c] = nums[i / n][i % n];
        }
        return res;
    }
}
