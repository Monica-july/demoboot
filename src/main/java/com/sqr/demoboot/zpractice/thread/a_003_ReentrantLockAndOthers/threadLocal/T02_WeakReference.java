package com.sqr.demoboot.zpractice.thread.a_003_ReentrantLockAndOthers.threadLocal;

import java.lang.ref.WeakReference;

/**
 * 弱引用 只要gc就会被回收
 */
public class T02_WeakReference {
    public static void main(String[] args) {
        WeakReference<M> weakReference = new WeakReference<>(new M());
        System.out.println(weakReference.get());
        System.gc();
        System.out.println(weakReference.get());
    }
}
