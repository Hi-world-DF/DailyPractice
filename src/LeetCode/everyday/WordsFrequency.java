package everyday;

import java.util.HashMap;

/**
 * 单词频数
 *
 * @author Ernest
 * @version 1.0, 2/3/2021
 * @since 1.0.0
 */
public class WordsFrequency {

    HashMap<String,Integer> map = new HashMap<>();
    /**
     * 构造方法
     *
     * @param book 字符串数组
     */
    public WordsFrequency(String[] book) {
        for (String s : book) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
    }

    /**
     * 获取某个字符串的频数
     *
     * @param word 某个单词
     * @return 单词的频数
     */
    public int get(String word) {
        return map.getOrDefault(word, 0);
    }

}
