package DataStructure.Tree.Recursive;
/**
 * 数据结构：树【递归】
 * leetcode:https://leetcode-cn.com/problems/subtree-of-another-tree/
 * 题目描述：另一个树的子树
 * */
public class SubtreeOfAnotherTree {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) return false;
        return isSubtreeFromRoot(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    private boolean isSubtreeFromRoot(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        if (s.val != t.val) return false;
        return isSubtreeFromRoot(s.left, t.left) && isSubtreeFromRoot(s.right, t.right);
    }
}
