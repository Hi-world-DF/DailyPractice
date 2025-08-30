package leetCode.AlgorithmIdea.greedyAlgorithm;

import java.util.Arrays;

/**
 * 贪心算法
 * leetcode:https://leetcode-cn.com/problems/assign-cookies/
 * 饼干分配问题
 */
public class AssignCookies {
    public int findContentChildren(int[] g, int[] s) {
        if (g == null || s == null) {
            return 0;
        }
        Arrays.sort(g);
        Arrays.sort(s);
        int gi = 0, si = 0;
        while (gi < g.length && si < s.length) {
            if (s[si] >= g[gi]) {
                gi++;
                si++;
            } else {
                si++;
            }
        }
        return gi;
    }

    /**
     * 测试
     */
    public static void main(String[] args) {
        int[] g = {1, 2, 4};
        int[] s = {1, 1, 2, 1, 3};
        AssignCookies ac = new AssignCookies();
        int a = ac.findContentChildren(g, s);
        System.out.println("可以满足的孩子个数：" + a);
    }
}
