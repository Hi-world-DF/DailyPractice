package SwordFingerOffer.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer 54. 二叉搜索树的第k大节点
 *
 * @author Ernest
 * @version 1.0, 18/3/2021
 * @since 1.0.0
 */
public class KthLargest {
    /**
     * 给定一棵二叉搜索树，请找出其中第k大的节点。
     *
     * @param root 初始树
     * @param k 第k大的
     * @return 第k大的节点值
     */
    public int kthLargest(TreeNode root, int k) {
        //先中序遍历
        List<Integer> list = new ArrayList<>();
        dfs(root, list);
        return list.get(list.size() - k);
    }
    private void dfs(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        dfs (root.left, list);
        list.add(root.val);
        dfs (root.right, list);
    }
}
