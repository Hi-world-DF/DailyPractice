package leetCode.AlgorithmIdea.DataStructure.StackAndQueue;

import java.util.Stack;

/**
 * 数据结构：栈和队列
 * leetcode：https://leetcode-cn.com/problems/daily-temperatures/
 * 每日温度
 */
public class DailyTemperatures {
    //方法一：暴力破解
    public int[] dailyTemperatures1(int[] T) {
        int n = T.length;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (T[j] > T[i]) {
                    result[i] = j - i;
                    break;
                }
            }

        }
        return result;
    }

    //方法二：单调栈
    public int[] dailyTemperatures2(int[] T) {
        int n = T.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
                int value = stack.pop();
                result[value] = i - value;
            }
            stack.add(i);
        }
        return result;
    }
}
