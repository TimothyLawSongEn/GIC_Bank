package Model;

import java.util.ArrayList;
import java.util.List;

// TODO: can have MoneyValidator object
public class Account {
    private int balance;
    private List<Transaction> transactionList = new ArrayList<>();

    public void deposit(double amount) {
        // validation chk for amount

        balance += amount;
        Transaction transaction = new Transaction(amount, balance);
        transactionList.add(transaction);
    }

    public void withdraw(double amount) {
        // validation chk for amount

        // validation chk for balance >= amount (throw exception)

        balance -= amount;
        Transaction transaction = new Transaction(amount, balance);
        transactionList.add(transaction);
    }

    public List<Transaction> getTransactionList() {
        return transactionList;
    }

    //    public String toStringTransactions() {
//        StringBuilder sb = new StringBuilder();
//        sb.append("Date                  | Amount  | Balance");
//        sb.append("/n");
//        sb.append("--------------------------------------------");
//        sb.append("/n");
//        for (Transaction t : transactionList) {
//            sb.append(t.toString());
//        }
//        return sb.toString();
//    }
}
