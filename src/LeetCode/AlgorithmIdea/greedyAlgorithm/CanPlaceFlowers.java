package LeetCode.AlgorithmIdea.greedyAlgorithm;
/**
 * 贪心算法
 * leetcode:https://leetcode-cn.com/problems/can-place-flowers/
 * 能否再种下n多花
 * */
public class CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int fNums = flowerbed.length;
        int fMax = 0;
        for(int i = 0;i < fNums;i++){
            if(flowerbed[i] == 1){
                continue;
            }
            int pre = (i==0) ? 0:flowerbed[i-1];
            int next = (i==fNums-1)? 0:flowerbed[i+1];
            if(pre == 0 && next == 0){
                fMax++;
                flowerbed[i] = 1;
            }
        }
        return n <= fMax;
    }
    public static void main(String[] args ){
        CanPlaceFlowers cpf = new CanPlaceFlowers();
        int n = 1;
        int[] flowerbed = {1,0,1,0,1,0};
        boolean result = cpf.canPlaceFlowers(flowerbed,n);
        System.out.println("是否可以种下n朵花"+result);
    }
}
