package src.leetCode.AlgorithmIdea.doublePointer;
/**
 * 双指针问题
 * leetcode:https://leetcode-cn.com/problems/longest-word-in-dictionary-through-deleting/
 * 最长子序列
 * */
import java.util.Arrays;
import java.util.List;

public class LongestWordInDictionaryThroughDeleting {
    public String findLongestWord(String s, List<String> d) {
        String longestWord = "";
        for(String target : d){
            int length1 = longestWord.length();
            int length2 = target.length();
            if(length1>length2 || (length1 == length2 && longestWord.compareTo(target) < 0)){
                continue;
            }
            if(isSubstring(s,target)){
                longestWord = target;
            }
        }
        return longestWord;
    }
    private boolean isSubstring(String s,String target){
        int i = 0;
        int j = 0;
        while(i < s.length() && j < target.length()){
            if(s.charAt(i)==target.charAt(j)){
                j++;
            }
            i++;
        }
        return j==target.length();
    }
    /**
     * 测试
     * */
    public static void main(String[] args){
        LongestWordInDictionaryThroughDeleting lw = new LongestWordInDictionaryThroughDeleting();
        String s = "abpcplea";
        List<String> d = Arrays.asList("ale", "apple", "monkey", "plea");
        String result = lw.findLongestWord(s,d);
        System.out.println(result);
    }
}
