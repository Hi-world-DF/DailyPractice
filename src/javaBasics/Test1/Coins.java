package javaBasics.Test1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

public class Coins {

    /**
     * 对二维数组的排序[i][0]或者[i][1]排序
     * */
    public int sortTwoDi(int[][] a){
        Arrays.sort(a, Comparator.comparingInt(o -> o[0]));
        Arrays.sort(a, Comparator.comparingInt(o -> o[1]));
        return 0;
    }

    HashMap<Integer,String> coin = new HashMap<Integer,String>();
    public Coins(){
        coin.put(1,"name1");
        coin.put(2,"name2");
        coin.put(3,"name3");
        coin.put(4,"name4");
        coin.put(4,"name5");
    }
    public String getName(int c){
        if(coin.containsKey(c)){
            return coin.get(c);
        }else {
            return "Not Found This Key!!!";
        }

    }
    public static void main(String []args){
        Scanner in = new Scanner(System.in);
        int cin = in.nextInt();
        Coins co = new Coins();
        String name = co.getName(cin);
        System.out.println(name);
    }
}
