package leetCode.AlgorithmIdea.doublePointer;

/**
 * 双指针问题
 * leetcode:https://leetcode-cn.com/problems/valid-palindrome-ii/
 * 回文字符串
 */
public class ValidPalindrome {
    //判断是否回文的代码：
//    public boolean validPalindrome(String s) {
//        int i = 0;
//        int j = s.length() -1;
//        while(i<=j){
//            char f = s.charAt(i);
//            char l = s.charAt(j);
//            if(f != l){
//                return false;
//            }else{
//                i++;
//                j--;
//            }
//        }
//        return true;
//    }

    //可以执行删除一个字符操作的来判断回文
    public boolean validPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return isPalindrome(s, i, j - 1) || isPalindrome(s, i + 1, j);
            }
        }
        return true;
    }

    private boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            } else {
                i++;
                j--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ValidPalindrome validPalindrome = new ValidPalindrome();
        String s = "abbca";
        boolean result = validPalindrome.validPalindrome(s);
        System.out.println(result);
    }

}
