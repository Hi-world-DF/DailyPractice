package LeetCode.AlgorithmIdea.greedyAlgorithm;

/**
 * 翻转矩阵后的得分:有一个二维矩阵 A 其中每个元素的值为 0 或 1 。
 * 移动是指选择任一行或列，并转换该行或列中的每一个值：将所有 0 都更改为 1，将所有 1 都更改为 0。
 * 在做出任意次数的移动后，将该矩阵的每一行都按照二进制数来解释，矩阵的得分就是这些数字的总和。返回最大得分
 *
 * @author Ernest
 * @version 1.0, 22/2/2021
 * @since 1.0.0
 */
public class MatrixScore {

    /**
     * 返回翻转数组得到的最大得分
     *
     * @param A 0/1数组
     * @return 得分
     */
    public int matrixScore(int[][] A) {
        int row = A.length;
        int col = A[0].length;
        for (int i = 0; i < row; i++) {
            if (A[i][0] != 1) {
                for (int j = 0; j < col; j++) {
                    A[i][j] = (A[i][j] + 1) % 2;
                }
            }
        }
        for (int i = 1; i < col; i++) {
            int zero = 0;
            int one = 0;
            for (int j = 0; j < row; j++) {
                if(A[j][i] == 1) {
                    one++;
                } else {
                    zero++;
                }
            }
            if(zero > one) {
                for (int j = 0; j < row; j++) {
                    A[j][i] = (A[j][i] + 1) % 2;
                }
            }
        }
        int result = 0;
        for (int i = 0; i < row; i++) {
            int sum = 0;
            for (int j = 0; j < col; j++) {
                sum = sum << 1 + A[i][j];
            }
            result += sum;
        }
        return result;
    }
}
