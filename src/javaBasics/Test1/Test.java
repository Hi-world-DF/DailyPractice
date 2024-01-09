package javaBasics.Test1;
public class Test{
    public static void main(String[] args){
        int f = 0;
        int g = 1;
        for(int i = 0;i <= 15;i++) {
            System.out.println(f);
            f = f + g;
            g = f - g;
        }
    }

}

