package DataStructure.Tree.Recursive;
/**
 * 数据结构：树【递归】
 * leetcode:https://leetcode-cn.com/problems/longest-univalue-path/
 * 题目描述：最长同值路径
 * */
public class LongestUniValuePath {
    private int path = 0;
    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return path;
    }
    private int dfs(TreeNode root) {
        if(root == null) return 0;
        int l = dfs(root.left);
        int r = dfs(root.right);
        int lPath = 0,rPath = 0;
        if(root.left != null && root.left.val == root.val){
            lPath = l + 1;
        }
        if(root.right != null && root.right.val == root.val){
            rPath = r + 1;
        }
        path = Math.max(path,lPath+rPath);
        return Math.max(lPath,rPath);
    }

}
