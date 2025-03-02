package src.Test.niuke.test;

import java.util.Scanner;
public class Main {
    public static int treeType(int[][] floor, int n ,int m){
        int num =0;
        int result=1;
        for(int i = 0;i < n;i++){
            for(int j =0;j < m;j++){
                //若碰到岩石，判定下一个
                if(floor[i][j] == 0){
                    continue;
                }
                //上下相邻，左右相邻
                int ud = i==(n-1)?0:floor[i+1][j];
                int lr = j==(m-1)?0:floor[i][j+1];
                //若两个相邻的为1,将后面的1设为0
                if(lr == 1 && floor[i][j]==1){
                    num++;
                }
                if(ud == 1 && floor[i][j]==1){
                    num++;
                }
            }
        }
        for(int i = 0;i<num;i++){
            result *=2;
        }
        return result;
    }
    public static void main(String[] args){
        int m =0;
        int n =0;
        Scanner in =new Scanner(System.in);
        n=in.nextInt();
        m=in.nextInt();
        int[][] floor = new int[n][m];
        //floor = new int[n][m];
        for(int i = 0;i < n;i++) {
            for (int j = 0; j < m; j++) {
                floor[i][j]=in.nextInt();
            }
        }
        int result= Main.treeType(floor,n,m);
        System.out.println(result);
    }
}
