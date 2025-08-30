package leetCode.AlgorithmIdea.DataStructure.StackAndQueue;

import java.util.Arrays;
import java.util.Stack;

/**
 * 数据结构：栈和队列
 * leetcode：https://leetcode-cn.com/problems/next-greater-element-ii/
 * 循环数组中下一个更大元素
 */
public class NextGreaterElementII {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] next = new int[n];
        Arrays.fill(next, -1);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n * 2; i++) {
            int num = nums[i % n];
            while (!stack.isEmpty() && nums[stack.peek()] < num) {
                next[stack.pop()] = num;
            }
            if (i < n) {
                stack.push(i);
            }
        }
        return next;
    }
}
