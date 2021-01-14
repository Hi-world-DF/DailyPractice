package AlgorithmIdea.binarySearch;
/**
 * 二分查找
 * leetcode:https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/description/
 * 寻找旋转排序数组中的最小值
 * */
public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        int first = 0;
        int last = nums.length -1;
        while(first < last){
            int mid = first+(last-first)/2;
            if(nums[mid] <= nums[last]){
                last = mid;
            }else{
                first = mid+1;
            }
        }
        return nums[first];
    }
    /**
     * 测试
     * */
    public static void main(String[] args){
        int[] nums1 = {3,4,5,1,2};
        int[] nums2 = {4,5,6,7,0,1,2};
        FindMinimumInRotatedSortedArray nums = new FindMinimumInRotatedSortedArray();
        int result1 = nums.findMin(nums1);
        int result2 = nums.findMin(nums2);
        System.out.println(result1);
        System.out.println(result2);
    }
}
