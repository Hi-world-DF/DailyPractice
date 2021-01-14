package DataStructure.ArraysAndMatrices;
/**
 * 数据结构：数组和矩阵
 * leetcode：https://leetcode-cn.com/problems/max-chunks-to-make-sorted/
 * 题目描述： 最多能完成排序的块
 * */
public class MaxChunksToMakeSorted {
    public int maxChunksToSorted(int[] arr) {
        if(arr == null){
            return 0;
        }
        int num = 0;
        int current = arr[0];
        for(int i = 0;i < arr.length;i++){
            current = Math.max(current,arr[i]);
            if(current == i){
                num++;
            }
        }
        return num;
    }
}
