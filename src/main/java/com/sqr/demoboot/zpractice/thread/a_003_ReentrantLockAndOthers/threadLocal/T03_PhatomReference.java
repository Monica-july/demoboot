package com.sqr.demoboot.zpractice.thread.a_003_ReentrantLockAndOthers.threadLocal;

import java.lang.ref.WeakReference;

/**
 * 虚引用 用途 管理堆外内存
 */
public class T03_PhatomReference {
    public static void main(String[] args) {
        WeakReference<M> weakReference = new WeakReference<>(new M());
        System.out.println(weakReference.get());
        System.gc();
        System.out.println(weakReference.get());
    }
}
