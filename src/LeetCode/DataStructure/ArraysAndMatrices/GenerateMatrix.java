package DataStructure.ArraysAndMatrices;
import org.junit.Test;

/**
 * 59. 螺旋矩阵 II
 *
 * @author Ernest
 * @version 1.0, 16/3/2021
 * @since 1.0.0
 */
public class GenerateMatrix {
    /**
     * 给你一个正整数 n ，生成一个包含 1 到 n*n 所有元素，
     * 且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
     *
     * @param n 表示数组为n的二维数组
     * @return 返回生成的数组
     */
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int[][] direction = {{0,1}, {1,0}, {0,-1}, {-1,0}};
        int nowDireIndex = 0;
        int count = 1;
        int row = 0, col = 0;
        while (count <= n * n) {
            res[row][col] = count;
            count++;
            int nextRow = row + direction[nowDireIndex][0];
            int nextCol = col + direction[nowDireIndex][1];
            if (nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= n || (res[nextRow][nextCol] != 0 && res[nextRow][nextCol]< count)) {
                nowDireIndex = (nowDireIndex + 1) % 4;
            }
            row += direction[nowDireIndex][0];
            col += direction[nowDireIndex][1];
        }
        return res;
    }

    @Test
    public static void main(String[] args) {
        GenerateMatrix g = new GenerateMatrix();
        int[][] res = g.generateMatrix(3);
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res.length; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    }
}
