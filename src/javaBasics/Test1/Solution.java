package Test1;

import java.util.Scanner;

public class Solution {
    public static int[] sortNums(int n,int[] a){
        int[] b = new int[n];
        for(int i = 0;i < n;i++){
            b[i]=a[i];
            for(int j = 0;j<(i+1)/2;j++){
                int temp = b[j];
                b[j]=b[i-j];
                b[i-j]=temp;
            }
        }
        return b;
    }
    public static void main(String[] args){
        Scanner input=new Scanner(System.in);
        int n = input.nextInt();
        int[] a = new int[n];
        for(int i = 0;i < n;i++){
            a[i] = input.nextInt();
        }
        for(int d : Solution.sortNums(n,a)){
            System.out.print(d+" ");
        }
    }

}
