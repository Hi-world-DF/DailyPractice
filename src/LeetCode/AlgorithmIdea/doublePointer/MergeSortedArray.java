package LeetCode.AlgorithmIdea.doublePointer;
/**
 * 双指针问题
 * leetcode:https://leetcode-cn.com/problems/merge-sorted-array/
 * 归并两个有序数组
 * */
public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index1 = m-1;
        int index2 = n-1;
        int indexMerge = m+n-1;
        while(index1 >= 0 || index2 >= 0){
            if(index1 < 0){
                nums1[indexMerge] = nums2[index2];
                indexMerge--;
                index2--;
            }else if(index2 < 0){
                nums1[indexMerge] = nums1[index1];
                indexMerge--;
                index1--;
            }else if(nums1[index1] > nums2[index2]){
                nums1[indexMerge] = nums1[index1];
                indexMerge--;
                index1--;
            }else{
                nums1[indexMerge] = nums2[index2];
                indexMerge--;
                index2--;
            }
        }
    }
    /**
     * 测试
     * */
    public static void main(String[] args){
        int[] nums1 = {1,2,3,0,0,0};
        int m = 3;
        int[] nums2 = {2,5,6};
        int n = 3;
        MergeSortedArray mergeSortedArray = new MergeSortedArray();
        mergeSortedArray.merge(nums1,m,nums2,n);
        for(int i =0;i< nums1.length;i++){
            System.out.print(nums1[i]+" ");
        }
    }
}
