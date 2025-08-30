package leetCode.everyday;

/**
 * 剑指 Offer 25. 合并两个排序的链表
 *
 * @author Ernest
 * @version 1.0, 17/3/2021
 * @since 1.0.0
 */
public class MergeTwoLists {

    /**
     * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
     *
     * @param l1 链表1
     * @param l2 链表2
     * @return 合并之后的链表
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode res = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                res.next = l1;
                l1 = l1.next;
            } else {
                res.next = l2;
                l2 = l2.next;
            }
            res = res.next;
        }
        if (l1 != null) {
            res.next = l1;
        }
        if (l2 != null) {
            res.next = l2;
        }
        return head;
    }
}
