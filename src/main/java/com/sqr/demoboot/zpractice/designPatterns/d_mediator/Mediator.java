package com.sqr.demoboot.zpractice.designPatterns.d_mediator;

import com.sqr.demoboot.zpractice.designPatterns.c_factory.abstractFactory.weapon.Weapon;

//开发
abstract class Worker{
    public abstract void to();
    public abstract void doThing();
}
class Programmer extends Worker{
    private Mediator mediator;
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }
    @Override
    public void to(){
        System.out.println("发送请求");
    }
    @Override
    public void doThing() {
        System.out.println("程序员--处理请求");
    }
}
//需求
class DemandAnalyst extends Worker{
    private Mediator mediator;
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }
    @Override
    public void to(){

    }
    @Override
    public void doThing() {
        System.out.println("需求--处理请求");
    }
}
//
class ProjectManager extends Worker{
    private Mediator mediator;
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }
    @Override
    public void to(){

    }
    @Override
    public void doThing() {
        System.out.println("项目经理--处理请求");
    }
}
public class Mediator {
    public void to(Worker worker) {
        worker.doThing();
    }

    public static void main(String[] args) {
        Mediator mediator  = new Mediator();
        Worker programmer  = new Programmer();
        mediator.to(programmer);
    }
}
