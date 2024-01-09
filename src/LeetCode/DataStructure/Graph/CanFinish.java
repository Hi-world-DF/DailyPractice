package LeetCode.DataStructure.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 207. 课程表
 *
 * @author Ernest
 * @version 1.0, 11/3/2021
 * @since 1.0.0
 */
public class CanFinish {

    /**
     * 你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
     * 在选修某些课程之前需要一些先修课程。 判断是否可能完成所有课程的学习.+
     *
     * @param numCourses 课程数
     * @param prerequisites 先修课数组
     * @return 是否能完成所有课程的学习
     */
    /** 方法1：广度优先搜索 */
    
    List<List<Integer>> edges;
    int[] ind;
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }
        ind = new int[numCourses];
        for (int[] info : prerequisites) {
            edges.get(info[1]).add(info[0]);
            ind[info[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (ind[i] == 0) {
                queue.offer(i);
            }
        }

        int visited = 0;
        while (!queue.isEmpty()) {
            visited++;
            int e = queue.poll();
            for (int v : edges.get(e)) {
                 ind[v]--;
                 if (ind[v] == 0) {
                     queue.offer(v);
                 }
            }
        }
        return visited == numCourses;
    }
}
