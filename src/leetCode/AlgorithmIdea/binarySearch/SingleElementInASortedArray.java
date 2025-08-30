package leetCode.AlgorithmIdea.binarySearch;
/**
 * 二分查找
 * leetcode:https://leetcode-cn.com/problems/single-element-in-a-sorted-array/description/
 * 有序数组中的单一元素
 * */
public class SingleElementInASortedArray {
    public int singleNonDuplicate(int[] nums){
        /**
         * 方法一：没有使用二分法，直接遍历整个数组
         * */
//        int n = nums.length;
//        for(int i = 0;i < n;i++){
//            if(nums[i] == nums[i+1]){
//                i++;
//                continue;
//            }
//            return nums[i];
//        }
//        return nums[n-1];
        /**
         * 方法二：使用二分法（有点牵强，但是时间复杂度低）
         * */
        int first = 0;
        int last = nums.length -1;
        while(first < last){
            //int mid = (first+last)/2;
            int mid = first+(last-first)/2;
            if(mid%2==1){
                //这里保证mid、first、last都是偶数
                mid--;
            }
            //如果nums[mid] == nums[mid+1]则这个单数在后半部分；否则在前半部分
            if(nums[mid] == nums[mid+1]){
                first = mid + 2;
            }else{
                last = mid;
            }
        }
        return nums[first];
    }
    /**
     * 测试
     * */
    public static void main(String[] args){
        SingleElementInASortedArray s =new SingleElementInASortedArray();
        int[] nums = {1,1,2,3,3,4,4,8,8};
        int result = s.singleNonDuplicate(nums);
        System.out.println(result);
    }
}
