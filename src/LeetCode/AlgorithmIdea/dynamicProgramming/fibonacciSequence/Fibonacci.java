package AlgorithmIdea.dynamicProgramming.fibonacciSequence;
/**
 * 动态规划：斐波那契数列
 * leetcode:
 * 问题描述：打印斐波那契数列
 * */
public class Fibonacci {
    public int[] printFibonacci (int n){
        if(n <= 0) return null;
        int[] fb = new int[n];
        if(n == 1) {
            fb[0] = 0;
            return fb;
        }
        if(n == 2){
            fb[0] = 0;
            fb[1] = 1;
            return fb;
        }
        fb[0] = 0;
        fb[1] = 1;
        int pre1 = fb[0];
        int pre2 = fb[1];
        for (int i = 2; i < n; i++) {
            int cur = pre1 +pre2;
            pre1 = pre2;
            pre2 = cur;
            fb[i] = cur;
        }
        return fb;
    }

    public static void main(String[] args) {
        int n = 20;
        Fibonacci fibonacci = new Fibonacci();
        int[] result = fibonacci.printFibonacci(n);
        if(result == null || result.length == 0){
            System.out.println("n必须大于1！！！");
        }else{
            for (int i = 0; i < result.length; i++) {
                System.out.print(result[i]+" ");
            }
        }
    }

}
