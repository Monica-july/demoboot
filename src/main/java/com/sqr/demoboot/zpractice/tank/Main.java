package com.sqr.demoboot.zpractice.tank;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        TankFrame tankFrame = new TankFrame();
        tankFrame.repaint();
        new Thread(()->{
            while (true){
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                tankFrame.repaint();
            }
        }).start();
    }
}
