package leetCode.AlgorithmIdea.binarySearch;
/**
 * 二分查找
 * leetcode:https://leetcode-cn.com/problems/first-bad-version/description/
 * 第一个错误版本
 * */

public class FirstBadVersion{

    public int firstBadVersion(int n){
        int first = 1;
        int last = n;
        while(first < n){
            /**
             * 不要写(first+last)/2
             * 注意：二分的边界
             * */
            int mid = first+(last-first)/2;
            if(isBadVersion(mid)){
                last = mid;
            }else{
                first = mid+1;
            }
        }
        return first;
    }

    private boolean isBadVersion(int i) {
        return false;
    }

    public static void main(String[] args){
        FirstBadVersion firstBadVersion = new FirstBadVersion();
        int result = firstBadVersion.firstBadVersion(5);
        System.out.println(result);
    }
}
