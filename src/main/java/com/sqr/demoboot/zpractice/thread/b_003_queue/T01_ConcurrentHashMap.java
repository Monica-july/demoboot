package com.sqr.demoboot.zpractice.thread.b_003_queue;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

public class T01_ConcurrentHashMap {
    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        Map<String,String> map = new ConcurrentHashMap<>();
        List<Thread> threads = new ArrayList<>();
        CountDownLatch latch = new CountDownLatch(100);
        for (int i = 0; i < 100 ; i++) {
            threads.add(new Thread(()->{
                for (int j = 0; j < 10000; j++) {
                    map.put(UUID.randomUUID().toString(),j+"");
                }
                latch.countDown();
            }));
        }
        threads.forEach(t->t.start());
        latch.await();
        long end = System.currentTimeMillis();
        System.out.println(map.size());
        System.out.println(end-start);
    }
}
