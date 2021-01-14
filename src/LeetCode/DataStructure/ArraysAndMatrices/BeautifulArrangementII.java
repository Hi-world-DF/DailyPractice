package DataStructure.ArraysAndMatrices;
/**
 * 数据结构：数组和矩阵
 * leetcode：https://leetcode-cn.com/problems/beautiful-arrangement-ii/
 * 题目描述：优美的排列
 * */
public class BeautifulArrangementII {
    public int[] constructArray(int n, int k) {
        int[] result = new int[n];
        result[0] = 1;
        int interval = k;
        for(int i = 1;i <= k; i++){
            result[i] = i%2 == 1?result[i-1]+interval:result[i-1]-interval;
            interval--;
        }
        for(int i = k+1;i < n;i++){
            result[i] = i+1;
        }
        return result;
    }
}
