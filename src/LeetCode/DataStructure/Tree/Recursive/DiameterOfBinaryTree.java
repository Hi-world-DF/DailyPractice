package DataStructure.Tree.Recursive;
/**
 * 数据结构：树【递归】
 * leetcode:https://leetcode-cn.com/problems/diameter-of-binary-tree/
 * 题目描述：二叉树的直径
 * */
public class DiameterOfBinaryTree {
    private int result = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return result;
    }

    private int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int l = maxDepth(root.left);
        int r = maxDepth(root.right);
        result = Math.max(result,l+r);
        return Math.max(l,r)+1;
    }

}
