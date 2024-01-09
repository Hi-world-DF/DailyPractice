package LeetCode.AlgorithmIdea.doublePointer;

/**
 * 11. 盛最多水的容器
 *
 * @author Ernest
 * @version 1.0, 15/3/2021
 * @since 1.0.0
 */
public class MaxArea {

    /**
     * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
     * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。
     * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
     *
     * @param height 高度数组
     * @return 返回最大的容积
     */
    public int maxArea(int[] height) {
        int max = 0;
        int n = height.length;
        if (height == null || n <= 1) {
            return max;
        }
        int first = 0;
        int last = n - 1;
        while (first < last) {
            int width = last - first + 1;
            int high;
            if (height[first] <= height[last]) {
                high = height[first];
                first++;

            } else {
                high = height[last];
                last--;
            }
            max = Math.max(max, high * width);
        }
        return max;
    }
}
