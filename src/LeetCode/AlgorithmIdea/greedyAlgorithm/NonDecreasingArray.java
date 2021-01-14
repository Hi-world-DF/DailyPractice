package AlgorithmIdea.greedyAlgorithm;

/**
 * 贪心算法
 * leetcode:https://leetcode-cn.com/problems/non-decreasing-array/
 * 非递减序列
 * */
public class NonDecreasingArray {
    public boolean hasDecreasingArray(int[] nums){
        int n = nums.length;
        //a用来计数，只能修改 1 个数使的数组变为非递减
        int a = 0;
        for (int i = 1;i < n;i++){
            if(nums[i] >= nums[i-1]){
                continue;
            }
            a++;
            if(i-2>=0 && nums[i-2]>nums[i]){
                nums[i]=nums[i-1];
            }else{
                nums[i-1]=nums[i];
            }
        }
        //当不需要改数字或者只需改一次，则为true，否则为false
        return a<=1;
    }
    /**
     * 测试
     * */
    public static void main(String[] args){
        int[] nums ={1,1,1};
        NonDecreasingArray nonDecreasingArray = new NonDecreasingArray();
        boolean result = nonDecreasingArray.hasDecreasingArray(nums);
        System.out.println(result);
    }

}
