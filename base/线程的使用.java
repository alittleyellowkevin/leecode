package base;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class 线程的使用 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /*
        第一种方式：继承Thread后重写run方法
         */
        Thread thread = new ThreadExt();
//        thread.run();
        System.out.println(thread.getName());

        /*
        第二种方式：实现runnable接口
         */
        RunnableImpl runnable = new RunnableImpl();
        Thread thread1 = new Thread(runnable);
        thread1.start();
        System.out.println(thread1.getName());



        /*
        第三种方式：实现callabl接口
         */
        CallableImpl callable = new CallableImpl();
        FutureTask<String> ft = new FutureTask<>(callable);
        Thread thread2 = new Thread(ft);
        thread2.start();
        System.out.println(ft.get());
        System.out.println(thread2.getName());


        /*
        获取当前线程
         */
        Thread thread3 = Thread.currentThread();
        System.out.println("目前的线程："+thread3.getName());
        /*
        设置优先级
         */
        System.out.println("第二种方法的优先级:" + thread1.getPriority());
        System.out.println("第三种方法的优先级:" + thread2.getPriority());
        thread1.setPriority(1);
        thread2.setPriority(10);

        /*
        设置守护线程，当某一线程结束，则运行另一个线程
         */
        thread1.setDaemon(true);


        /*
        线程安全
         */
        ThreadExt threadExt1 = new ThreadExt();
        ThreadExt threadExt2 = new ThreadExt();
        threadExt2.start();
        threadExt1.start();
    }
}
