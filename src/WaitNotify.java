import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class WaitNotify {

    static int index = 0;

    static Lock lock = new ReentrantLock();
    static Condition condition = lock.newCondition();

    static AtomicInteger integer = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException{

        Thread[] threads = new Thread[2];
        for(int i = 0; i < 2; ++i) {
            threads[i] = new Thread(()-> {
                lock.lock();
                while(index < 100) {
                    index++;
                    System.out.println(Thread.currentThread().getName() + index);
                    condition.signal();
                    try {
                        condition.await();
                    }catch (InterruptedException e) {
                    }
                }
                lock.unlock();
            });
            threads[i].start();
        }
        for(int i = 0; i < 2; ++i) {
            threads[i].join();
        }
    }

}
