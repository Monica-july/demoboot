package com.sqr.demoboot.zpractice.thread.a_002_atomicxxx;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

/**
 * volatile只能保证线程可见性 不能保证原子性
 * synchronized既能保证线程可见性又能保证原子性
 * ---------------------------------------------
 * 使用 Atomic
 * 底层CAS实现 无锁 效率更高
 * ---------------------------------------------
 * int
 * AtomicLong
 * LongAdder 分段锁 效率更高
 * 三者效率比较
 * ----------------------------------------------
 */
public class AtomicityTest_003 {
    public volatile static int count1=0;/*需要使用synchronized*/
    public AtomicLong count2 = new AtomicLong(0L);
    public LongAdder count3 = new LongAdder();

    public void m(){
        for (int i = 0; i <10000 ; i++) {
            count1++;
            count2.incrementAndGet();
            count3.add(1);
        }
    }

    public static void main(String[] args) {
        AtomicityTest_003 atomicityTest = new AtomicityTest_003();
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
        System.out.println(atomicityTest.count1);
        System.out.println(atomicityTest.count2.get());
        System.out.println(atomicityTest.count3.longValue());
    }
}
