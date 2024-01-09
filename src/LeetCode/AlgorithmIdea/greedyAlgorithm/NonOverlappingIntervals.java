package LeetCode.AlgorithmIdea.greedyAlgorithm;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 贪心算法
 * leetcode:https://leetcode-cn.com/problems/non-overlapping-intervals/description/
 * 不重叠的区间个数
 * */

public class NonOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        //二维数组，通过比较下标来判定下一个是否重叠
        if(intervals.length == 0){
            return 0;
        }
        //根据列排序
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));
        int dnum = 0;
        int end = intervals[0][1];
        for(int i = 1;i < intervals.length;i++){
            if(end <= intervals[i][0]){
                end = intervals[i][1];
                continue;
            }
            dnum++;
        }
        return dnum;
    }

    public static void main(String[] args){
        NonOverlappingIntervals noi = new NonOverlappingIntervals();
        int[][] intervals = {{1,2},{3,4},{2,6},{5,7},{7,9},{8,9}};
        int num = noi.eraseOverlapIntervals(intervals);
        System.out.println("需要移除区间个数："+num);
    }

}
