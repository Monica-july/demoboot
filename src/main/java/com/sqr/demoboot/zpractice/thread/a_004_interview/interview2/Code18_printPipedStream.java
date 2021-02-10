package com.sqr.demoboot.zpractice.thread.a_004_interview.interview2;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.concurrent.LinkedTransferQueue;

/**
 * 两个线程交替打印 a1 b2 c3
 * cas+volatile
 * 变量标识当前运行程序 打印完成后修改变量  该变量需要保证线程间是可见的
 *
 */
public class Code18_printPipedStream {
    public static void main(String[] args) throws InterruptedException, IOException {
        PipedInputStream pis1 = new PipedInputStream();
        PipedInputStream pis2 = new PipedInputStream();
        PipedOutputStream pos1 = new PipedOutputStream();
        PipedOutputStream pos2 = new PipedOutputStream();
        pis1.connect(pos2);
        pis2.connect(pos1);
        Thread t1 = new Thread(()->{
            for (int i=1 ; i<=26 ; i++){
                System.out.print(i);
            }
        });
        Thread t2 = new Thread(()->{
            char c = 'a';
            for (int i=0 ; i<26 ; i++){
                System.out.print(c++);
            }
        });
        t1.start();
        t2.start();
    }
}