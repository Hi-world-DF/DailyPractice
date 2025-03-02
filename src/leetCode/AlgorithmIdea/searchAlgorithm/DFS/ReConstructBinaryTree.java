package src.leetCode.AlgorithmIdea.searchAlgorithm.DFS;

import java.util.Arrays;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

/**
 * 根据二叉树的先序遍历和中序遍历建造原始二叉树
 *
 * @author Ernest
 * @version 1.0, 21/2/2021
 * @since 1.0.0
 */
public class ReConstructBinaryTree {
    public TreeNode reConstructBinaryTree(int[] pre,int[] in) {
        //当两个数组的长度为0，就无法重构二叉树
        if(pre.length == 0 || in.length ==0){
            return null;
        }
        //重构二叉树的根节点为先序的第一个值
        TreeNode root = new TreeNode(pre[0]);
        for(int i = 0;i < in.length;i++){
            //找到根节点在中序遍历数组中的位置
            if(root.val == in[i]){
                //重构左右子树
                root.left = reConstructBinaryTree(Arrays.copyOfRange(pre,1,i+1),Arrays.copyOfRange(in,0,i));
                root.right = reConstructBinaryTree(Arrays.copyOfRange(pre,i+1,pre.length),Arrays.copyOfRange(in,i+1,in.length));
                break;
            }
        }
        return root;
    }
}
