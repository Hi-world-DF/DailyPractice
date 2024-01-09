package LeetCode.AlgorithmIdea.greedyAlgorithm;

import java.util.*;

/**
 * 贪心算法
 * leetcode:https://leetcode-cn.com/problems/queue-reconstruction-by-height/
 * 根据身高重新排序
 * */
public class ReconstructionByHeight {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]==o2[0]?o1[1] - o2[1]:o2[0] - o1[0];
            }
        });

        List<int[]> result =new ArrayList<>();
        for(int[] p : people) {
            result.add(p[1], p);
        }
        int num = people.length;
        return result.toArray(new int[num][2]);
    }
    public static void main(String[] args){
        ReconstructionByHeight rbh = new ReconstructionByHeight();
        int[][] p ={{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
        System.out.println("input:");
        for(int[] a : p){
            System.out.print(Arrays.toString(a)+" ");
        }
        int[][] a =rbh.reconstructQueue(p);
        System.out.println("\noutput:");
        for(int[] b : a){
            System.out.print(Arrays.toString(b)+" ");
        }
    }
}
