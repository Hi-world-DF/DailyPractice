package LeetCode.everyday;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 基本计算器 II
 *
 * @author Ernest
 * @version 1.0, 11/3/2021
 * @since 1.0.0
 */
public class Calculater {
    /**
     * 实现计算器：给你一个字符串表达式 s，请你实现一个基本计算器来计算并返回它的值。
     *
     * @param s 初始字符串
     * @return 返回结果值
     */
    public int calculate(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        char preSign = '+';
        int num = 0;
        for (int i = 0; i < s.length(); i++) {

            boolean isDigit = Character.isDigit(s.charAt(i));
            boolean isSpace = s.charAt(i) != ' ';
            boolean isEnd = i == (s.length()-1);
            if (isDigit) {
                num = num * 10 + (s.charAt(i) - '0');
            }

            if (!isDigit && isSpace || isEnd) {
                switch (preSign) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    default:
                        stack.push(stack.pop() / num);
                }
                preSign = s.charAt(i);
                num = 0;
            }
        }
        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }
}
