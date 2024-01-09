package LeetCode.niuke;

import java.util.*;

/**vivo春招笔试题>>>no-pass
 * 问题描述：现给定任意正整数 n，请寻找并输出最小的正整数 m（m>9），
 * 使得 m 的各位（个位、十位、百位 ... ...）之乘积等于n，若不存在则输出 -1。
 * case-eg：
 * input ： 36
 * output ： 49
 * input ： 100
 * output ： 455
 * */
public class segNumAndAdd {

    public static int solution(int n){
        List<Integer> a = new ArrayList<>();
        while(n!=1){
            for(int i = 9;i>=2;i--){
                if(n%i!=0){
                    continue;
                }
                a.add(i);
                n = n/i;
                i=9;
            }
            break;
        }
        Collections.sort(a);
        int result=0;
        for(int i = 0;i<a.size();i++){
            int b = a.get(i);
            for(int j = 1;j<(a.size()-i);j++){
                b = b*10;
            }
            result = result +b;
        }
        return result;
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int result = segNumAndAdd.solution(n);
        System.out.print(result);
    }
}
