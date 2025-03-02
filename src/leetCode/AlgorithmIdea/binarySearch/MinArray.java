package src.leetCode.AlgorithmIdea.binarySearch;

/**
 * 剑指 Offer 11. 旋转数组的最小数字
 *
 * @author Ernest
 * @version 1.0, 3/3/2021
 * @since 1.0.0
 */
public class MinArray {
    /**
     * 数组由递增数组旋转一次得到,找出最小值
     *
     * @param numbers 旋转的初始数组
     * @return 最小值
     */
    public int minArray(int[] numbers) {
        int low = 0;
        int high = numbers.length - 1;
        while (low < high) {
            int mid = low + (high - low)/2;
            if (numbers[high] < numbers[mid]) {
                low = mid + 1;
            } else if (numbers[high] > numbers[mid]) {
                high = mid;
            } else {
                high--;
            }
        }
        return numbers[low];
    }
}
