package src.leetCode.AlgorithmIdea.divideAndConquer;

import java.util.ArrayList;
import java.util.List;

/**
 * 分治算法
 * leetcode:https://leetcode-cn.com/problems/different-ways-to-add-parentheses/description/
 * 为运算表达式设计优先级（给表达式加括号）
 * */
public class DifferentWaysToAddParentheses {
    public List<Integer> diffWaysToComputer(String input){
        List<Integer> ways = new ArrayList<>();
        for(int i =0 ; i<input.length();i++){
            char c = input.charAt(i);
            //题目规定：有效的运算符
            if(c == '+' || c == '-' || c == '*'){
                List<Integer> left = diffWaysToComputer(input.substring(0,i));
                List<Integer> right = diffWaysToComputer(input.substring(i+1));
                for(int first : left){
                    for (int last : right){
                        switch (c){
                            case '+':
                                ways.add(first+last);
                                break;
                            case '-':
                                ways.add(first-last);
                                break;
                            case '*':
                                ways.add(first*last);
                                break;
                        }
                    }
                }
            }
        }
        //如果只有一个数，那就把input的值加进去
        if(ways.size() == 0){
            ways.add(Integer.valueOf(input));
        }
        return ways;
    }
    /**
     * 测试
     * */
    public static void main(String[] args){
        DifferentWaysToAddParentheses diffWays = new DifferentWaysToAddParentheses();
        String input = "2-1-1*1+2";
        System.out.println(diffWays.diffWaysToComputer(input));
    }
}
