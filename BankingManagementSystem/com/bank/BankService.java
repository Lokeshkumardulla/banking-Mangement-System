
package com.bank;

public class BankService {
    private AccountDAO dao = new AccountDAO();

    // Deposit money
    public void deposit(int id, double amount) {
        Account acc = dao.getAccount(id);
        if (acc != null) {
            acc.setBalance(acc.getBalance() + amount);
            dao.updateAccount(acc);
            System.out.println("✅ Deposited " + amount + " into account ID " + id);
        } else {
            System.out.println("⚠ Account not found!");
        }
    }

    // Withdraw money
    public void withdraw(int id, double amount) {
        Account acc = dao.getAccount(id);
        if (acc != null && acc.getBalance() >= amount) {
            acc.setBalance(acc.getBalance() - amount);
            dao.updateAccount(acc);
            System.out.println("✅ Withdrawn " + amount + " from account ID " + id);
        } else {
            System.out.println("⚠ Account not found or insufficient balance!");
        }
    }
}