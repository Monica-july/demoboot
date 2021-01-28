package com.sqr.demoboot.zpractice.thread.a_002_atomicxxx;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * volatile只能保证线程可见性 不能保证原子性
 * synchronized既能保证线程可见性又能保证原子性
 * ---------------------------------------------
 * 使用 Atomic
 * 底层CAS实现 无锁 效率更高
 */
public class AtomicityTest_002 {
//    public volatile static int count=0;
    public AtomicLong count = new AtomicLong();
    public void m(){
        for (int i = 0; i <10000 ; i++) {
            count.incrementAndGet();
        }
    }

    public static void main(String[] args) {
        AtomicityTest_002 atomicityTest = new AtomicityTest_002();
        List<Thread> threads = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            threads.add(new Thread(atomicityTest::m,"thread-"+i));
        }
        threads.forEach(t->t.start());
        threads.forEach(t-> {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println(atomicityTest.count.get());
    }
}
