package org.example;

import java.util.concurrent.atomic.AtomicLong;

public class BankAccount {

    private static final AtomicLong ID_GENERATOR = new AtomicLong(1);

    private final long accountNumber;
    private final Object lock = new Object();
    private long balance;

    public long getAccountNumber() {
        return accountNumber;
    }

    public BankAccount(long initialBalance) {
        this.accountNumber = ID_GENERATOR.getAndIncrement();
        deposit(initialBalance);
    }

    public void deposit(long amount) {
        synchronized (lock) {
            balance += amount;
        }
    }

    public void withdraw(long amount) {
        synchronized (lock) {
            if (balance < amount) {
                throw new IllegalStateException(
                        "Недостаточно средства на аккаунте " + accountNumber + ": баланс=" + balance + ", requested=" + amount);
            }
            balance -= amount;
        }
    }

    public long getBalance() {
        synchronized (lock) {
            return balance;
        }
    }

    Object getLock() {
        return lock;
    }
}