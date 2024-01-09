package javaBasics.com.juc;

/**
 * 函数式接口中可以使用：
 * 1.函数式编程 Lambda表达式怎么写 : 拷贝小括号，写死右箭头，落地大括号
 * 2.@FunctionalInterface
 * 3.default （可定义多个）
 * 4.static 静态方法 （可定义多个）
 * */
//函数式接口
@FunctionalInterface
interface A{
    //public void sayHello();
    public int add(int x);
    public default int sum(int x,int y){
        return x + y;
    }
    public default int sum2(int x,int y){
        return x + y;
    }
    public static int mul(int x,int y){
        return x * y;
    }
    public static int mul2(int x,int y){
        return x * y;
    }
}

public class LambdaExpressDemo02 {
    public static void main(String[] args){
//        A a = new A() {
//            @Override
//            public void sayHello() {
//                System.out.println("Hello world !");
//            }
//
//            @Override
//            public int add(int x) {
//                return 0;
//            }
//        };
//        a.sayHello();
        A a = (int x) -> { System.out.println("Hello LambdaExpress !");return x-1; };
        System.out.println(a.add(3));
        System.out.println(a.sum(4,6));
        System.out.println(A.mul(4,6));
    }
}
