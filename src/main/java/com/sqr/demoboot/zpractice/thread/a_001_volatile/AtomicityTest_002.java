package com.sqr.demoboot.zpractice.thread.a_001_volatile;

import java.util.ArrayList;
import java.util.List;

/**
 * volatile只能保证线程可见性 不能保证原子性
 * synchronized既能保证线程可见性又能保证原子性
 */
public class AtomicityTest_002 {
    public volatile static int count=0;
    /*synchronized*/ void m(){
        for (int i = 0; i <10000 ; i++) {
            count++;
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
        System.out.println(atomicityTest.count);
    }
}
