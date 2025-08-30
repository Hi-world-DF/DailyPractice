package leetCode.AlgorithmIdea.searchAlgorithm.BFS;
/**
 * 搜索算法：BFS（广度优先搜索）
 * leetcode:https://leetcode-cn.com/problems/word-ladder/
 * 单词接龙
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        /**
         * 1.先判断wordList 是否存在endWord 不存在返回0
         * */
        //将开始的单词也加入单词表中
        wordList.add(beginWord);
        int start = wordList.size() - 1;
        int hasEnd = 0;
        //遍历整个单词表，判断是否存在结束的单词
        for (int i = 0; i < wordList.size(); i++) {
            hasEnd = i;
            if (wordList.get(i).equals(endWord)) {
                break;
            }
        }
        //如果计数到了最后一个单词，说明单词表不存在结束的单词，返回0
        if (hasEnd == wordList.size() - 1) {
            return 0;
        }
        /**
         * 2.调用buildGraphic(wordList)建立单词图，如两个单词只有一个字母不一样，表示相邻
         */
        List<Integer>[] graphic = buildGraphic(wordList);
        /**
         * 3.调用getShortestPath，获取开始单词到结束单词的最短转换路径长度
         * */
        return getShortestPath(graphic, start, hasEnd);
    }

    /**
     * 函数名：getShortestPath
     * 函数作用：获取开始单词到结束单词的最短转换路径长度
     * @param graphic 单词图，单词之间还存在关系，相邻关系
     * @param start 开始单词在单词表中的位置
     * @param end 计数单词在单词表中的位置
     *
     * */
    private int getShortestPath(List<Integer>[] graphic, int start, int end) {
        //BFS标配 : 队列，标识遍历过的元素
        Queue<Integer> queue = new LinkedList<>();
        boolean[] marked = new boolean[graphic.length];
        queue.add(start);
        marked[start] = true;
        int path = 1;
        //队列非空，则path++;取出队列首元素，判断是否为结束单词，不是且未遍历过则压入队列，循环直到找到结束单词，返回path长度
        while (!queue.isEmpty()) {
            int size = queue.size();
            path++;
            while (size > 0) {
                int cur = queue.poll();
                size--;
                for (int next : graphic[cur]) {
                    if (next == end) {
                        return path;
                    }
                    if (marked[next]) {
                        continue;
                    }
                    marked[next] = true;
                    queue.add(next);
                }
            }
        }
        return 0;
    }

    /**
     * 函数名：buildGraphic
     * 函数作用：建立单词图
     * @param wordList 单词表
     * */
    private List<Integer>[] buildGraphic(List<String> wordList) {
        int n = wordList.size();
        //这里单词图用链表矩阵来表示
        List<Integer>[] graphic = new List[n];
        //循环遍历，如果两个单词相邻（两个单词相差一个字母），就将该单词加入到这个单词的列表中
        for (int i = 0; i < n; i++) {
            graphic[i] = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if (isConnect(wordList.get(i), wordList.get(j))) {
                    graphic[i].add(j);
                }
            }
        }
        return graphic;
    }

    /**
     * 方法名：isConnect
     * 方法作用：判断两个单词是否相邻
     * @param s1 单词s1
     * @param s2 单词s2
     * */
    private boolean isConnect(String s1, String s2) {
        int diffCnt = 0;
        //如果两个单词的不同的字符数不为1则两个单词不相邻
        for (int i = 0; i < s1.length() && diffCnt <= 1; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diffCnt++;
            }
        }
        return diffCnt == 1;
    }
}
