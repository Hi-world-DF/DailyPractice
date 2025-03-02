package src.leetCode.niuke;

import java.util.Scanner;

/**vivo春招笔试题>>>pass
 * 问题描述：在vivo产线上，每位职工随着对手机加工流程认识的熟悉和经验的增加，日产量也会不断攀升。
 * 假设第一天量产1台，接下来2天(即第二、三天)每天量产2件，接下来3天(即第四、五、六天)每天量产3件 ... ...
 * 以此类推，请编程计算出第n天总共可以量产的手机数量。
 * case-eg：
 * input ： 11
 * output ： 35
 * （第11天工人总共可以量产的手机数量为35）
 *
 * */
public class vivoPhoneNum {
    public static int outNum(int n){
        if(n == 0){
            return 0;
        }
        int realDay = 0;
        for(int i = 1;i < n;i++){
            if(i*(i+1)/2 < n){
                continue;
            }
            for(int j=1;j<i;j++){
                realDay=realDay+j*j;
            }
            realDay = realDay + i*(n-(i-1)*i/2);
            break;
        }
        return realDay;
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int day = in.nextInt();
        System.out.println("第"+day+"天的总产量： "+vivoPhoneNum.outNum(day));
    }
}
