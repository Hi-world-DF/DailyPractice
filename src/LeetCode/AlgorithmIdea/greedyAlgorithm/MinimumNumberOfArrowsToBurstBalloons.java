package LeetCode.AlgorithmIdea.greedyAlgorithm;

import java.util.Arrays;
import java.util.Comparator;
/**
 * 贪心算法
 * leetcode:https://leetcode-cn.com/problems/minimum-number-of-arrows-to-burst-balloons/description/
 * 用最少的箭击破所有气球
 * */
public class MinimumNumberOfArrowsToBurstBalloons {
    public int findMinArrowShots(int[][] points) {
        if(points.length == 0){
            return 0;
        }
        Arrays.sort(points, Comparator.comparingInt(o -> o[1]));
        int sum = 1;
        int b = points[0][1];
        for(int i = 1 ;i < points.length;i++){
            int pre = points[i][0];
            if(pre <= b){
                continue;
            }else{
                b = points[i][1];
                sum++;
            }
        }
        return sum;
    }

    public static void main(String[] args){
        MinimumNumberOfArrowsToBurstBalloons mnoatbb =new MinimumNumberOfArrowsToBurstBalloons();
        int[][] points = {{2,3},{1,5},{4,7},{8,9}};
        int num = mnoatbb.findMinArrowShots(points);
        System.out.println("最少需要 "+num+" 支箭");
    }
}
