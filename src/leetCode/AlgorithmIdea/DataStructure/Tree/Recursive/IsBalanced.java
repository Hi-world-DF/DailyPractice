package src.leetCode.AlgorithmIdea.DataStructure.Tree.Recursive;

import src.swordFingerOffer.simple.TreeNode;

/**
 * 面试题 04.04. 检查平衡性
 *
 * @author Ernest
 * @version 1.0, 15/3/2021
 * @since 1.0.0
 */
public class IsBalanced {
    /**
     * 实现一个函数，检查二叉树是否平衡。在这个问题中，
     * 平衡树的定义如下：任意一个节点，其两棵子树的高度差不超过 1。
     *
     * @param
     * @return
     */
    boolean res = true;
    public boolean isBalanced(TreeNode root) {
        getMaxDepth(root);
        return res;
    }

    private int getMaxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int lMax = getMaxDepth(root.left);
        int rMax = getMaxDepth(root.right);
        if (Math.abs(rMax - lMax) > 1) {
            res = false;
        }
        return Math.max(lMax , rMax) + 1;
    }
}
