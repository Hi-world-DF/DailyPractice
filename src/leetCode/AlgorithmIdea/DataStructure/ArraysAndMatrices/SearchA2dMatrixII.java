package leetCode.AlgorithmIdea.DataStructure.ArraysAndMatrices;
/**
 * 数据结构：数组和矩阵
 * leetcode：https://leetcode-cn.com/problems/search-a-2d-matrix-ii/
 * 题目描述：搜索二维矩阵
 * */
public class SearchA2dMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int row = 0;
        int column = n-1;
        while(row < m && column >= 0){
            if(matrix[row][column] == target){
                return true;
            }else if(matrix[row][column] > target){
                column--;
            }else{
                row++;
            }
        }
        return false;
    }
}
