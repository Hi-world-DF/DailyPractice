package src.leetCode.AlgorithmIdea.DataStructure.LinkedList;

import java.util.Stack;

/**
 * 数据结构：链表
 * leetcode：https://leetcode-cn.com/problems/add-two-numbers-ii/
 * 链表求和
 * */
public class AddTwoNumbersFromList {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        //使用栈让链表的元素从最后一个节点相加
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        ListNode newHead = new ListNode(-1);
        //将l1的节点放到栈1中
        while(l1 != null){
            s1.push(l1.val);
            l1 = l1.next;
        }
        //将l2的节点放到栈2中
        while(l2 != null){
            s2.push(l2.val);
            l2 = l2.next;
        }
        //定义进位
        int carry = 0;
        //当所有节点都添加完，循环结束
        while(!s1.isEmpty() || !s2.isEmpty() || carry != 0){
            int a = s1.isEmpty()? 0 : s1.pop();
            int b = s2.isEmpty()? 0 : s2.pop();
            int sum = a + b + carry;
            ListNode node = new ListNode(sum % 10);
            //头插法把节点放在第一个位置
            node.next = newHead.next;
            newHead.next = node;
            carry = sum/10;
        }
        return newHead.next;
    }
}
