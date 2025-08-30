package leetCode.AlgorithmIdea.DataStructure.Tree.LevelTraversal;

import src.swordFingerOffer.simple.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 数据结构：树【层次遍历】
 * leetcode:https://leetcode-cn.com/problems/average-of-levels-in-binary-tree/
 * 题目描述：二叉树的层平均值
 * */
public class AverageOfLevelsInBinaryTree {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null) {
            return result;
        }
        queue.add(root);
        while(!queue.isEmpty()){
            double sum = 0;
            int currentL = queue.size();
            for (int i = 0; i < currentL; i++) {
                TreeNode node = queue.poll();
                sum += node.value;
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            result.add(sum / currentL);
        }
        return result;
    }
}
