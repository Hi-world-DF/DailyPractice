package leetCode.AlgorithmIdea.DataStructure.Tree.BST;

import src.swordFingerOffer.simple.TreeNode;

/**
 * 数据结构：树【BST 二叉查找树】
 * leetcode:https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/
 * 题目描述：将有序数组转换为二叉搜索树
 * */
public class ConvertSortedArrayToBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        return toBST(nums,0,nums.length -1);
    }

    private TreeNode toBST(int[] nums, int start, int end) {
        if(start > end) return null;
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = toBST(nums,start,mid -1);
        root.right = toBST(nums,mid +1,end);
        return root;
    }

}
