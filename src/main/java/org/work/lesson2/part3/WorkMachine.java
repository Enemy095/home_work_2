package org.work.lesson2.part3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WorkMachine {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(8);
        for (int i = 0; i < 8; i++) {
            int finalI = i;
            executor.submit(() -> workOnMachine(finalI));
        }
        executor.shutdown();
    }

    private static void workOnMachine(int workerId) {
        try {
            System.out.println("worker " + workerId + " occupy production machine ...");
            Thread.sleep(2000);
            System.out.println("worker " + workerId + " release production machine");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
