package DataStructure.Tree.BST;
/**
 * 数据结构：树【BST 二叉查找树】
 * leetcode:https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/
 * 题目描述：二叉搜索树的最小绝对差
 * */
public class MinimumAbsoluteDifferenceInBST {
    private int result = Integer.MAX_VALUE;
    private TreeNode treeNode = null;
    public int getMinimumDifference(TreeNode root) {
        inOrder(root);
        return result;
    }

    private void inOrder(TreeNode root) {
        if(root == null) return;
        inOrder(root.left);
        if(treeNode != null) result = Math.min(result,root.val - treeNode.val);
        treeNode = root;
        inOrder(root.right);
     }
}
