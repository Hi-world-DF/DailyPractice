package src.swordFingerOffer.simple;

/**
 * 剑指 Offer 24. 反转链表
 *
 * @author Ernest
 * @version 1.0, 17/3/2021
 * @since 1.0.0
 */
public class ReverseList {

    /**
     * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点.
     *
     * @param head 初始链表
     * @return 反转后的链表
     */
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
