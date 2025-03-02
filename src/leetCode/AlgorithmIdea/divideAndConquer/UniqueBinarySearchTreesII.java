package src.leetCode.AlgorithmIdea.divideAndConquer;

import java.util.*;

/**
 * 分治算法
 * leetcode:https://leetcode-cn.com/problems/unique-binary-search-trees-ii/
 * 不同的二叉搜索树 II
 * */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class UniqueBinarySearchTreesII {
    public List<TreeNode> generateTrees(int n) {
        if(n < 1){
            return new LinkedList<TreeNode>();
        }
        return generateSubtrees(1,n);
    }

    public List<TreeNode> generateSubtrees(int l,int r){
        List<TreeNode> result = new LinkedList<TreeNode>();
        if(l > r){
            result.add(null);
            return result;
        }
        for(int i = l;i <= r;++i){
            List<TreeNode> leftSubtrees = generateSubtrees(l,i-1);
            List<TreeNode> rightSubtrees = generateSubtrees(i+1,r);
            for(TreeNode left : leftSubtrees){
                for(TreeNode right : rightSubtrees){
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    result.add(root);
                }
            }
        }
        return result;
    }
    public static void main(String[] args){
        UniqueBinarySearchTreesII genTree = new UniqueBinarySearchTreesII();
        Scanner in = new Scanner(System.in);
        List<TreeNode> result = genTree.generateTrees(in.nextInt());
        for(TreeNode tree : result){
            if(tree.left != null){
                System.out.println(tree.left.val);
            }else {
                System.out.println(tree.right.val);
            }
        }


    }
}
