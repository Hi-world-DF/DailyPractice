package javaBasics.com.juc;

import java.util.concurrent.TimeUnit;

/**
 * 8种情况：
 * 1.标准访问，先打印邮件还是短信？先到先得
 * 2.暂停4秒在邮件方法，先打印邮件还是短信：只要
 * 3.新增一个sayHello方法，打印顺序如何？
 * 4.两部手机，请问先打印邮件还是短信
 * 5.两个static同步方法，1部手机，先打印邮件还是短信？
 * 6.两个static同步方法，2部手机，先打印邮件还是短信？
 * 7.一个static 同步方法，1个普通同步方法，同一部手机，先打印邮件还是短信？
 * 8.一个static 同步方法，1个普通同步方法，2部手机，先打印邮件还是短信？
 * */
class Phone{
    public synchronized void sendEmail() throws Exception{
        TimeUnit.SECONDS.sleep(4);
        System.out.println("sendEmail！");
    }
    public synchronized void sendSms() throws Exception{
        System.out.println("sendSms！");
    }
    public void sayHello() throws Exception{
        System.out.println("sayHello！");
    }
}

public class Lock8Demo05 {
    public static void main(String[] args) throws InterruptedException {
        Phone phone1 = new Phone();
        Phone phone2 = new Phone();

        new Thread(()->{
            try {
                Thread.sleep(100);
                phone1.sendEmail();
            }catch (Exception e) {
                e.printStackTrace();
            }
        },"A").start();

        new Thread(()->{
            try {
                phone1.sendSms();
            }catch (Exception e) {
                e.printStackTrace();
            }
        },"B").start();

        new Thread(()->{
            try {
                phone1.sayHello();
            }catch (Exception e) {
                e.printStackTrace();
            }
        },"C").start();
    }
}


/**
 * 笔记：
 * 1.一个对象里面如果有多个synchronized方法，某个时刻内，只要一个线程去调用其中的一个
 * synchronized方法了，那么其他线程只能等待，换句话说就是，某一个时刻内，只能有唯一一个
 * 线程去访问这些synchronized方法。
 * 2.锁的是当前对象this，被锁定后，其他线程都不能进入当前对象的其他synchronized方法。
 * 3.加一个普通方法和同步锁无关
 * 4.换成两个对象后，不是同一把锁，不争抢
 * 5，6.全局锁和对象锁，对象锁锁的是this，全局锁锁的是整个类
 *  synchronized实现同步的基础：Java中的每一个对象都可以作为锁。
 *  具体表现：（1）对于普通同步方法，锁的是当前实例对象；
 *  （2）对于同步方法块，锁是synchronized括号配置的对象；
 *  （3）对于静态方法，锁是当前类的Class对象。
 * 7，8. 当一个线程试图访问同步代码块时，它首先必须得到锁，退出或抛异常时必须释放锁。
 * 也就是说，如果一个实例对象的非静态同步方法获取锁之后，该实例对象的其他非静态同步方法必须等待获取锁的方法释放锁后才能获取锁；
 * 可是别的实例对象的非静态同步方法因为跟该实例对象的非静态同步方法用的是不同的锁，
 * 所以不需要等待该实例对象已获取锁的非静态同步方法释放锁就可以获取他们自己的锁。
 *
 * 所有的静态方法用的也是同一把锁---类对象Class本身；
 * 这两把锁是两个不同的对象，所以静态同步方法和非静态同步方法之间没有竞态条件。
 * 但是一旦一个静态同步方法获取锁之后，其他静态同步方法都必须等待该方法释放锁才能获取锁；
 * 而不管是不是同一个实例对象的静态方法之间，只要他们是同一个类的实例对象。
 *
 * */
