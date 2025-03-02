package src.swordFingerOffer.simple;

import src.leetCode.everyday.ListNode;

/**
 * 剑指 Offer 18. 删除链表的节点
 *
 * @author Ernest
 * @version 1.0, 17/3/2021
 * @since 1.0.0
 */
public class DeleteNode {

    /**
     * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
     * 返回删除后的链表的头节点。
     *
     * @param head 链表头节点
     * @param val  删除节点的值
     * @return ListNode
     */
    public ListNode deleteNode(ListNode head, int val) {
        if (head.val == val) {
            return head.next;
        }
        ListNode pre = head, cur = head.next;
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
                break;
            } else {
                pre = cur;
                cur = cur.next;
            }
        }

        return head;
    }
}
