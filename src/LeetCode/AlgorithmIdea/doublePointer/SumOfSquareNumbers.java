package LeetCode.AlgorithmIdea.doublePointer;
/**
 * 双指针问题
 * leetcode:https://leetcode-cn.com/problems/sum-of-square-numbers/
 * 两数平方和
 * */
public class SumOfSquareNumbers {
    public boolean judgeSquareSum(int c) {
        int i =0;
        int j =(int) Math.sqrt(c);
        while(i<=j){
            int sum = i*i+j*j;
            if(sum == c){
                return true;
            }else if(sum < c){
                i++;
            }else{
                j--;
            }
        }
        return false;
    }
    /**
     * 测试
     * */
    public static void main(String[] args){
        int c = 5;
        SumOfSquareNumbers sumOfSquareNumbers =new SumOfSquareNumbers();
        boolean result = sumOfSquareNumbers.judgeSquareSum(c);
        System.out.println("能否找到："+result);
    }
}
