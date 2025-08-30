package leetCode.everyday;

import java.util.ArrayList;
import java.util.List;

/**
 * 119. 杨辉三角 II
 *
 * @author Ernest
 * @version 1.0, 15/4/2021
 * @since 1.0.0
 */
public class YanghuiTriangle2 {
    /**
     * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
     *
     * @param rowIndex 行索引
     * @return 返回杨辉三角该行列表
     */
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> cur = new ArrayList<>();
        for (int i = 0; i < rowIndex; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    temp.add(1);
                } else {
                    temp.add(cur.get(i-1).get(j-1) + cur.get(i-1).get(j));
                }
                cur.add(temp);
            }
        }
        return cur.get(rowIndex);
    }
}
