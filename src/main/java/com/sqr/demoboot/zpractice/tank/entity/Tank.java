package com.sqr.demoboot.zpractice.tank.entity;

import com.sqr.demoboot.zpractice.tank.constant.Dir;

import java.awt.*;

public class Tank extends Frame{
    private int x;
    private int y;
    private int SPEED;
    private Dir dir;

    public Tank(int x, int y, int SPEED, Dir dir) {
        this.x = x;
        this.y = y;
        this.SPEED = SPEED;
        this.dir = dir;
    }

    @Override
    public void paint(Graphics g) {
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

}
