package org.work.lesson2.part1;

import java.util.concurrent.atomic.AtomicInteger;

public class Leg2 {
    private static final Object lock = new Object();
    private static AtomicInteger counter = new AtomicInteger(0);
    private String name;

    public Leg2(String name) {
        this.name = name;
    }

    public void run() {
        while (true) {
            synchronized (lock) {
                if (counter.get() >= 100) {
                    lock.notifyAll();
                    break;
                }

                boolean shouldPrint = name.equals("left") == (counter.get() % 2 == 0);

                if (shouldPrint) {
                    System.out.println(name);
                    counter.incrementAndGet();
                    lock.notifyAll();
                } else {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        break;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Leg2 left = new Leg2("left");
        Leg2 right = new Leg2("right");

        new Thread(left::run).start();
        new Thread(right::run).start();
    }
}

