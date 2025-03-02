package src.javaBasics.com.concurrent;

/**
 * 阻塞队列
 * */

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class BlockingQueueDemo {
    public static void main(String[] args) throws Exception{
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);
        /**
         * add(),当队列满时，再添加报异常
         * */
        boolean one = blockingQueue.add("a");
        System.out.println(one);
        boolean two = blockingQueue.add("b");
        System.out.println(two);
        boolean three = blockingQueue.add("c");
        System.out.println(three);

//        boolean other = blockingQueue.add("x");
//        System.out.println(other);

        /**
         * remove(),当队列为空时，再删除报异常
         * */
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
//        System.out.println(blockingQueue.remove());

        /**
         * offer(),当队列满时，再添加则返回false
         * */
        System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("b"));
        System.out.println(blockingQueue.offer("c"));
        System.out.println(blockingQueue.offer("d"));

        /**
         * peek(),查看队列头元素
         * */
        System.out.println(blockingQueue.peek());

        /**
         * poll(),当队列为空时，再删除报返回null
         * */
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println("================================================================");

        /**
         * put(),当队列满时，再添加则阻塞等待
         *
         * */
        blockingQueue.put("a");
        blockingQueue.put("b");
        blockingQueue.put("c");
        //blockingQueue.put("d");

        /**
         * take(),当队列为空时，再去获取元素则阻塞
         *
         * */
        blockingQueue.take();
        blockingQueue.take();
        blockingQueue.take();
        //blockingQueue.take();

        System.out.println("================================================================");
        /**
         * offer(e,timeout,unit),当队列满时，
         * 再添加则等待timeout时间，时间过后添加成功则返回true，否则返回false
         * */
        System.out.println(blockingQueue.offer("a",2, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("b",2, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("c",2, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("d",2, TimeUnit.SECONDS));

        /**
         * offer(e,timeout,unit),当队列满时，
         * 再添加则等待timeout时间，时间过后添加成功则返回true，否则返回false
         * */
        System.out.println(blockingQueue.poll(2,TimeUnit.SECONDS));
        System.out.println(blockingQueue.poll(2,TimeUnit.SECONDS));
        System.out.println(blockingQueue.poll(2,TimeUnit.SECONDS));
        System.out.println(blockingQueue.poll(2,TimeUnit.SECONDS));

    }
}
