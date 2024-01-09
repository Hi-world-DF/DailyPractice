package LeetCode.DataStructure.ArraysAndMatrices;
/**
 * 数据结构：数组和矩阵
 * leetcode：https://leetcode-cn.com/problems/reshape-the-matrix/
 * 题目描述：重塑矩阵
 * */
public class ReshapeTheMatrix {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int[][] result = new int[r][c];
        int m = nums.length;
        int n = nums[0].length;
        int[] num = new int[m*n];
        for(int i = 0,x=0;i < m;i++){
            for(int j = 0;j < n;j++){
                num[x] = nums[i][j];
                x++;
            }
        }
        for(int i = 0; i < num.length;i++){
            System.out.print(num[i]+" ");
        }
        System.out.println();
        if(m*n < r*c){
            return nums;
        }
        for(int i = 0,y=0;i < r;i++){
            for(int j = 0;j < c;j++){
                result[i][j] = num[y];
                y++;
            }
        }
        return result;
    }
}
