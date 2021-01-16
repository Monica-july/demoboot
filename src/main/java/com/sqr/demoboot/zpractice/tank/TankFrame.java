package com.sqr.demoboot.zpractice.tank;

import com.sqr.demoboot.zpractice.tank.constant.Dir;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * tank大战窗口
 * 重写 frame的 paint方法
 */
public class TankFrame extends Frame {
    int x = 200;
    int y = 200;
    private Dir dir = Dir.DOWN;//方向
    private final static int SPEED = 10;//速度
    public TankFrame(){
        this.setSize(800,600);
        this.setResizable(false);
        this.setTitle("tank war");
        this.setVisible(true);

        //添加 窗口 监听器
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {//正在关闭窗口
                System.exit(0);//退出程序
            }
        });
        //添加 按键 监听器
        this.addKeyListener(new MyKeyListener());
    }



    /**
     * 系统自动调用
     * @param g 画笔
     */
    @Override
    public void paint(Graphics g) {
        //画出一个黑方块
        g.fillRect(x,y,50,50);
        switch (dir){
            case LEFT:
                x -= SPEED;
                break;
            case UP:
                y -= SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
            default:break;
        }
    }

    /**
     * 按键处理  根据按键方向判断坦克移动状态
     */
    class MyKeyListener extends KeyAdapter{
        //按键方向
        boolean bL = false;
        boolean bU = false;
        boolean bR = false;
        boolean bD = false;
        //按键
        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()){
                case KeyEvent.VK_LEFT:
                    bL = true;
                    break;
                case KeyEvent.VK_UP:
                    bU = true;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = true;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = true;
                    break;
                default:break;
            }
            setTankGps();
        }
        //抬起
        @Override
        public void keyReleased(KeyEvent e) {
            switch (e.getKeyCode()){
                case KeyEvent.VK_LEFT:
                    bL = false;
                    break;
                case KeyEvent.VK_UP:
                    bU = false;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = false;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = false;
                    break;
                default:break;
            }
        }
        private void setTankGps(){
            if (bL){
                dir = Dir.LEFT;
            }
            if (bU){
                dir = Dir.UP;
            }
            if (bR){
                dir = Dir.RIGHT;
            }
            if (bD){
                dir = Dir.DOWN;
            }
        }
    }
}
