package DataStructure.LinkedList;
/**
 * 数据结构：链表
 * leetcode：https://leetcode-cn.com/problems/reverse-linked-list/
 * 链表反转
 * */
public class ReverseLinkedList {

    /**
     * 递归
     * */
//    public ListNode reverseList(ListNode head){
//        if(head == null || head.next == null){
//            return head;
//        }
//        ListNode next = head.next;
//        ListNode newHead = reverseList(next);
//        next.next = head;
//        head.next = null;
//        return newHead;
//    }

        /**
         * 头插法
         * */
        public ListNode reverseList(ListNode head){
            ListNode newHead = new ListNode(-1);
            while(head != null){
                ListNode next = head.next;
                head.next = newHead.next;
                newHead.next = head;
                head = next;
            }
            return newHead;
        }

}
