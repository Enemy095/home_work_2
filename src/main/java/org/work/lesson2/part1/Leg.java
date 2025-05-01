package org.work.lesson2.part1;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Leg implements Runnable {
    private final String name;
    private static int counter;
    private final Lock lock1 = new ReentrantLock();


    public Leg(String name) {
        this.name = name;
        counter++;
    }

    public void option1() {
        while (counter < 100) {
            while (counter % 2 == 0) {
                System.out.println(name);
                lock1.lock();
                counter++;
                lock1.unlock();
            }
        }
    }

    @Override
    public void run() {
        option1();
    }

    public static void main(String[] args) {
        CompletableFuture.allOf(
                CompletableFuture.runAsync(new Leg("left")),
                CompletableFuture.runAsync(new Leg("right"))
        ).join();
        System.out.println("end");
    }
}


