package src.leetCode.everyday;

/**
 * 1769. 移动所有球到每个盒子所需的最小操作数
 *
 * @author Ernest
 * @version 1.0, 13/3/2021
 * @since 1.0.0
 */
public class MinOperations {

    /**
     * 返回对于每个盒子装完所有球所需的操作次数
     *
     * @param boxes
     * @return 操作次数的数组
     */

    /** 解法一：暴力法 */
    public int[] minOperations(String boxes) {
        int n  = boxes.length();
        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (boxes.charAt(j) == '1') {
                    answer[i] += i - j;
                }
            }

            for (int j = i; j < n; j++) {
                if (boxes.charAt(j) == '1') {
                    answer[i] += j - i;
                }
            }
        }
        return answer;
    }
    /**
     * 解法二：
     * 假设一个盒子的操作数是total,这个盒子右边有m个盒子有球，左边（包括自己）有n个盒子有球。
     * 计算这个盒子右边的盒子的操作数，相比刚刚的盒子，右边m个盒子都向左移动了一次（跑近了），
     * 总次数和刚刚的盒子相比减少m，左边n个盒子相比也向左移动了一次(跑远了)，总次数比刚刚的盒子增加n，
     * 所以这个盒子的操作个数是total-m+n
     *
     * */

    public int[] minOperations2(String boxes) {
        int n = boxes.length();
        int[] answer = new int[n];
        //左边有球盒子的个数，右边有球盒子个数，操作数
        int left = 0, right = 0, total = 0;
        //计算第一个盒子的操作数
        if (boxes.charAt(0) == '1') {
            left++;
        }
        for (int i = 1; i < n; i++) {
            if (boxes.charAt(i) == '1') {
                right++;
                total += i;
            }
        }
        answer[0] = total;
        for (int i = 1; i < n; i++) {
            total = total - right + left;
            if (boxes.charAt(i) == '1') {
                left++;
                right--;
            }
            answer[i] = total;
        }
        return answer;
    }
}
