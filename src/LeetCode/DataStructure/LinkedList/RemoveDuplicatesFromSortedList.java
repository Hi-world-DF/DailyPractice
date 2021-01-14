package DataStructure.LinkedList;

import org.w3c.dom.ls.LSException;

/**
 * 数据结构：链表
 * leetcode：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
 * 删除有序链表中重复元素
 * */
public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        head.next = deleteDuplicates(head.next);
        if(head.val == head.next.val){
            return head.next;
        }else{
            return head;
        }
    }
}
