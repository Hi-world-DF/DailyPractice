package LeetCode.AlgorithmIdea.doublePointer;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 双指针问题
 * leetcode:https://leetcode-cn.com/problems/reverse-vowels-of-a-string/
 * 反转字符串中的元音字符
 * */
public class ReverseVowelsOfString {
    public String reverseVowels(String s) {
        //使用hashSet存储元音字符
        HashSet<Character> vowels = new HashSet<>(Arrays.asList('a','e','i','o','u','A','E','I','O','U'));
        if(s == null){
            return null;
        }
        //定义两个指针，一个指向S第一个元素，一个指向S最后一个元素
        int i = 0;
        int j = s.length()-1;
        //用一个数组来存放result（反转元音字母之后的）结果
        char[] result =new char[s.length()];
        while(i<=j){
            char front = s.charAt(i);
            char last = s.charAt(j);
            if(!vowels.contains(front)){
                result[i] = front;
                i++;
            }else if(!vowels.contains(last)){
                result[j] = last;
                j--;
            }else{
                result[i] = last;
                result[j] = front;
                i++;
                j--;
            }
        }
        return new String(result);
    }
    /**
     * 测试
     * */
    public static void main(String[] args){
        ReverseVowelsOfString reverseVowelsOfString = new ReverseVowelsOfString();
        String s = "leetcode";
        String result = reverseVowelsOfString.reverseVowels(s);
        System.out.println(result);
    }
}
