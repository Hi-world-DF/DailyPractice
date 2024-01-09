package LeetCode.AlgorithmIdea.math;
/**
 * 数学问题
 * leetcode:https://leetcode-cn.com/problems/power-of-three/
 * 问题描述： 3的幂
 * */
public class PowerOfThree {
    public boolean isPowerOfThree(int n) {
        while(n > 1){
            if(n % 3 != 0) return false;
            n = n/3;
        }
        return true;
    }

    public static void main(String[] args) {
        PowerOfThree powerOfThree = new PowerOfThree();
        boolean result = powerOfThree.isPowerOfThree(3);
        System.out.println(result);
    }
}
