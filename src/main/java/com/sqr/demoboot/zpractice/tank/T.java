package com.sqr.demoboot.zpractice.tank;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * frame窗口
 */
public class T {
    public static void main(String[] args) {
        Frame frame = new Frame();
        frame.setSize(800,600);
        frame.setResizable(false);
        frame.setTitle("tank war");
        frame.setVisible(true);
        /*
        * 关闭按钮
        * */
        //添加监听器
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println(0);
            }
        });
    }
}
