package com.sqr.demoboot.zpractice.thread.b_001_MapDev;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.UUID;

/**
 * 测试
 * Hashtable 自带锁 线程安全  方法上加synchronized
 */
public class C01_HashTable {
    static Hashtable<UUID,UUID> container = new Hashtable<>();
    static UUID[] keys = new UUID[Constant.COUNT];
    static UUID[] values = new UUID[Constant.COUNT];
    static int avgLength = Constant.COUNT/Constant.THREAD_COUNT;
    /*
     * 生成key-value
     * */
    static {
        for (int i = 0; i < Constant.COUNT; i++) {
            keys[i] = UUID.randomUUID();
            values[i] = UUID.randomUUID();
        }
    }
    static class WriteThread extends Thread{
        int start;//当前线程操作的index下标

        public WriteThread(int start) {
            this.start = start;
        }

        @Override
        public void run() {
            for (int i = start; i <start+avgLength ; i++) {
                container.put(keys[i],values[i]);
            }
        }
    }
    static class ReadThread extends Thread{
        int start;//当前线程操作的index下标

        public ReadThread() {
        }

        @Override
        public void run() {
            for (int i = 0; i < Constant.COUNT ; i++) {
                container.get(keys[i]);
            }
        }
    }

    public static void main(String[] args) {
        //写操作
        long start = System.currentTimeMillis();
        List<Thread> writeThreadList = new ArrayList<>();
        for (int i = 0; i < Constant.THREAD_COUNT ; i++) {
            writeThreadList.add(new WriteThread(i*avgLength));
        }
        writeThreadList.forEach(t->t.start());
        writeThreadList.forEach(t-> {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        long end = System.currentTimeMillis();
        System.out.println("write时间："+(end-start));
        System.out.println("container长度："+container.size());
        //读操作
        long startRead = System.currentTimeMillis();
        List<Thread> readThreadList = new ArrayList<>();
        for (int i = 0; i < Constant.THREAD_COUNT ; i++) {
            readThreadList.add(new ReadThread());
        }
        readThreadList.forEach(t->t.start());
        readThreadList.forEach(t-> {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        long endRead = System.currentTimeMillis();
        System.out.println("read时间："+(endRead-startRead));
    }
}
