package com.sqr.demoboot.zpractice.thread.b_002_ListDev;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

public class C03_TicketsSell_SynchronizedList {
    static List<String> ticketsList = Collections.synchronizedList(new ArrayList<>());
    static final int counts = 1000;
    static {
        for (int i = 0; i < counts ; i++) {
            ticketsList.add("ticket---"+i);
        }
    }
    static class SellThread implements Runnable{
        @Override
        public void run() {
            while (ticketsList.size()>0){
                System.out.println("sell"+ticketsList.remove(0));
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10 ; i++) {
            new Thread(new SellThread()).start();
        }
    }
}
