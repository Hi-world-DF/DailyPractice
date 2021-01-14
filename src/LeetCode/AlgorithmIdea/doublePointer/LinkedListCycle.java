package AlgorithmIdea.doublePointer;
/**
 * 双指针问题
 * leetcode:https://leetcode-cn.com/problems/linked-list-cycle/
 * 判断链表是否存在环
 * */
//Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if(head == null){
            return false;
        }
        ListNode index1 = head;
        ListNode index2 = head.next;
        while(index1 != null && index2 != null && index2.next != null){
            if(index1 == index2){
                return true;
            }
            index1 = index1.next;
            index2 = index2.next.next;
        }
        return false;
    }
    /**
     * 测试
     * */
    public static void main(String[] args){
        int[] a={2,3,0,-4};
        ListNode head = new ListNode(a[0]);
        LinkedListCycle linkedListCycle = new LinkedListCycle();
        boolean result = linkedListCycle.hasCycle(head);
        System.out.println(result);
    }
}
