package src.leetCode.everyday;

import java.util.ArrayList;
import java.util.List;

/**
 * 118. 杨辉三角
 *
 * @author Ernest
 * @version 1.0, 15/4/2021
 * @since 1.0.0
 */
public class YanghuiTriangle {
    /**
     * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
     * 在杨辉三角中，每个数是它左上方和右上方的数的和。
     *
     * @param numRows 行数
     * @return List<List<Integer>> 生成的杨辉三角列表
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> cur = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    cur.add(1);
                } else {
                    cur.add(res.get(i-1).get(j-1) + res.get(i-1).get(j));
                }
            }
            res.add(cur);
        }
        return res;
    }
}
