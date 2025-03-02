package src.leetCode.AlgorithmIdea.DataStructure.HashMap;

import java.util.HashMap;

/**
 * 剑指 Offer 53 - I. 在排序数组中查找数字 I
 *
 * @author Ernest
 * @version 1.0, 3/3/2021
 * @since 1.0.0
 */
public class CountFrequency {
    public int countFrequency(int[] nums, int target) {
        int len = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>(len);
        for (int i = 0; i < len; i++) {
            int cur = nums[i];
            map.put(cur,map.getOrDefault(cur, 0) + 1);
        }
        if (map.containsKey(target)) {
            return map.get(target);
        } else {
            return 0;
        }
    }
}
