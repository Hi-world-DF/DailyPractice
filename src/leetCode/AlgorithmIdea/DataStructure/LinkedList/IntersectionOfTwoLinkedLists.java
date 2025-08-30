package leetCode.AlgorithmIdea.DataStructure.LinkedList;

/**
 * 数据结构：链表
 * leetcode：https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 * 找出两个链表的交点
 */
public class IntersectionOfTwoLinkedLists {
    public src.leetCode.everyday.ListNode getIntersectionNode(src.leetCode.everyday.ListNode headA, src.leetCode.everyday.ListNode headB) {
        src.leetCode.everyday.ListNode listA = headA;
        src.leetCode.everyday.ListNode listB = headB;
        while (listA != listB) {
            listA = (listA == null) ? headB : listA.next;
            listB = (listB == null) ? headA : listB.next;
        }
        return listA;
    }

    public static void main(String[] args) {
        IntersectionOfTwoLinkedLists out = new IntersectionOfTwoLinkedLists();
        src.leetCode.everyday.ListNode headA = null;
        src.leetCode.everyday.ListNode headB = null;
        out.getIntersectionNode(headA, headB);
    }
}
