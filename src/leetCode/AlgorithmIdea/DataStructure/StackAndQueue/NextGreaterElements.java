package leetCode.AlgorithmIdea.DataStructure.StackAndQueue;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 下一个更大元素 II
 *
 * @author Ernest
 * @version 1.0, 6/3/2021
 * @since 1.0.0
 */
public class NextGreaterElements {
    /**
     * 对于数组的每个元素，返回下一个比该元素更大的数
     *
     * @param nums 初始数组
     * @return 返回每个元素下一个更大数的数组
     */
    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        Arrays.fill(res, -1);
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < len * 2 - 1; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i % len]) {
                res[stack.pop()] = nums[i % len];
            }
            stack.push(i % len);
        }
        return res;
    }
}
