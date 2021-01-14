package DataStructure.Tree.LevelTraversal;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 数据结构：树【层次遍历】
 * leetcode:https://leetcode-cn.com/problems/find-bottom-left-tree-value/
 * 题目描述：找树左下角的值
 * */

public class FindBottomLeftTreeValue {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            root = queue.poll();
            if(root.right != null) queue.add(root.right);
            if(root.left != null) queue.add(root.left);
        }
        return root.val;
    }
}
