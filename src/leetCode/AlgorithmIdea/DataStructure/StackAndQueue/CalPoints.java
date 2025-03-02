package src.leetCode.AlgorithmIdea.DataStructure.StackAndQueue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 682. 棒球比赛
 *
 * @author Ernest
 * @version 1.0, 5/3/2021
 * @since 1.0.0
 */
public class CalPoints {
    /**
     * 记录比赛得分
     *
     * @param ops 操作字符串
     * @return 返回最终分数
     */
    public int calPoints(String[] ops) {
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < ops.length; i++) {
            String s = ops[i];
            if (s.equals("C")) {
                deque.pop();
            } else if (s.equals("D")) {
                int top = deque.peek();
                deque.push(top * 2);
            } else if (s.equals("+")) {
                int top = deque.pop();
                int second = deque.peek();
                deque.push(top);
                deque.push(top + second);
            } else {
                deque.push(Integer.valueOf(s));
            }
        }
        int res = 0;
        for (int i : deque) {
            res += i;
        }
        return res;
    }
}
