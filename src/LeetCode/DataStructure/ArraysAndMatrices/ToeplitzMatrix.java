package LeetCode.DataStructure.ArraysAndMatrices;
/**
 * 数据结构：数组和矩阵
 * leetcode：https://leetcode-cn.com/problems/toeplitz-matrix/
 * 题目描述：托普利茨矩阵(对角元素相等的矩阵)
 * */
public class ToeplitzMatrix {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        for(int i = 0;i < m;i++){
            if(!check(matrix,matrix[i][0],i,0)){
                return false;
            }
        }
        for(int j = 0;j < n;j++){
            if(!check(matrix,matrix[0][j],0,j)){
                return false;
            }
        }
        return true;
    }

    private boolean check(int[][] matrix, int value, int row, int col) {
        int m = matrix.length;
        int n = matrix[0].length;
        if(row >= m || col >= n){
            return true;
        }
        if(matrix[row][col] != value){
            return false;
        }
        return check(matrix, value, row+1, col+1);
    }
}
