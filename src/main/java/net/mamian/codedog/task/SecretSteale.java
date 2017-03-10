package net.mamian.codedog.task;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * 工作密取模式
 * <p>
 * Created by zhaobs on 17/1/6.
 */
public class SecretSteale {

    private static class Task implements Runnable {
        private static Object object = new Object();
        private static int count = 0;
        public final int id;
        private long putThread;

        public Task() {
            synchronized (object) {
                id = count++;
            }
        }

        @Override
        public void run() {
            if (Thread.currentThread().getId() != putThread) {
                System.out.println("===================================================");
            }
            System.out.println(Thread.currentThread().getId() + ":" + putThread + "// finish job " + id);

        }

        public void setPutThread(long putThread) {
            this.putThread = putThread;
        }
    }

    //生产者
    private static class Consumer implements Runnable {
        //消费者自己的队列
        private final LinkedBlockingDeque<Task> selfTasks;

        //其他消费者的队列
        private final List<LinkedBlockingDeque<Task>> otherTasks;

        public Consumer(LinkedBlockingDeque<Task> selfTasks, List<LinkedBlockingDeque<Task>> otherTasks) {
            this.selfTasks = selfTasks;
            this.otherTasks = otherTasks;
        }

        @Override
        public void run() {
            while (!Thread.interrupted()) {
                try {
                    if (selfTasks.isEmpty()) {//自身任务已处理完毕，去处理别人的任务
                        if (!otherTasks.isEmpty()) {
                            LinkedBlockingDeque<Task> item = choose(otherTasks);
                            if(null != item){
                                item.takeLast().run();
                            }
                        }else{

                        }
                    } else {//先处理自己的任务
                        selfTasks.takeFirst().run();
                    }
                } catch (InterruptedException e) {

                }
            }
        }
    }

    private static LinkedBlockingDeque<Task> choose(List<LinkedBlockingDeque<Task>> tasks){
        LinkedBlockingDeque<Task> result = null;
        int sizeFlag = 0;
        for(LinkedBlockingDeque<Task> item : tasks){
            if(item.size()>sizeFlag){
                sizeFlag = item.size();
                result = item;
            }
        }
        return result;
    }

    //随机产生一些任务用于测试
    private static LinkedBlockingDeque<Task> generateSomeTask() {
        LinkedBlockingDeque<Task> tasks = new LinkedBlockingDeque<>();
        Random random = new Random();
        int count = random.nextInt(5)+1;
        for (int i = 0; i < count; i++) {
            Task w = new Task();
            w.setPutThread(Thread.currentThread().getId());
            try {
                tasks.putLast(w);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return tasks;
    }

    public static void main(String[] args) {
        LinkedBlockingDeque<Task> deque1 = generateSomeTask();
        LinkedBlockingDeque<Task> deque2 = generateSomeTask();
        LinkedBlockingDeque<Task> deque3 = generateSomeTask();

        List<LinkedBlockingDeque<Task>> other41 = Arrays.asList(deque2,deque3);
        List<LinkedBlockingDeque<Task>> other42 = Arrays.asList(deque1,deque3);
        List<LinkedBlockingDeque<Task>> other43 = Arrays.asList(deque1,deque2);

        new Thread(new Consumer(deque1, other41)).start();
        new Thread(new Consumer(deque2, other42)).start();
        new Thread(new Consumer(deque3, other43)).start();
    }

}