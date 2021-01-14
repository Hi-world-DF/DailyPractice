package AlgorithmIdea.binarySearch;

import java.util.Scanner;
/**
 * 二分查找
 * leetcode:https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 * 在排序数组中查找元素的第一个和最后一个位置
 * */
public class FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int first = findFirst(nums, target);
        //最后一个位置肯定在比target临近大一点的数的前一个位置
        int last = findFirst(nums, target + 1) - 1;
        if (first == nums.length || nums[first] != target) {
            //没有的话就返回[-1,-1]
            return new int[]{-1, -1};
        } else {
            return new int[]{first, Math.max(first, last)};
        }
    }
    /**
     * 二分查找
     * */
    private int findFirst(int[] nums, int target) {
        int first = 0, last = nums.length;
        while (first < last) {
            int mid = first + (last - first) / 2;
            if (nums[mid] >= target) {
                last = mid;
            } else {
                first = mid + 1;
            }
        }
        return first;
    }
    /**
     * 测试
     * */
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        FindFirstAndLastPositionOfElementInSortedArray findFAL = new FindFirstAndLastPositionOfElementInSortedArray();
        int[] nums = {2,2};
        int target = in.nextInt();
        int[] result = findFAL.searchRange(nums,target);
        for(int i = 0;i < result.length;i++){
            System.out.print(result[i]+" ");
        }
    }
}
