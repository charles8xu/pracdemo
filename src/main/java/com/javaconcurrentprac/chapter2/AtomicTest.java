package com.javaconcurrentprac.chapter2;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 没有多余的竞争条件，只有原子类的操作，线程安全
 */
public class AtomicTest implements Runnable{

    private final AtomicLong count = new AtomicLong(0);

    public long getCount(){
        return count.get();
    }

    @Override
    public void run() {
        count.incrementAndGet();
        System.out.println(this.getCount());
    }

    public static void main(String[] args){
        AtomicTest atomicTest = new AtomicTest();
        Thread a = new Thread(atomicTest);
        Thread b = new Thread(atomicTest);
        Thread c = new Thread(atomicTest);
        a.start();
        b.start();
        c.start();
    }

}
