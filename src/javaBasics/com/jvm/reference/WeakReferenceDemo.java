package com.jvm.reference;

import java.lang.ref.WeakReference;

/**
 * 四大引用：弱引用
 * java.lang.ref.WeakReference类实现
 * 发生GC就会回收弱引用对象
 * */
public class WeakReferenceDemo {
    public static void main(String[] args){
        Object obj1 = new Object();
        WeakReference<Object> weakReference = new WeakReference<>(obj1);

        System.out.println(obj1);
        System.out.println(weakReference.get());

        obj1 = null;
        System.gc();

        System.out.println(obj1);
        System.out.println(weakReference.get());
    }
}
