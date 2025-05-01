package org.work.lesson2.part3;

import java.util.concurrent.Semaphore;

public class WorkMachineConcurrent {
    private static final Semaphore SEMAPHORE = new Semaphore(5);

    public static void main(String[] args) {
        for (int i = 1; i <= 8; i++) {
            int finalI = i;
            new Thread(() -> workOnMachine(finalI)).start();
        }
    }

    private static void workOnMachine(int workerId) {
        try {
            SEMAPHORE.acquire();
            System.out.println("worker " + workerId + " occupy production machine ...");
            Thread.sleep(2000);
            SEMAPHORE.release();
            System.out.println("worker " + workerId + " release production machine");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
