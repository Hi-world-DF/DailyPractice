package src.leetCode.AlgorithmIdea.searchAlgorithm.BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 搜索算法：BFS（广度优先搜索）
 * leetcode:https://leetcode-cn.com/problems/perfect-squares/
 * 组成整数的最小平方数数量
 * */
public class PerfectSquares {
    public int numSquares(int n) {
        List<Integer> squares = generateSquares(n);
        Queue<Integer> queue = new LinkedList<>();
        boolean[] marked = new boolean[n+1];
        queue.add(n);
        marked[n] = true;
        int level = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            level++;
            while(size > 0){
                int current = queue.poll();
                for(int s : squares){
                    int next = current - s;
                    if(next < 0){
                        break;
                    }
                    if(next == 0){
                        return level;
                    }
                    if(marked[next]){
                        continue;
                    }
                    marked[next] = true;
                    queue.add(next);
                }
            }
        }
        return n;
    }
    /**
     * 生成小于n的平方数序列
     *
     * */
    private List<Integer> generateSquares(int n) {
        List<Integer> squares = new ArrayList<>();
        int square = 1;
        int diff = 3;
        while(square <= n){
            squares.add(square);
            square += diff;
            diff += 2;
        }
        return squares;
    }
}
