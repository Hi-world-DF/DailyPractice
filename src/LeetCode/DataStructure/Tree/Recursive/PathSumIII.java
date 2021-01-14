package DataStructure.Tree.Recursive;
/**
 * 数据结构：树【递归】
 * leetcode:https://leetcode-cn.com/problems/path-sum-iii/
 * 题目描述：路径总和 3
 * */
public class PathSumIII {
    public int pathSum(TreeNode root, int sum) {
        if(root == null) return 0;
        int result =pathSumStartRoot(root,sum)+ pathSum(root.left,sum)+pathSum(root.right,sum);
        return result;
    }

    private int pathSumStartRoot(TreeNode root, int sum) {
        if(root == null) return 0;
        int result = 0;
        if(root.val == sum) result++;
        result += pathSumStartRoot(root.left,sum-root.val)+pathSumStartRoot(root.right,sum-root.val);
        return result;
    }
}
