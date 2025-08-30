package Test.niuke.test;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class Reflection {

    /**
     * 构造函数
     * */
    public Reflection(){

    }

    //comparator一个方法实例
    public void comparatorDemo(){
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(-1);
        arrayList.add(3);
        arrayList.add(3);
        arrayList.add(-5);
        arrayList.add(7);
        arrayList.add(4);
        arrayList.add(-9);
        arrayList.add(-7);

        System.out.println("原数组：" + arrayList);

        //调用Collections.reverse来做反转list
        Collections.reverse(arrayList);
        System.out.println("反转后："+arrayList);

        //调用Collections.sort来做做排序，默认升序
        Collections.sort(arrayList);
        System.out.println("排序后：" + arrayList);

        //重写Collections.sort()方法来实现降序排序，可自定义排序
        Collections.sort(arrayList, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        System.out.println("定制后排序：" + arrayList);
    }



    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Reflection re = new Reflection();
        re.comparatorDemo();
    }

}

/**
 * Person类实现Comparable接口，需要重写CompareTo()方法
 * 注意：String类已经默认实现了Comparable接口，详细可以查看String类的API文档，
 * 另外像Integer类等都已经实现了Comparable接口，所以不需要另外实现了
 *
 * */

class Person implements Comparable<Person> {

    private String name;
    private int age;

    public Person(String name,int age){
        super();
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    /**
     * 重写compareTo()来实现按年龄来排序
     *
     * */
    @Override
    public int compareTo(Person o) {

        if(this.age > o.getAge()){
            return 1;
        }
        if(this.age < o.getAge()){
            return -1;
        }

        return 0;
    }

}


class DeadLockDemo{
    //定义两个资源
    private static Object resource1 = new Object();
    private static Object resource2 = new Object();

    public static void main(String[] args) {
        new Thread(() ->{
            synchronized (resource1){
                System.out.println(Thread.currentThread() + "get resource1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread() + "waiting resource2");
            }
            synchronized (resource2){
                System.out.println(Thread.currentThread() + "get resource2");
            }
        },"Thread1").start();

        new Thread(() -> {
            synchronized (resource2){
                System.out.println(Thread.currentThread() + "get resource2");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread()+"waiting resource1");
            }

            synchronized (resource1){
                System.out.println(Thread.currentThread() + "get resource1");
            }
        },"Thread2").start();



    }
}
