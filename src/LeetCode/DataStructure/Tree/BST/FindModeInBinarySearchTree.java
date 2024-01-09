package LeetCode.DataStructure.Tree.BST;


import swordFingerOffer.simple.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 数据结构：树【BST 二叉查找树】
 * leetcode:https://leetcode-cn.com/problems/find-mode-in-binary-search-tree/
 * 题目描述：二叉搜索树中的众数
 * */
public class FindModeInBinarySearchTree {
    private int current = 1;
    private int max = 1;
    private TreeNode treeNode = null;

    public int[] findMode(TreeNode root) {
        List<Integer> maxNums = new ArrayList<>();
        inOrder(root,maxNums);
        int[] result = new int[maxNums.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = maxNums.get(i);
        }
        return result;
    }

    private void inOrder(TreeNode root, List<Integer> maxNums) {
        if(root == null) return;
        inOrder(root.left,maxNums);
        if(treeNode != null){
            if(treeNode.val == root.val) current++;
            else current = 1;
        }
        if(current > max){
            max = current;
            maxNums.clear();
            maxNums.add(root.val);
        }else if(current == max){
            maxNums.add(root.val);
        }
        treeNode = root;
        inOrder(root.right,maxNums);

    }
}
