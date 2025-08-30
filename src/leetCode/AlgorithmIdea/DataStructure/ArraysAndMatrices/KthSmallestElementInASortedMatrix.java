package leetCode.AlgorithmIdea.DataStructure.ArraysAndMatrices;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 数据结构：数组和矩阵
 * leetcode：https://leetcode-cn.com/problems/kth-smallest-element-in-a-sorted-matrix/
 * 题目描述：有序矩阵中第k小的元素
 * */
public class KthSmallestElementInASortedMatrix {
    /**
     * 方法一：降维处理，数组排序，输出第k-1个元素
     * */
    public int kthSmallest(int[][] matrix, int k) {
        if(matrix == null || matrix.length == 0||matrix[0].length == 0){
            return -1;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[] nums = new int[m*n];
        int l = 0;
        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                nums[l] = matrix[i][j];
                l++;
            }
        }
        Arrays.sort(nums);
        return nums[k-1];
    }
    /**
     * 方法二：二分查找
     * */
    public int kthSmallest1(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        int low = matrix[0][0];
        int high = matrix[m-1][n-1];
        while(low <= high){
            int mid = low + (high - low)/2;
            int cnt = 0;
            for(int i = 0;i < m;i++){
                for(int j = 0;j < n;j++){
                    if(matrix[i][j] <= mid){
                        cnt++;
                    }
                }
            }
            if(cnt < k){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return low;
    }
    /**
     * 方法三：利用堆求解（有点难）
     * */
    public int kthSmallest2(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        PriorityQueue<Tuple> pq = new PriorityQueue<>();
        for(int i = 0;i < n;i++){
            pq.offer(new Tuple(0,i,matrix[0][i]));
        }
        for(int j = 0;j < k-1;j++){
            Tuple t = pq.poll();
            if(t.x == m-1){
                continue;
            }
            pq.offer(new Tuple(t.x+1,t.y,matrix[t.x+1][t.y]));
        }
        return pq.poll().val;
    }
}

class Tuple implements Comparable<Tuple> {
    int x, y, val;
    public Tuple(int x, int y, int val) {
        this.x = x; this.y = y; this.val = val;
    }
    @Override
    public int compareTo(Tuple that) {
        return this.val - that.val;
    }
}
