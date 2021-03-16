package everyday;

import java.util.ArrayList;
import java.util.List;

/**
 * 54. 螺旋矩阵
 *
 * @author Ernest
 * @version 1.0, 15/3/2021
 * @since 1.0.0
 */
public class SpiralOrder {

    /**
     * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素
     *
     * @param
     * @return
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        List<Integer> resList = new ArrayList<>();
        boolean[][] isVisited = new boolean[n][m];
        int[][] directions = {{0, 1},{1, 0},{0, -1},{-1, 0}};
        int i = 0, j = 0, total = 0;
        int nowDireIndex = 0;
        while (total < n * m ) {
            resList.add(matrix[i][j]);
            isVisited[i][j] = true;
            total++;
            int nextRow = i + directions[nowDireIndex][0];
            int nextCol = j + directions[nowDireIndex][1];
            if (nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= m || isVisited[nextRow][nextCol]) {
                //变方向
                nowDireIndex = (nowDireIndex + 1) % 4;
            }
            i += directions[nowDireIndex][0];
            j += directions[nowDireIndex][1];
        }
        return resList;
    }
}
