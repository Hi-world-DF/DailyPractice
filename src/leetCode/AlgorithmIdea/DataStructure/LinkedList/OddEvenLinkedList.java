package src.leetCode.AlgorithmIdea.DataStructure.LinkedList;

/**
 * 数据结构：链表
 * leetcode：https://leetcode-cn.com/problems/odd-even-linked-list/
 * 奇偶链表：把奇数位置的节点排一起，偶数位置的节点排一起
 * */
public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        //两个指针分别一个指向奇数位置的节点，另一个指向偶数位置的节点
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;
        while(even != null && even.next != null){
            odd.next = odd.next.next;
            odd = odd.next;
            even.next = even.next.next;
            even = even.next;
        }
        //最后把偶数节点的链表接在奇数节点链表后面
        odd.next = evenHead;
        return head;
    }
}
