package src.leetCode.AlgorithmIdea.DataStructure.StackAndQueue;

import java.util.Stack;

/**
 * 数据结构：栈和队列
 * leetcode：https://leetcode-cn.com/problems/implement-queue-using-stacks/
 * 用栈实现队列
 * */
public class ImplementQueueUsingStacks {
    private Stack<Integer> in = new Stack<>();
    private Stack<Integer> out = new Stack<>();
    /** Initialize your data structure here. */
    public ImplementQueueUsingStacks() {

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        in.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(out.isEmpty()){
            while(!in.isEmpty()){
                 out.push(in.pop());
            }
        }
        return out.pop();
    }

    /** Get the front element. */
    public int peek() {
        if(out.isEmpty()){
            while(!in.isEmpty()){
                out.push(in.pop());
            }
        }
        return out.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        if(in.isEmpty() && out.isEmpty()){
            return true;
        }else{
            return false;
        }
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
