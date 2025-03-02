package src.leetCode.everyday;

import java.util.HashMap;
import java.util.Map;

/**
 * 寻找数组的度
 *
 * @author Ernest
 * @version 1.0, 20/2/2021
 * @since 1.0.0
 */
public class FindShortestSubArray {
    /**
     * 求数组的度：数组里任一元素出现频数的最大值。
     *
     * @param nums 非空只包含非负数整数数组
     * @return int 度
     */
    public int findShortestSubArray(int[] nums) {
        int n = nums.length;
        int result = 0;
        //hashMap： key 存 nums[i] value 存 int数组包括，出现次数，初始位置和最后出现位置
        HashMap<Integer,int[]> map = new HashMap(n);
        for (int i = 0; i < n; i++) {
            if (map.containsKey(nums[i])) {
                map.get(nums[i])[0]++;
                map.get(nums[i])[2] = i;
            } else {
                map.put(nums[i], new int[]{1, i, i});
            }
        }
        int max = 0;
        //从map中找出value[0]，即出现次数最多的且value[2]-value[1]最小
        for (Map.Entry<Integer,int[]> entry : map.entrySet()) {
            int[] arr = entry.getValue();
            if (arr[0] > max) {
                max = arr[0];
                result = arr[2] - arr[1] + 1;
            } else if (arr[0] == max){
                if (result > arr[2] - arr[1] + 1) {
                    result = arr[2] - arr[1] + 1;
                }
            }
        }
        return result;
    }
}
