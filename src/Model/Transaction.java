package Model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Transaction {
    private Date date;
    private double delta;
    private double balance;

    public Transaction(Date date, double delta, double balance) {
        this.date = date;
        this.delta = delta;
        this.balance = balance;
    }

    public Transaction(double delta, double balance) {
        this.date = new Date();
        this.delta = delta;
        this.balance = balance;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("d MMM yyyy hh:mm:ssa");
        return String.format("%-20s | $%-7.2f | $%-7.2f", sdf.format(date), delta, balance);
    }

}
