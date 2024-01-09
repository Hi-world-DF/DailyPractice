package LeetCode.AlgorithmIdea.binarySearch;

import java.util.Scanner;

/**
 * 二分查找
 * leetcode:https://leetcode-cn.com/problems/sqrtx/description/
 * X的平方根
 * */
public class SqrtX {
    public int mySqrt(int x){
        if(x <= 1){
            return x;
        }
        int first = 1;
        int last = x;
        while(first <= last){
            int mid = first+(last-first)/2;
            int sqrt = x/mid;
            if(sqrt == mid){
                return mid;
            }else if(sqrt < mid){
                last = mid-1;
            }else{
                first = mid+1;
            }
        }
        return last;
    }
    /**
     * 测试
     * */
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        SqrtX sqrtX = new SqrtX();
        int result = sqrtX.mySqrt(x);
        System.out.println(result);
    }
}
