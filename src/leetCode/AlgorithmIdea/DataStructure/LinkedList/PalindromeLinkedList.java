package leetCode.AlgorithmIdea.DataStructure.LinkedList;

/**
 * 数据结构：链表
 * leetcode：https://leetcode-cn.com/problems/palindrome-linked-list/
 * 回文链表
 * <p>
 * >>>>>>>>>>>>>>>>>>>>>>>未通过
 */
public class PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != null) {
            slow = slow.next;
        }
        cut(head, slow);
        return isEqual(head, reverse(slow));
    }

    private boolean isEqual(ListNode l1, ListNode l2) {
        while (l1 != null && l2 != null) {
            if (l1.val != l2.val) {
                return false;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        return true;
    }

    private ListNode reverse(ListNode slow) {
        ListNode newHead = null;
        while (slow != null) {
            ListNode nextNode = slow.next;
            slow.next = newHead;
            newHead = slow;
            slow = nextNode;
        }
        return newHead;
    }

    private void cut(ListNode head, ListNode slow) {
        while (head.next != slow) {
            head = head.next;
        }
        head.next = null;
    }

//    public boolean isPalindrome(ListNode head) {
//        Stack<Integer> s = new Stack<>();
//        //如果链表为空，或者只有一个元素，那么返回true
//        if(head == null || head.next == null){
//            return true;
//        }
//        //n来计数，链表有多少个节点
//        int n = 0;
//        ListNode node = head;
//        while(node != null){
//            n++;
//            node = node.next;
//        }
//        int sn = (n+1)/2;
//        int mid = n/2 +1;
//        ListNode sNode = head;
//        while(sn > 0){
//            s.push(sNode.val);
//            sNode = sNode.next;
//            sn--;
//        }
//        while(mid > 0){
//            head = head.next;
//            mid--;
//        }
//        while(!s.isEmpty()){
//            if(s.pop() != head.val){
//                return false;
//            }
//            head = head.next;
//        }
//        return true;
//    }

}
