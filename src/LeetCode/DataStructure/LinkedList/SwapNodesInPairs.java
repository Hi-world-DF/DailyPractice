package DataStructure.LinkedList;
/**
 * 数据结构：链表
 * leetcode：https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 * 两两交换链表中的节点
 * */
public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        //首先判断是否为空或者只有一个节点，是就返回该null/节点
        if(head == null || head.next == null){
            return head;
        }
        //两个指针分别指向前后两个节点
        ListNode pre = head;
        ListNode last = pre.next;
        while(last != null){
            //交换两节点的值
            int tmp = last.val;
            last.val = pre.val;
            pre.val = tmp;
            //如果后一指针没有节点，那么跳出循环
            if(last.next == null){
                break;
            }
            //两个指针都向后面移动两个位置
            pre = pre.next.next;
            last = last.next.next;
        }
        return head;
    }
}
