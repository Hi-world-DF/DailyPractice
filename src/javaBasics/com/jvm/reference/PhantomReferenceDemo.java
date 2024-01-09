package javaBasics.com.jvm.reference;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/**
 * 四大引用：虚引用
 * 形同虚设，它不会决定对象的生命周期
 * 若一个对象仅持有一个虚引用，那么它就和没有任何引用一样，在任何时候都可能会被GC
 * 它不能单独使用，也不能通过它访问对象，虚引用必须和引用队列（ReferenceQueue）联合使用
 * 作用：主要跟踪对象被垃圾回收的状态
 * */
public class PhantomReferenceDemo {
    public static void main(String[] args) throws InterruptedException {
        Object obj1 = new Object();
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
        WeakReference<Object> weakReference = new WeakReference<>(obj1,referenceQueue);
        System.out.println(obj1);
        System.out.println(weakReference.get());
        System.out.println(referenceQueue.poll());

        System.out.println("++++++++++++++++++++++++++++++++++++++++");
        obj1 = null;
        System.gc();
        Thread.sleep(500);
        System.out.println(obj1);
        System.out.println(weakReference.get());
        System.out.println(referenceQueue.poll());

    }

}
