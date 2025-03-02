package src.leetCode.AlgorithmIdea.math;
/**
 * 数学问题
 * leetcode:https://leetcode-cn.com/problems/valid-perfect-square/
 * 问题描述： 有效的完全平方数
 * */
public class ValidPerfectSquare {
    //解法1：i从1到num判断num是不是i的平方数，上限会超出
    public boolean isPerfectSquare(int num) {
        for (int i = 1; i < num; i++) {
            if(num % i == 0 && num / i == i) return true;
        }
        return false;
    }
    //方法2：1、4、9、16...  间隔是 3 5 7 9 11 ...
    public boolean isPerfectSquare1(int num) {
        int n = 1;
        while(num > 0){
            num -= n;
            n += 2;
        }
        return num == 0? true:false;
    }
}
