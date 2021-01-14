package AlgorithmIdea.math;
/**
 * 数学问题
 * leetcode:https://leetcode-cn.com/problems/count-primes/
 * 问题描述：计数质数（生成素数序列）
 * */
public class CountPrimes {
    public int countPrimes(int n) {
        boolean[] notPrimes = new boolean[n + 1];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (notPrimes[i]) {
                continue;
            }
            count++;
            for (long j = (long)(i)*i; j < n; j += i) {
                notPrimes[(int) j] = true;
            }
        }
        return count;
    }
}
