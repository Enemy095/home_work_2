package org.work.lesson2.part2;

import lombok.Getter;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account {
    @Getter
    private int cacheBalance;
    private final Lock lock1 = new ReentrantLock(true);
    private final Lock lock2 = new ReentrantLock(true);

    public Account(int cacheBalance) {
        this.cacheBalance = cacheBalance;
    }

    public void addMoneyDeadLock(int money) {
        lock1.lock();
        this.cacheBalance += money;
        lock1.unlock();
    }

    public void addMoney(int money) {
        lock2.lock();
        this.cacheBalance += money;
        lock2.unlock();
    }

    public boolean takeOffMoney(int money) {
        lock1.lock();
        if (this.cacheBalance < money) {
            return false;
        }
        lock2.lock();
        this.cacheBalance -= money;
        lock1.unlock();
        lock2.unlock();
        return true;
    }
}
