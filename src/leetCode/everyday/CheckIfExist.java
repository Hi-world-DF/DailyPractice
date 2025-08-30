package leetCode.everyday;

import java.util.HashMap;

/**
 * 检查整数及其两倍数是否存在:给你一个整数数组 arr，请你检查是否存在两个整数 N 和 M，
 * 满足 N 是 M 的两倍（即，N = 2 * M）
 *
 * @author Ernest
 * @version 1.0, 3/3/2021
 * @since 1.0.0
 */
public class CheckIfExist {

    /**
     * 方法2：判断数组中是否存在一个数，且它的两倍数也存在
     *
     * @param arr 数组
     * @return 是否存在
     */
    public boolean checkIfExist(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j != i && j < len; j++) {
                if (arr[j] == 2 * arr[i] || arr[i] == 2 * arr[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 方法2：判断数组中是否存在一个数，且它的两倍数也存在
     *
     * @param arr 数组
     * @return 是否存在
     */
    public boolean checkIfExist2(int[] arr) {
        int len = arr.length;
        HashMap<Integer, Integer> map = new HashMap<>(len);
        for (int i = 0; i < len; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        for (int key : map.keySet()) {
            if (key == 0 && map.get(0) > 2) {
                return true;
            }
            if (key != 0 && map.containsKey(2 * key)) {
                return true;
            }
        }
        return false;
    }
}
