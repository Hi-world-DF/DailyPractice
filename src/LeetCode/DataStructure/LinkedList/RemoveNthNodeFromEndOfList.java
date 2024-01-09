
package LeetCode.DataStructure.LinkedList;

/**
 * 数据结构：链表
 * leetcode：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 * 删除链表倒数第n个节点
 * */
public class RemoveNthNodeFromEndOfList {
    /**
     * 方法一：
     * */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //求整个list有多少个节点，然后找到倒数第n个元素
        ListNode length = head;
        int l = 0;
        while(length !=null){
            l++;
            length = length.next;
        }
        //倒数第n个元素位置
        int nums = l-n;
        ListNode listNode = head;
        //如果要删除最前面的元素，那就返回head.next
        if(nums == 0){
            return head.next;
        }
        //然后找到倒数第n个位置元素
        while(nums > 1){
            nums--;
            listNode= listNode.next;
        }
        //如果head是null那就返回null,否则就将要删除的元素的前一个元素指向它的后一个元素
        if(head == null){
            return null;
        }else{
            listNode.next = listNode.next.next;
        }
        return head;
    }

    /**
     * 方法二：
     * */
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        //指向第n个节点
        ListNode last = head;
        while(n > 0){
            last = last.next;
            n--;
        }
        //指向前面的节点
        ListNode first = head;
        //删除第一个元素
        if(last == null){
            return head.next;
        }
        while(last.next != null){
            last = last.next;
            first = first.next;
        }
        first.next = first.next.next;
        return head;
    }
}
