package com.javaconcurrentprac.chapter2;


/**
 * 线程不安全的操作，因为自加操作并不是原子操作
 */
public class RaceCondition implements Runnable{

    public long count = 0;

    public long getCount(){
        return count;
    }

    @Override
    public void run() {
        count++;
        System.out.println(this.getCount());
    }

    public static void main(String args[]){
        RaceCondition raceCondition = new RaceCondition();
        Thread a = new Thread(raceCondition);
        Thread b = new Thread(raceCondition);
        Thread c = new Thread(raceCondition);
        Thread d = new Thread(raceCondition);
        Thread e = new Thread(raceCondition);
        a.start();
        b.start();
        c.start();
        d.start();
        e.start();

    }
}
