package main.model;

import main.validator.MoneyValidator;

import java.util.ArrayList;
import java.util.List;
import main.exception.IllegalMoneyFormatException;
import main.exception.WithdrawInsufficientException;


/**
 * Account class to represent a bank account.
 * Supports read and update operations on the account.
 * An account has a balance and a list of transactions.
 */
public class Account {
    private double balance;
    private List<Transaction> transactionList = new ArrayList<>();

    public void deposit(double amount) throws IllegalMoneyFormatException {
        MoneyValidator.validate(amount);
        balance += amount;
        Transaction transaction = new Transaction(amount, balance);
        transactionList.add(transaction);
    }

    public void withdraw(double amount) throws WithdrawInsufficientException, IllegalMoneyFormatException {
        MoneyValidator.validate(amount);
        if (balance < amount) {
            throw new WithdrawInsufficientException();
        }
        balance -= amount;
        Transaction transaction = new Transaction(-amount, balance);
        transactionList.add(transaction);
    }

    public List<Transaction> getTransactionList() {
        return transactionList;
    }

}
