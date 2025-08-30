package leetCode.everyday;

class Solution {
    //方法1：hashMap
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = -1;
        result[1] = -1;
        if (nums == null || nums.length == 0) {
            return result;
        }
        int pre = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                pre = i;
                break;
            }
        }
        int last = pre;
        result[0] = pre;
        for (int i = pre + 1; i < nums.length; i++) {
            if (nums[i] == target) {
                last = i;
                break;
            }
        }
        result[1] = last;
        return result;
    }
}
