package LeetCode.DataStructure.StackAndQueue;

import java.util.Stack;

/**
 * 数据结构：栈和队列
 * leetcode：https://leetcode-cn.com/problems/valid-parentheses/
 * 有效括号
 * */
public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0;i < s.length();i++){
            char currentP = s.charAt(i);
            if(currentP == '(' || currentP == '[' || currentP == '{'){
                stack.push(currentP);
            }else{
                if(currentP == ')'){
                     if(stack.peek()=='('){
                         stack.pop();
                         continue;
                     }else{
                         return false;
                     }
                }
                if(currentP == ']'){
                    if(stack.peek()=='['){
                        stack.pop();
                        continue;
                    }else{
                        return false;
                    }
                }
                if(currentP == '}'){
                    if(stack.peek()=='{'){
                        stack.pop();
                        continue;
                    }else{
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }
}
