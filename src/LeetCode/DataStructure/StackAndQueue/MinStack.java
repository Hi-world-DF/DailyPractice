package DataStructure.StackAndQueue;
/**
 * 数据结构：栈和队列
 * leetcode：https://leetcode-cn.com/problems/min-stack/
 * 最小栈
 * */
import java.util.Stack;

public class MinStack {
    private Stack<Integer> dataStack;
    private Stack<Integer> minStack;
    private int min;
    /** initialize your data structure here. */
    //两个栈，一个正常存数据，另一个存当前栈内最小的那个值，
    public MinStack() {
        dataStack = new Stack<>();
        minStack = new Stack<>();
        min = Integer.MAX_VALUE;
    }
    // dataStack每push一个数,同时minStack也push一个当前最小的值
    public void push(int x) {
        dataStack.add(x);
        min = Math.min(min,x);
        minStack.add(min);
    }
    // pop时两个栈同时pop(),只要min栈不空，那么min就是min栈顶的那个值
    public void pop() {
        dataStack.pop();
        minStack.pop();
        if(minStack.isEmpty()){
            min = Integer.MAX_VALUE;
        }else{
            min = minStack.peek();
        }
    }

    public int top() {
        return dataStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
