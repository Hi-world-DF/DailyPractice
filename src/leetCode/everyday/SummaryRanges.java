package src.leetCode.everyday;

import java.util.ArrayList;
import java.util.List;

/**
 * 区间汇总
 *
 * @author Ernest
 * @version 1.0, 10/1/2021
 * @since 1.0.0
 */
public class SummaryRanges {
    /**
     * 区间汇总
     *
     * @param nums 有序无重复整数数组
     * @return String list
     */
    public List<String> summaryRanges(int[] nums) {
        int l = nums.length;
        List<String> list = new ArrayList<>();
        if (0 == l) {
            return null;
        }
        int i = 0;
        while (i < l) {
            int low = i;
            i++;
            while (i < l && nums[i] == nums[i - 1] + 1) {
                i++;
            }
            int high = i - 1;
            StringBuffer temp = new StringBuffer(Integer.toString(nums[low]));
            if (low < high) {
                temp.append("->");
                temp.append(nums[high]);
            }
            list.add(temp.toString());
        }
        return list;
    }
}
