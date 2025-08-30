package leetCode.AlgorithmIdea.DataStructure.Tree.BST;

import src.leetCode.everyday.ListNode;
import src.swordFingerOffer.simple.TreeNode;

/**
 * 数据结构：树【BST 二叉查找树】
 * leetcode:https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/
 * 题目描述：有序链表转换二叉搜索树
 */
public class ConvertSortedListToBinarySearchTree {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return new TreeNode(head.val);
        ListNode preMid = preMid(head);
        ListNode mid = preMid.next;
        preMid.next = null;
        TreeNode treeNode = new TreeNode(mid.val);
        treeNode.left = sortedListToBST(head);
        treeNode.right = sortedListToBST(mid.next);
        return treeNode;
    }

    private ListNode preMid(ListNode head) {
        ListNode first = head, last = head.next;
        ListNode pre = head;
        while (last != null && last.next != null) {
            pre = first;
            first = first.next;
            last = last.next.next;
        }
        return pre;
    }
}
