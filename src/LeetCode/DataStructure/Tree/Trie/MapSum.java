package DataStructure.Tree.Trie;
/**
 * 数据结构：树【前缀二叉树】
 * leetcode:https://leetcode-cn.com/problems/map-sum-pairs/
 * 题目描述：求前缀和
 * */

public class MapSum {

    private class Node {
        Node[] child = new Node[26];
        int value;
    }
    private Node root = new Node();

    /** Initialize your data structure here. */
    public MapSum() {

    }

    public void insert(String key, int val) {
        insert(key,root,val);
    }

    public void insert(String key,Node node, int val) {
        if(node == null) return;
        if(key.length() == 0){
            node.value = val;
            return;
        }
        int index = indexForChar(key.charAt(0));
        if(node.child[index] == null){
            node.child[index] = new Node();
        }
        insert(key.substring(1),node.child[index],val);
    }

    private int indexForChar(char c) {
        return c - 'a';
    }

    public int sum(String prefix) {
        return sum(prefix,root);
    }

    public int sum(String prefix,Node node) {
        if(node == null) return 0;
        if (prefix.length() != 0) {
            int index = indexForChar(prefix.charAt(0));
            return sum(prefix.substring(1), node.child[index]);
        }
        int sum = node.value;
        for (Node child : node.child) {
            sum += sum(prefix, child);
        }
        return sum;
    }
}
