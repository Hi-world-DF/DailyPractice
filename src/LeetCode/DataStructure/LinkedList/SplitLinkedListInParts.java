package LeetCode.DataStructure.LinkedList;

/**
 * 数据结构：链表
 * leetcode：https://leetcode-cn.com/problems/split-linked-list-in-parts/
 * 分隔链表
 * */
public class SplitLinkedListInParts {
    public ListNode[] splitListToParts(ListNode root, int k) {
        int n = 0;
        ListNode current = root;
        //确定链表共有多少个节点
        while(current != null){
            n++;
            current = current.next;
        }
        /**
         * 分割之后链表的节点个数，前mod个链表的节点个数为size+1，之后的为size
         * 若N<k,则前面每个链表为一个元素，后面的为空
         */
        int mod = n%k;
        int size = n/k;
        ListNode[] result = new ListNode[k];
        current = root;
        //给ListNode[]数组的每个链表元素循环赋值
        for(int i = 0; current != null && i < k;i++){
            result[i] = current;
            int currentSize = size;
            if(mod > 0){
                currentSize = currentSize + 1;
                mod--;
            }
            for(int j = 0; j < currentSize-1; j++){
                current = current.next;
            }
            //ListNode[]数组里的每个链表元素结尾要指向null;
            ListNode next = current.next;
            current.next = null;
            current = next;
        }
        return result;
    }
}
