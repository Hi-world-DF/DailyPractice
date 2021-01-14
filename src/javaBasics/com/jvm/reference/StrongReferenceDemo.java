package com.jvm.reference;
/**
 * 四大引用：强引用
 * 当内存不足，JVM开始垃圾回收机制，对于强引用的对象，就算出现了OOM也不会将该对象进行回收，死都不收
 *
 * */

public class StrongReferenceDemo {
    public static void main(String[] args){
        Object obj1 = new Object();//这样定义默认就是强引用
        Object obj2 = obj1;//obj2引用赋值
        obj1 = null;//置空
        System.gc();
        System.out.println(obj2);
    }
}
