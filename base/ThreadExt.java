package base;

import com.sun.corba.se.spi.ior.ObjectKey;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadExt extends Thread{
    static int numberOfTickets = 0;

    //锁
    static Lock lock =  new ReentrantLock();
    static Object obj = new Object();
    @Override
    public void run() {
        while(true) {
            try{
                //            synchronized (ThreadExt.class) {
                lock.lock();
                if (numberOfTickets < 100) {
                    System.out.println(Thread.currentThread().getName() + "正在处理票：" + numberOfTickets);
                    numberOfTickets++;
                } else {
                    break;
                }
                //            }
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }
    }
}
