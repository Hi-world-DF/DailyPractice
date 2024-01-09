package LeetCode.everyday;

import java.util.ArrayList;
import java.util.List;

/**
 * 可被5整除的二进制前缀
 *
 * @author Ernest
 * @version 1.0, 14/1/2021
 * @since 1.0.0
 */
public class PrefixesDivBy5 {
    /**
     * 从A[0]到A[i]的第i个子数组被解释为一个二进制数，如果该数可以被5整除则返回true否则false
     *
     * @param A 由0/1组成的数组A
     * @return boolean列表
     */
    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> res = new ArrayList<>();
        int current = 0;
        for (int i = 0; i < A.length; i++) {
            current = ((current << 1) + A[i]) % 5;
            res.add(0 == current);
        }
        return res;
    }

    /**
     * 简单main函数测试
     *
     * @param args String数组
     */
    public static void main(String[] args) {
        PrefixesDivBy5 pd5 = new PrefixesDivBy5();
        int[] A = {1, 0, 1, 0, 1};
        int[] B = {};
        int[] C = {0, 0, 0, 0};
        System.out.println(pd5.prefixesDivBy5(A).toString());
        System.out.println(pd5.prefixesDivBy5(B).toString());
        System.out.println(pd5.prefixesDivBy5(C).toString());
    }

}
