package net.mamian.codedog.analyse;

import net.mamian.codedog.encrypt.strategy.SimpleStrategy;
import net.mamian.codedog.scan.Scanner;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 解析器
 *
 * Created by zhaobs on 17/1/3.
 */
public class Analyzer {

    private static ExecutorService pool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors()+1);

    /**
     * 开始解析
     *
     * @return
     * */
    public Map<Integer, Integer> analyse(){
        //需要处理的所有文件
        List<File> allFiles = Scanner.scan(".java");

        //存储解析结果
        Map<Integer, Integer> result = new ConcurrentHashMap<>();

        //验证是否所有线程的校验都已执行完毕
        CountDownLatch latch = new CountDownLatch(allFiles.size());

        for(File file : allFiles){
            pool.execute(new FileAnalyzerThread(file, result, latch));
        }

        try {
            latch.await();
            return result;
        } catch (InterruptedException e) {
        }finally {
//            pool.shutdown();
        }
        return result;
    }


    class FileAnalyzerThread implements Runnable {

        //本线程要完成的工作内容
        private final File file;

        //存储工作结果
        private final Map<Integer, Integer> result;

        //多个线程共用同一个闭锁
        private final CountDownLatch latch;

        public FileAnalyzerThread(File file, Map<Integer, Integer> result, CountDownLatch latch){
            this.result = result;
            this.file = file;
            this.latch = latch;
        }

        @Override
        public void run(){
            try {//具体逻辑
                SimpleStrategy.encrypt(file);
            }catch (Exception e){
            }finally {
                latch.countDown();
            }
        }
    }
}
