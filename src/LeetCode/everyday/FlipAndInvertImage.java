package everyday;

/**
 * 翻转二维数组：先水平翻转然后全部反转
 *
 * @author Ernest
 * @version 1.0, 24/2/2021
 * @since 1.0.0
 */
public class FlipAndInvertImage {

    /**
     * 翻转二维数组
     *
     * @param A 二维数组，由0/1组成
     * @return 返变化后的二维数组
     */
    public int[][] flipAndInvertImage(int[][] A) {
        int row = A.length;
        int col = A[0].length;
        for (int i = 0; i < row; i++) {
            int mid = col / 2;
            for (int j = 0; j < mid; j++) {
                int temp = (A[i][j] + 1) % 2;
                A[i][j] = (A[i][col - j - 1] + 1) % 2;
                A[i][col - j - 1] = temp;
            }
            if (mid * 2 < col) {
                A[i][mid + 1] = (A[i][mid + 1] + 1) % 2;
            }
        }
        return A;
    }
}
