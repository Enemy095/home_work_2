package org.work.lesson2.part2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AccountThread implements Runnable{
    private final Account accountFrom;
    private final Account accountTo;
    private final int money;
    private final Lock lock1 = new ReentrantLock();
    private final Lock lock2 = new ReentrantLock();

    public AccountThread(Account accountFrom, Account accountTo, int money) {
        this.accountFrom = accountFrom;
        this.accountTo = accountTo;
        this.money = money;
    }

    @Override
    public void run() {
        for (int i = 0; i < 4000; i++) {
            accountFrom.takeOffMoney(money);
            accountTo.addMoney(money);
        }
    }
}

