package LeetCode.AlgorithmIdea.greedyAlgorithm;
/**
 * 贪心算法
 * leetcode:https://leetcode-cn.com/problems/is-subsequence/
 * 判断是否是子序列
 * */
public class IsSubsequence {
    public static boolean isSubsequence(String s,String t) {
//        int si = s.length();
//        int ti = t.length();
//        for (int i = 1, j = 1; i < ti && j <= si;) {
//            if (t.charAt(i) == s.charAt(j)) {
//                j++;
//            }
//            i++;
//            if (j > si) {
//                return true;
//            }
//        }
//        return false;
        int index = -1;
        /**循环比较s中的字符
         *s.toCharArray()将s字符串转换为字符数组
         */
        for(char c : s.toCharArray()){
            /**
             * 没找到，返回-1
             * 1.int indexOf(String str):
             *      返回第一次出现的指定子字符串在此字符串中的索引
             * 2.int indexOf(String str, int startIndex):
             *      从指定的索引处开始，返回第一次出现的指定子字符串在此字符串中的索引
             * 3.int lastIndexOf(String str):
             *      返回在此字符串中最右边出现的指定子字符串的索引
             * 4.int lastIndexOf(String str, int startIndex):
             *      从指定的索引处开始向后搜索，返回在此字符串中最后一次出现的指定子字符串的索引
             * */
            index = t.indexOf(c,index+1);
            if(index == -1){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args){
        String s = "abc";
        String t = "ahbgc";
        boolean result = IsSubsequence.isSubsequence(s,t);
        System.out.println(result);
    }
}
