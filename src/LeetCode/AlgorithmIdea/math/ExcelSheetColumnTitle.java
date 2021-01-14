package AlgorithmIdea.math;
/**
 * 数学问题
 * leetcode:https://leetcode-cn.com/problems/excel-sheet-column-title/
 * 问题描述： Excel表列名称
 * */
public class ExcelSheetColumnTitle {
    //方法1:利用StringBuffer
    public String convertToTitle(int n) {
        if(n == 0) return "";
        StringBuffer sb = new StringBuffer();
        while(n != 0){
            n --;
            sb.append((char)(n % 26 + 'A'));
            n /= 26;
        }
        return sb.reverse().toString();
    }
    //方法2:递归
    public String convertToTitle2(int n) {
        if(n == 0) return "";
        n--;
        return convertToTitle(n/26) + (char)(n%26 + 'A');
    }
}
