package src.swordFingerOffer.simple;

import java.util.ArrayDeque;
import java.util.Deque;


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

/**
 * 剑指 Offer 06. 从尾到头打印链表
 *
 * @author Ernest
 * @version 1.0, 10/3/2021
 * @since 1.0.0
 */
public class ReversePrintList {
    public int[] reversePrint(ListNode head) {
        Deque<ListNode> stack = new ArrayDeque<>();
        ListNode temp = head;
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }
        int size = stack.size();
        int[] res = new int[size];
        for (int i = 0; i < size; i++) {
            res[i] = stack.pop().val;
        }
        return res;
    }
}
