package src.leetCode.AlgorithmIdea.DataStructure.StackAndQueue;

/**
 * 删除字符串中的所有相邻重复项
 *
 * @author Ernest
 * @version 1.0, 10/3/2021
 * @since 1.0.0
 */
public class RemoveDuplicates {

    public String removeDuplicates(String S) {

        StringBuilder stack = new StringBuilder();
        int top = -1;
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (top >= 0 && stack.charAt(top) == c) {
                stack.deleteCharAt(top);
                top--;
            } else {
                stack.append(c);
                top++;
            }
        }
        return stack.toString();
    }
}
