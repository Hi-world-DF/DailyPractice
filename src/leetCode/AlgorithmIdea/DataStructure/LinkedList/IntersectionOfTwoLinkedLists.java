package leetCode.AlgorithmIdea.DataStructure.LinkedList;

/**
 * 数据结构：链表
 * leetcode：https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 * 找出两个链表的交点
 */
public class IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode listA = headA;
        ListNode listB = headB;
        while (listA != listB) {
            listA = (listA == null) ? headB : listA.next;
            listB = (listB == null) ? headA : listB.next;
        }
        return listA;
    }

    public static void main(String[] args) {
        IntersectionOfTwoLinkedLists out = new IntersectionOfTwoLinkedLists();
        ListNode headA = null;
        ListNode headB = null;
        out.getIntersectionNode(headA, headB);
    }
}
