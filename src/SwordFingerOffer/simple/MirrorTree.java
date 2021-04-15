package SwordFingerOffer.simple;

/**
 * 剑指 Offer 27. 二叉树的镜像
 *
 * @author Ernest
 * @version 1.0, 17/3/2021
 * @since 1.0.0
 */
public class MirrorTree {
    /**
     * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
     *
     * @param root 初始树
     * @return 镜像树
     */
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode temp = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(temp);
        return root;
    }
}
