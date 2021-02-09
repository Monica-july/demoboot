package com.sqr.demoboot.zpractice.thread.b_003_queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * 延迟队列
 * 本质是 PriorityQueue 小根堆
 * 定义比较器 制定比较规则 将加入的任务排序 按顺序执行
 * 实现 Delayed接口
 */
public class T06_DelayQueue  {
    static class MyTask implements Delayed {
        String taskName;
        long runningTime;

        public MyTask(String taskName, long runningTime) {
            this.taskName = taskName;
            this.runningTime = runningTime;
        }

        @Override
        public long getDelay(TimeUnit unit) {
            return unit.convert(runningTime - System.currentTimeMillis(),TimeUnit.MILLISECONDS);
        }

        @Override
        public int compareTo(Delayed o) {
            if (o.getDelay(TimeUnit.MILLISECONDS)<this.getDelay(TimeUnit.MILLISECONDS)){
                return -1;
            }
            return 1;
        }

        @Override
        public String toString() {
            return "MyTask{" +
                    "taskName='" + taskName + '\'' +
                    ", runningTime=" + runningTime +
                    '}';
        }
    }

    public static void main(String[] args) throws InterruptedException {
        long now = System.currentTimeMillis();
        MyTask task1 = new MyTask("task-1",now+100);
        MyTask task2 = new MyTask("task-2",now+800);
        MyTask task3 = new MyTask("task-3",now+200);
        MyTask task4 = new MyTask("task-4",now+30);
        BlockingQueue<MyTask> delayQ = new DelayQueue<>();
        delayQ.put(task1);
        delayQ.put(task2);
        delayQ.put(task3);
        delayQ.put(task4);
        for (int i = 0; i < 4 ; i++) {
            System.out.println(delayQ.take());;
        }
    }
}
