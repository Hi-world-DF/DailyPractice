package com.niuke.test;


import java.beans.IntrospectionException;
import java.lang.reflect.Array;
import java.sql.SQLOutput;

import java.util.*;

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }

class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }


public class Solution {

    public ListNode getKthFromEnd(ListNode head, int k) {

        ListNode cur = head;
        int count = 0;
        while (cur != null){
            count++;
            cur = cur.next;
        }
        for (int i = 0; i < count - k; i++) {
            head = head.next;
        }
        return head;
    }




    /**
     * [-2,1,-3,4,-1,2,1,-5,4]
     * pre = -2   maxA = -2
     * pre = 1    maxA = 1
     * pre = -2   maxA = 1
     * pre = 4    maxA = 4
     * pre = 3
     *
     */

    public static void main(String[] args) {
        String str1 = new StringBuilder("58").append("tongcheng").toString();
        System.out.println(str1);
        System.out.println(str1.intern());
        System.out.println(str1 == str1.intern());

        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2);
        System.out.println(str2.intern());
        System.out.println(str2 == str2.intern());
    }

}


