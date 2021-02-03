package com.sqr.demoboot.zpractice.thread.a_003_ReentrantLockAndOthers.threadLocal;

import java.lang.ref.SoftReference;

/**
 * 软引用 内存不够时回收
 * 用于缓存
 */
public class T01_SoftReference {
    public static void main(String[] args) {
        SoftReference<byte[]> softReference = new SoftReference<>(new byte[1024*1024*10]);
        System.out.println(softReference.get());
        System.gc();
        byte[] bytes = new byte[1024*1024*15];
        System.out.println(softReference.get());
        System.gc();
        System.out.println(softReference.get());
    }
}
