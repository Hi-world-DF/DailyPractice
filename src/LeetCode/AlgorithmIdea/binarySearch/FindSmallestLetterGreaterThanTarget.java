package LeetCode.AlgorithmIdea.binarySearch;
/**
 * 二分查找
 * leetcode:https://leetcode-cn.com/problems/find-smallest-letter-greater-than-target/
 * 寻找比目标字母大的最小字母
 * */
public class FindSmallestLetterGreaterThanTarget {
    public char nextGreatestLetter(char[] letters, char target) {
        int n = letters.length;
        int first = 0;
        int last = n-1;
        while(first <= last){
            //int mid = (last + first)/2;
            int mid = first+(last-last)/2;
            if(letters[mid] <= target){
                first = mid + 1;
            }else{
                last = mid -1;
            }
        }

        if(first < n){
            //说明可以在letters[]中找到
            return letters[first];
        }else{
            //没找到就返回letters[]第一个元素
            return letters[0];
        }

    }
    /**
     * 测试
     * */
    public static void main(String[] args){
        char[] letters = {'c','f','j'};
        char target = 'i';
        FindSmallestLetterGreaterThanTarget f = new FindSmallestLetterGreaterThanTarget();
        char result = f.nextGreatestLetter(letters,target);
        System.out.println(result);
    }
}
