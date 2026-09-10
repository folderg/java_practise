package org.example;

import java.util.ArrayList;
import java.util.List;

public class ConcurrentBank {

    private final List<BankAccount> accounts = new ArrayList<>();

    public BankAccount createAccount(long initialBalance) {
        BankAccount account = new BankAccount(initialBalance);
        synchronized (accounts) {
            accounts.add(account);
        }
        return account;
    }

    public void transfer(BankAccount from, BankAccount to, long amount) {
        if (from == null || to == null) {
            throw new NullPointerException("Аккаунты не должны быть null");
        }
        if (from == to) {
            return;
        }

        Object firstLock;
        Object secondLock;

        //Упорядочиваем блокировки для предотвращения дедлока
        if (from.getAccountNumber() < to.getAccountNumber()) {
            firstLock = from.getLock();
            secondLock = to.getLock();
        } else {
            firstLock = to.getLock();
            secondLock = from.getLock();
        }

        synchronized (firstLock) {
            synchronized (secondLock) {
                from.withdraw(amount);
                to.deposit(amount);
            }
        }
    }

    public long getTotalBalance() {
        synchronized (accounts) {
            long total = 0;
            for (BankAccount account : accounts) {
                total += account.getBalance();
            }
            return total;
        }
    }
}