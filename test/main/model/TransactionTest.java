package main.model;

import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TransactionTest {

    @Test
    void toString_validTransaction_success() {
        Date date = new Date();
        Transaction transaction = new Transaction(100.0, 500.0);
        String expected = new SimpleDateFormat("d MMM yyyy hh:mm:ssa").format(date) + " | 100.00  | 500.00 ";
        assertEquals(expected, transaction.toString());
    }
}
